package 装饰器模式;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 我们
 * @create 2021/2/26
 * @since 1.0.0
 */
public class SwimCarDecorator extends CarDecorator{

    public SwimCarDecorator(Car car){
        super(car);
    }

    @Override
    public void show(){
        // 调用所传入的引用的基本的方法
        getCar().show();
        // 自己特殊的方法
        swin();
    }

    // 自己特殊的方法
    public void swin(){
        System.out.println("在水中运行");
    }

    @Override
    public void run() {

    }
}
