/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: FlyCarDecorator
 * Author:   我们
 * Date:     2021/2/26 21:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 装饰器模式;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 我们
 * @create 2021/2/26
 * @since 1.0.0
 */
public class FlyCarDecorator extends CarDecorator {
    public FlyCarDecorator(Car car) {
        super(car);
    }

    @Override
    public void show() {
        // 调用从父类那儿继承来的getCar()
        // 调用所传入的引用的方法
        this.getCar().show();
        this.fly();
    }

    public void run(){
    }

    public void fly(){
        System.out.println("在空中运行");
    }
}
