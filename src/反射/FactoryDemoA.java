/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: FactoryDemoA
 * Author:   我们
 * Date:     2021/2/9 19:23
 * Description: 工厂模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 反射;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈工厂模式〉
 *
 * @author 我们
 * @create 2021/2/9
 * @since 1.0.0
 */
interface People{
    void say();
}
class Man implements People, Serializable {
    @Override
    public void say() {
        System.out.println("男人");
    }
}
class Woman implements People, Serializable{
    @Override
    public void say() {
        System.out.println("女人");
    }
}
class Factory{
    // 工厂类是为了People服务
    public static People getInstance(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        People people = (People)Class.forName(className).newInstance();
        return people;
    }
}
public class FactoryDemoA {
    public static void main(String[] args) throws Exception{
        // 客户端不关心对象从哪儿来，只关心能不能取得对象
        People f = Factory.getInstance("反射.Man");
        f.say();
    }
}
