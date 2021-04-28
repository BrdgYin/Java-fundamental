package 多线程;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);


        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t" + atomicInteger.get());

        // 由于此时变为了2019--false
        System.out.println(atomicInteger.compareAndSet(5, 1024)+ "\t" + atomicInteger.get());

        atomicInteger.getAndIncrement();
    }
}
