package 装饰器模式;

/**
 * 〈一句话功能简述〉<br> 
 * 〈装饰器类〉
 *
 * @author 我们
 * @create 2021/2/26
 * @since 1.0.0
 */
public abstract class CarDecorator implements Car{
    private Car car;

    // 持有的组件引用--构造函数注入
    // 可以调用被装饰者的基本方法
    public CarDecorator(Car car){
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public abstract void show();

}
