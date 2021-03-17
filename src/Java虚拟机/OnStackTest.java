package Java虚拟机;

public class OnStackTest {
    public static void alloc(){
        byte[] b = new byte[2];
        b[0] = 1;
    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i ++){
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println(e - b);
    }
}
