package mvcframework.servlet;

import mvcframework.GPAutowried;
import mvcframework.GPController;
import mvcframework.GPRequestMapping;
import mvcframework.GPService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class GPDispatcherServlet extends HttpServlet {
    private Properties properties = new Properties();
    private List<String> classNames = new ArrayList<String>();

    // 声明IOC容器
    private Map<String, Object> ioc = new HashMap<String, Object>();

    // url与方法的映射表
    private Map<String, Method> handlerMapping = new HashMap<String, Method>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 1.加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));

        // 2.扫描所有相关的类
        doScanner(properties.getProperty("scanPackage"));

        // 3.初始化相关的实例，并且保存到IOC容器
        doInstance();

        // 4.自动注入
        doAutowired();
        
        // 5.初始化HandlerMapping
        initHandlerMapping();


        System.out.println("我的MVC");
    }

    private void initHandlerMapping() {
        if (ioc.isEmpty()){
            return;
        }
        for(Map.Entry<String, Object> entry : ioc.entrySet()){
            Class<?> clazz = entry.getValue().getClass();
            
            // 只对带有RequestMapping注解的方法处理
            if (!clazz.isAnnotationPresent(GPRequestMapping.class)){
                continue;
            }
            String url = "";
            if (clazz.isAnnotationPresent(GPRequestMapping.class)){
                GPRequestMapping requestmapping = clazz.getAnnotation(GPRequestMapping.class);
                url = requestmapping.value();
            }
            
            // 并不需要对私有的方法进行访问
            // 获取所有的方法
            Method[] methods = clazz.getMethods();

            // 判断是否带有当前的标签GPRequestMapping
            for (Method method : methods){
                if (!method.isAnnotationPresent(GPRequestMapping.class)){
                    continue;
                }
                GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);
                String murl = url + requestMapping.value();

                // 将对应的url与对应的方法联系起来
                handlerMapping.put(murl, method);

            }


        }
    }

    private void doAutowired() {
        if (ioc.isEmpty()){
            return;
        }
        for(Map.Entry<String, Object> entry : ioc.entrySet()){
            // 获取所有的ioc中的实例中的属性
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            // 对属性进行遍历获取带有@GPAutowired注解的属性
            for (Field field : fields){
                // 对是否有注解进行判断
                if (!field.isAnnotationPresent(GPAutowried.class)){
                    continue;
                }
                GPAutowried gpAutowried = field.getAnnotation(GPAutowried.class);
                String beanName = gpAutowried.value().trim();
                if ("".equals(beanName)){
                    beanName = field.getType().getName();
                }

                // 如果是私有的必须要设置成可访问的
                field.setAccessible(true);
                try {
                    field.set(entry.getValue(), ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    private void doInstance() {
        if (classNames.isEmpty()){
            return;
        }
        try {
            for (String className : classNames) {
               Class<?> clazz =  Class.forName(className);

                // 进行实例化，原则问题
                // 只有加了@GPAutowired才给初始化
                if (clazz.isAnnotationPresent(GPController.class)){
                    // beanName beanID
                    // 1.采用类名首字母小写
                    // 2.默认优先使用自定义的
                    // 3.根据类型匹配，利用实现类的接口作为key
                    String beanName = clazz.getSimpleName();
                    ioc.put(beanName, clazz.newInstance());

                } else if (clazz.isAnnotationPresent(GPService.class)){
                    // beanName beanID
                    // 1.采用类名首字母小写
                    // 2.默认优先使用自定义的
                    // 3.根据类型匹配，利用实现类的接口作为key
                    Object instance = clazz.newInstance();

                    GPService service = clazz.getAnnotation(GPService.class);
                    String beanName = service.value();
                    if ("".equals(beanName.trim())){
                        beanName = lowerFirst(clazz.getSimpleName());
                    }
                    ioc.put(beanName, instance);
                    Class<?>[] interfaces = clazz.getInterfaces();
                    for(Class<?> i : interfaces){
                        ioc.put(i.getName(), instance);
                    }

                } else {
                    continue;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void doLoadConfig(String location){
        // 获得inputStream
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(location);

        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void doScanner(String packageName){

        final URL url = this.getClass().getClassLoader().getResource("/" + packageName.replaceAll("\\.", "/"));
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()){
            if (file.isDirectory()){
                doScanner(packageName + "." + file.getName());
            } else {
                String className = packageName + "." + file.getName().replace(".class", "");
                classNames.add(className);
            }
        }

    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        // 获取到当前的请求的url
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();

        String url = uri.replace(contextPath, "").replace("/+", "/");

        if (!handlerMapping.containsKey(url)){
            resp.getWriter().write("404");
            return;
        }

        // 反射调用方法
        Method method = handlerMapping.get(url);
        // Object object = method.invoke();

        // 获得相对应的方法

    }

    private String lowerFirst(String str){
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
