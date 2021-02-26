/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: AnnotationFactory
 * Author:   我们
 * Date:     2021/2/12 21:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package AnnotationDemo;

import java.lang.annotation.Annotation;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 我们
 * @create 2021/2/12
 * @since 1.0.0
 */
interface Fruit{
    public void eat();
}

class Apple implements Fruit{
    @Override
    public void eat() {
        System.out.println("Apple");
    }
}


class Orange implements Fruit{
    @Override
    public void eat() {
        System.out.println("Orange");
    }
}

@Factory(className = "AnnotationDemo.Apple")
public class AnnotationFactory {
    public static Fruit getFruit() throws Exception{
        Fruit instance = null;
        // 首先取得工厂类上的注解
        Class<?> cls = Class.forName("AnnotationDemo.AnnotationFactory");
        // 反射得到注解的定义
        Annotation annotation = cls.getAnnotation(Factory.class);
        // 将注解向下转型
        Factory factory = (Factory) annotation;
        // 进行实例化
        instance = (Fruit) Class.forName(factory.className()).newInstance();
        return instance;
    }
    public static void main(String[] args) throws Exception{
        Fruit fruit = getFruit();
        fruit.eat();
        System.out.println(Fruit.class.getClassLoader());
    }
}
