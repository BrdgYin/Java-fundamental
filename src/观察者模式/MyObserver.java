package 观察者模式;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {

    // 通知的调用方法
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("对象发生变化");
    }
}
