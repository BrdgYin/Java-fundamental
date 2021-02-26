/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: CGLIBDemo
 * Author:   我们
 * Date:     2021/2/17 19:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 代理设计模式;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

class FunctionImple{
    public void create(){
        System.out.println("create方法");
    }
}
class MyProxy implements MethodInterceptor{
    private Object object; // 真实操作主题类
    public MyProxy(Object object){
        this.object = object;
    }
    public void prepre(){
        System.out.println("取消自动提交");
    }
    public void commit(){
        System.out.println("提交进行事务操作");
    }
    public void rollback(){
        System.out.println("提交失败，回滚");
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object reuslt = null;
        // 说明proxy是真实类的子类--如果被代理类是Final类就无法使用CGLIB
        // 但是ASM可以对Final进行代理
        System.out.println(proxy.getClass().getSuperclass().getName());
        this.prepre();
        // CGLIB反射调用真实对象方法
        reuslt = methodProxy.invokeSuper(proxy, args);
        this.commit();
        return reuslt;
    }
}
public class CGLIBDemo {
    public static void main(String[] args) {
        // 真实主题对象
        FunctionImple functionImple = new FunctionImple();

        // 创建一个代理工具类
        Enhancer enhancer = new Enhancer();
        // 设置一个模拟的父类
        enhancer.setSuperclass(FunctionImple.class);
        // 设置代理的回调操作
        enhancer.setCallback(new MyProxy(functionImple));
        // 创建代理对象
        FunctionImple proxyDao = (FunctionImple) enhancer.create();
        proxyDao.create();
    }
}

/**
 * 代理设计模式.FunctionImple
 * 取消自动提交
 * create方法
 * 提交进行事务操作
 */
