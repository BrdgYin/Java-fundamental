/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: ClassLoaderDemo
 * Author:   我们
 * Date:     2021/2/13 14:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 类加载;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 我们
 * @create 2021/2/13
 * @since 1.0.0
 */
public class ClassLoaderDemo {
    public static void main(String[] args) throws Exception {
        MyClassLoader mcl = new MyClassLoader();
        Class<?> cls = mcl.getMyClass("类加载.Salgrade");
        System.out.println(cls);
    }
}
