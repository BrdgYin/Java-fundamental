package 多线程;


class ThreadEvent extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
public class SynchronizedDemo {
    public static void main(String[] args) {
        ThreadEvent event = new ThreadEvent();

        for(int i = 0;i < 5; i ++){
            new Thread(event).start();
        }
    }
}
