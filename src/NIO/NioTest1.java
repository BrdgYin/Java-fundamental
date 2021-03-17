package NIO;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * 深入理解netty--p32
 */
public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); ++i){
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }

        // 翻转--实现读写的转换
        buffer.flip();

        while(buffer.hasRemaining()){
            System.out.println(buffer.get());
        }
    }
}
