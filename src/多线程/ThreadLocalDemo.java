package 多线程;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalDemo {
    private static ThreadLocal<List<String>> threadLocal = new ThreadLocal<>();

    public void setThreadLocal(List<String> value){
        threadLocal.set(value);
    }

    public void getThreadLocal(){
        threadLocal.get().forEach(name-> System.out.println(Thread.
                currentThread().getName() + ":" + name));
    }

    public static void main(String[] args) {
        // 这是全局的，放在堆里
        final ThreadLocalDemo demo = new ThreadLocalDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> strs = new ArrayList<>();
                strs.add("1");
                strs.add("2");
                strs.add("3");
                demo.setThreadLocal(strs);
                demo.getThreadLocal();
            }
        }, "t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> strs = new ArrayList<>();
                strs.add("a");
                strs.add("b");
                demo.setThreadLocal(strs);
                demo.getThreadLocal();
            }
        }, "t2").start();
    }
}

/*
output:
        t1:1
        t1:2
        t1:3
        t2:a
        t2:b
*/
