package 代理设计模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 〈动态代理类〉<br>
 * 〈〉
 *
 * @author 我们
 * @create 2021/2/16
 * @since 1.0.0
 */
public class DAOProxy implements InvocationHandler {
    // 不能与具体的DAO耦合在一起
    private Object obj ; // 真实主题类--需要代理的

    /**
     * 将真实主题类绑定到代理中，返回一个被代理后的对象
     * @param obj 真实主题类
     * @return 代理后的对象
     */
    public Object bind(Object obj){

        // ！！！！要保存真实主题类--便于后面的方法执行！！！！
        this.obj = obj ;
        /**
         * -----由Java系统实现的代理
         * obj.getClass().getClassLoader() : 通过反射取得该真实主题类的类加载器
         * obj.getClass().getInterfaces() : 通过反射取得真实主题的所有接口
         * this: 由于当前DAOProxy实现了InvocationHandler,所以是代理类
         */
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    public void prepare(){
        System.out.println("*************取消JDBC的自动提交***************");
    }

    public void commit(){
        System.out.println("*************手动提交JDBC事务***************");
    }

    public void rollback(){
        System.out.println("*************手动回滚JDBC事务***************");
    }

    // 只要执行了方法，就会触发执行invoke()方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null ; // 接收结果
        if (method.getName().contains("do")){
            // 取得方法的名称对操作进行判断
            this.prepare();
            try {
                // 反射中的知识--执行方法需要存在类的实例所以要保存this.obj
                result = method.invoke(this.obj, args);
                this.commit();
            } catch (Exception e){
                e.printStackTrace();
                rollback();
            }
        } else{
            // 如果不需要开启事务，则直接执行方法
            result = method.invoke(this.obj, args);
        }
        return result;
    }
}
