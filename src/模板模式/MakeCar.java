/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: MakeCar
 * Author:   我们
 * Date:     2021/2/20 22:27
 * Description: 组装车
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 模板模式;

/**
 * 〈一句话功能简述〉<br> 
 * 〈组装车〉
 *
 * @author 我们
 * @create 2021/2/20
 * @since 1.0.0
 */
public abstract class MakeCar {
    // 模板方法--统一的操作步骤
    public void make(){
        this.CarHeader();
        this.CarBody();
        this.CarTail();
    }

    // 组装车头
    public abstract void CarHeader();

    // 组装车身
    public abstract void CarBody();

    // 组装车尾
    public abstract void CarTail();
}
