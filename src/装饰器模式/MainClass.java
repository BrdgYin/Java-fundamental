package 装饰器模式;

public class MainClass {
    public static void main(String[] args) {
        Car car = new SpotCar();
        car.show();
        System.out.println("-------------------------");
        // 单一实现
        Car flyCar = new FlyCarDecorator(car);
        flyCar.show();
        System.out.println("-------------------------");
        // 单一实现
        Car swimCar = new SwimCarDecorator(car);
        swimCar.show();
        System.out.println("-------------------------");
        // 组合实现
        Car flySwimCar = new FlyCarDecorator(swimCar);
        flySwimCar.show();
    }
}
