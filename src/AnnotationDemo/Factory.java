package AnnotationDemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Factory {
    /**
     * 取得工厂类可以实例化的类名称
     * @return 包.类名
     */
    public String className();
}
