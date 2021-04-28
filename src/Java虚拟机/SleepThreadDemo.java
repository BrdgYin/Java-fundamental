package Java虚拟机;

public class SleepThreadDemo implements Runnable{
    @Override
    public void run() {
        try{
            Thread.sleep(10000000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(new SleepThreadDemo(), "Thread " +i).start();
            System.out.println("Thread " + i + "created");
        }
    }
}
