/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: MakeBus
 * Author:   我们
 * Date:     2021/2/20 22:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 模板模式;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 我们
 * @create 2021/2/20
 * @since 1.0.0
 */
public class MakeBus extends MakeCar {
    @Override
    public void CarHeader() {
        System.out.println("bus: 车头");
    }

    @Override
    public void CarBody() {
        System.out.println("bus: 车身");
    }

    @Override
    public void CarTail() {
        System.out.println("bus: 车尾");
    }
}
