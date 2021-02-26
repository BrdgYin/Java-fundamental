package 观察者模式;

public class MainClass {
    public static void main(String[] args) {
        Person person = new Person("张三", "man", 21);
        // 注册观察者
        person.addObserver(new MyObserver());

        person.setAge(11);
        person.setName("哈哈");

    }
}
