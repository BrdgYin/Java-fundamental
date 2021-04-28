package Java虚拟机;

import java.util.HashMap;
class ThreadDemo extends Thread {
    HashMap<Long, byte[]> map = new HashMap<>();

    @Override
    public void run() {
        try {
            while(true){
                if (map.size() * 512/1024/1024 >= 450){
                    System.out.println("=====准备清理=====:"+map.size());
                    map.clear();
                }

                for (int i = 0; i < 1024; i ++){
                    map.put(System.nanoTime(), new byte[512]);

                }
                Thread.sleep(1);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}


public class MyThread extends Thread {
    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        new Thread(demo).start();
    }
}
