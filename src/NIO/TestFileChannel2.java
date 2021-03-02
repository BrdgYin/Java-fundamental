package NIO;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestFileChannel2 {
    public static void main(String[] args) throws Exception{
        // 得到文件描述符
        File file = new File("basic.txt");

        // 得到流对象
        FileInputStream fileInputStream = new FileInputStream(file);

        // 打开通道
        FileChannel fc = fileInputStream.getChannel();

        // 开辟缓存
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());

        // 读取到缓存中
        fc.read(byteBuffer);

        // 读到
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }
}
