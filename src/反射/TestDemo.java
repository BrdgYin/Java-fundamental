package 反射;
import java.lang.reflect.Field;

class Person {
    private String name;
    private int age ;

}
public class TestDemo{
    public static void main(String[] args) throws Exception{
        // 取得class对象
        Class<?> cls = Class.forName("反射.Person");
        // 对象实例化属性才会分配空间
        Object obj = cls.newInstance();
        // 找到name属性
        Field nameField = cls.getDeclaredField("name");
        Field ageField = cls.getDeclaredField("age");
        // 解除封装
        nameField.setAccessible(true);
        ageField.setAccessible(true);
        // 给属性设置值
        nameField.set(obj, "是个人");
        ageField.set(obj, 100);
        // 取得属性
        System.out.println(nameField.get(obj));
        System.out.println(ageField.get(obj));
    }
}
/*
output:
        是个人
        100
*/
