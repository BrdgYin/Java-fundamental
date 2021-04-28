package 多线程.s04;

import java.util.concurrent.locks.Lock;

public class Main {
    public static int m = 0;
    public static Lock lock = new MLock(); // AQS

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i ++){
            threads[i] = new Thread(()->{
                lock.lock();
                try {
                    for (int j = 0; j < 1000; j++) {
                        m++;
                    }
                } finally {
                    lock.unlock();
                }
            });
        }

        for(Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join(); // 等待所有线程运行结束
        System.out.println(m);
    }
}
