/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: AnnotationTest
 * Author:   我们
 * Date:     2021/2/12 21:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package AnnotationDemo;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class AnnotationTest {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("AnnotationDemo.Money");
        Annotation[]  an = cls.getAnnotations();
        Method method = cls.getMethod("toString");
        Annotation[] annotations = method.getDeclaredAnnotations();
        for (Annotation x : an){
            System.out.println(x);
        }
        for (Annotation x : annotations){
            // Annotation是所有自定义注解的父类需要向下转型
            MyAnnotation myAnnotation = (MyAnnotation) x;
            System.out.println(myAnnotation.num());
        }


    }
}
