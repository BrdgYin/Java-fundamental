package 建造者模式;

public class MainClass {
    public static void main(String[] args) {
//        //直接搭建
//        House house = new House();

//        house.setFloor("地板");
//        house.setWall("墙");
//        house.setRoof("屋顶");

        // 需要用到的具体建造者
        HouseBuilder villaBuilder = new villaBuilder();
        HouseBuilder plainHouseBuilder = new PlainHouseBuilder();

        // 由设计者来设计--并将任务分配给建造者
        HouseDirector houseDirector = new HouseDirector(plainHouseBuilder);
        // 构建指令
        houseDirector.buildHouse();

        System.out.println(plainHouseBuilder.getHouse());

    }
}
