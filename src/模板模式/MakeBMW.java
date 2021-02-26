/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: MakeBMW
 * Author:   我们
 * Date:     2021/2/20 22:32
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
public class MakeBMW extends MakeCar {
    @Override
    public void CarHeader() {
        System.out.println("BMW: 车头");
    }

    @Override
    public void CarBody() {
        System.out.println("BMW: 车身");
    }

    @Override
    public void CarTail() {
        System.out.println("BMW: 车尾");
    }
}
