package Java虚拟机;

public class TestHeap1 {
    public static void main(String[] args) {
        System.out.println("Xmx=");
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024 + "M");

        System.out.println("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024 + "M");

        System.out.println("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024 + "M");


    }
}
