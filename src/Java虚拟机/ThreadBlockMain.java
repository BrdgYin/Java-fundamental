package Java虚拟机;

public class ThreadBlockMain {
    public static void main(String[] args){
            new Thread(() -> {
                try {
                    System.out.println("thread1 is running");
                    synchronized (ThreadBlockMain.class) {
                        System.out.println("thread is block obj1");

                        Thread.sleep(1000);
                        synchronized (Object.class) {
                            System.out.println("thread is block ojb2");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(() -> {
                try {
                    System.out.println("thread1 is running");
                    synchronized (Object.class) {
                        System.out.println("thread is block obj1");

                        Thread.sleep(1000);
                        synchronized (ThreadBlockMain.class) {
                            System.out.println("thread is block ojb2");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
    }
}
