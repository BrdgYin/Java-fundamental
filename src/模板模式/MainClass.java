/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: MainClass
 * Author:   我们
 * Date:     2021/2/20 22:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 模板模式;

/**
 * 〈一句话功能简述〉<br> 
 * 〈这个了java已经帮你想好了，在new的时候，是哪个实现类，
 * 当你调用的时候就会走哪个类，即便你后面调用的是抽象类的抽象方法，
 * 向上转型不会丢失实现类的信息的〉
 *
 * @author 我们
 * @create 2021/2/20
 * @since 1.0.0
 */
public class MainClass {
    public static void main(String[] args) {
        MakeCar bus = new MakeBus();
//        bus.CarHeader();
//        bus.CarBody();
//        bus.CarTail();
        // 由抽象类来自动确定调用的实例方法【细节不同】
        bus.make();

        System.out.println("——————————————————————————————");
        MakeCar bmw = new MakeBMW();
//        bmw.CarHeader();
//        bmw.CarBody();
//        bmw.CarTail();
        // 由抽象类来自动确定调用的实例方法【细节不同】
        bmw.make();
    }
}
/*output:
        bus: 车头
        bus: 车身
        bus: 车尾
        ——————————————————————————————
        BMW: 车头
        BMW: 车身
        BMW: 车尾
*/
