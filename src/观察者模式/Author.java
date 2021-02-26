package 观察者模式;
import java.util.Observable;

public class Author extends Observable {
    public void publish(String title, String content){
        System.out.println("title: " + title + ", content: " + content);
        this.setChanged(); // 设置属性改变
        this.notifyObservers(); // 通知所有的观察者
    }
}
