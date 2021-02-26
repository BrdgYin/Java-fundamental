package 观察者模式;

import java.util.Observable;

// Observable相当于一个容器--提供一些基本的方法
public class Person extends Observable {
    private String name;
    private String sex;
    private int age;

    public Person(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        // 手动设置改变
        this.setChanged();
        // 属性改变时 通知观察者
        this.notifyObservers();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        this.notifyObservers();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        this.notifyObservers();
    }
}
