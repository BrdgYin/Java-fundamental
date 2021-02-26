/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: SpotCar
 * Author:   我们
 * Date:     2021/2/26 17:38
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
public class SpotCar implements Car {
    @Override
    public void run(){
        System.out.println("陆地上运行");
    }

    @Override
    public void show() {
        System.out.println("车所有的功能");
        this.run();
    }
}
