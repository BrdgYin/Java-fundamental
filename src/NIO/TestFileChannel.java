package NIO;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// 往本地文件中写数据
public class TestFileChannel {
    public static void main(String[] args) throws Exception{
        String str = "hello, nio, 我是哈哈";
        // 通过输出流中获取到Channel
        FileOutputStream fos = new FileOutputStream("basic.txt");
        FileChannel fc = fos.getChannel();
        // 设置缓存区的初始容量
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 在往channel中写入数据时，必须通过put方法存到ByteBuffer
        byteBuffer.put(str.getBytes());
        // 反转缓存区，重置位置到初始位置(将指针重置到head)
        byteBuffer.flip();
        fc.write(byteBuffer);
        fos.close();
    }
}
