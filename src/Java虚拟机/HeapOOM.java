package Java虚拟机;

import java.util.ArrayList;

public class HeapOOM {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 10240; i ++){
            list.add(new byte[1024 * 1024]);
        }
    }
}
