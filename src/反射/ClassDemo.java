/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: ClassDemo
 * Author:   我们
 * Date:     2021/2/9 17:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 我们
 * @create 2021/2/9e
 * @since 1.0.0
 */
public class ClassDemo {
    public static void main(String[] args) throws Exception {
        //Member dept = new Member();                   // 调用的是无参构造
        /*Class<?> cls = Class.forName("反射.Member");
        Object obj = cls.newInstance();               // 实例化对象<无参构造>
        System.out.println(cls.getPackage().getName()); // 取得包名
        System.out.println(cls.getName());              // 包名.类
        System.out.println(cls.getSimpleName());        // 只要类名不要包名
        System.out.println(cls.getSuperclass().getSimpleName());
        Class<?>[] icls = cls.getInterfaces();          // 取得全部接口
        for (int x = 0; x < icls.length ; x++){         // 遍历所有的接口
            System.out.println(icls[x].getSimpleName());
        }*/
        /*Class<?> cls = Class.forName("反射.Member");
        Constructor<?>[]  constructors = cls.getConstructors(); // 取得全部构造
        for (Constructor x : constructors){
            StringBuffer bf = new StringBuffer();
            // 修饰符--修饰符需要用到Modifier中的toString
            bf.append(Modifier.toString(x.getModifiers())).append(" ") ;
            bf.append(x.getName()).append(" ("); // 构造方法名称
            Class<?>[] params = x.getParameterTypes(); // 取得全部参数类型
            if (params.length > 0){
                // 有参数
                for(int i = 0; i < params.length; i ++ ){
                    bf.append(params[i].getSimpleName()).append(" ref").append(i).append(",");
                }
                bf.delete(bf.length() - 1, bf.length()); // 删除最后的逗号

            }
            bf.append(")");
            Class<?> exp[] = x.getExceptionTypes();
            if (exp.length > 0){
                bf.append(" throws ");
                for (int i = 0; i < exp.length; i ++){
                    bf.append(exp[i].getSimpleName()).append(",");
                }
                bf.delete(bf.length() - 1, bf.length()); // 删除最后的逗号
            }
            System.out.println(bf.toString());
        }
        Constructor con = cls.getConstructor(String.class, String.class); // 获取具体的构造方法
        Object obj = con.newInstance("11", "22");               // 进行实例化*/
        /*Class<?> cls = Class.forName("反射.Member");
        Object obj = cls.newInstance(); // 实例化对象
        Method[] methods = cls.getDeclaredMethods();
        for (Method x : methods){
            System.out.println(x);
        }
        Method m1 = cls.getMethod("toString");
        Method m2 = cls.getMethod("getNum", int.class, String.class);
        Object r1 = m1.invoke(obj);
        System.out.println(r1);
        m2.invoke(obj,11, "哈哈");*/

        Class<?> cls = Class.forName("反射.Message");
        // 取得全部成员
        Field[] fields = cls.getFields();
        for (Field x : fields){
            System.out.println(x);
        }


    }
}
/*output:
public 反射.Member ()
public 反射.Member (String ref0,String ref1)
                     throws NumberFormatException,
                            NullPointerException
*/

