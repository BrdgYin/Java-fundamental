package HashMapDemo;

import java.util.HashMap;

public class ArrayDemo {
    // 数组:采用一段连续的存储单元来存储数据
    // 节点: 指定下标O(N), 数组: 查询快 插入慢
    public static void main(String[] args) {
        Integer[] integers  = new Integer[10];
        integers[0] = 0;
        integers[1] = 1;
        integers[2] = 2;
        integers[3] = 3;
        integers[4] = 4;
        System.out.println(integers[4]);
    }
}
