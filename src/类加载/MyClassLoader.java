/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: MyClassLoader
 * Author:   我们
 * Date:     2021/2/13 20:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 类加载;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 我们
 * @create 2021/2/13
 * @since 1.0.0
 */
//通过文件加载类
public class MyClassLoader extends ClassLoader {
    // 只是定义了一个类加载器的结构，骨子里还是通过CLASSPATH加载类
    public Class<?> getMyClass(String className) throws ClassNotFoundException{
        byte[] d = this.getFileData(className);
        return super.defineClass(className, d, 0, d.length);
    }

    // example: 类加载.Salgrade
    private byte[] getFileData(String className){
        byte[] result = null;
        try {
            File file = new File("E:" + File.separator + className.substring(className.lastIndexOf(".") + 1)+".class");
            // 输入流
            InputStream input = new FileInputStream(file);
            // 内存输出流
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            // 每次读入的大小
            byte[] data = new byte[1024] ;
            int len = 0;
            while((len = input.read(data)) != -1){
                bos.write(data, 0, len);
            }
            result = bos.toByteArray();
            bos.close();
            input.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    // 加载网上类文件
    private byte[] getNetData(String className){
        byte[] result = null;
        try {
            URL url = new URL("http://localhost/ReflectDemo/Salgrad");
            InputStream input = url.openStream();
            // 内存输出流
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            // 每次读入的大小
            byte[] data = new byte[1024] ;
            int len = 0;
            while((len = input.read(data)) != -1){
                bos.write(data, 0, len);
            }
            result = bos.toByteArray();
            bos.close();
            input.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
