package Java虚拟机;

// 全局停顿的实例
public class PrintThread extends Thread {
    public static final long starttime = System.currentTimeMillis();

    @Override
    public void run() {
        try{
            while(true){
                long t = System.currentTimeMillis() - starttime;
                System.out.println("time" + t);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
