package 建造者模式;

public class PlainHouseBuilder implements HouseBuilder{

    private House house = new House();// 持有一个引用


    @Override
    public void buildFloor() {
        house.setFloor("普通的地板");
    }

    @Override
    public void buildWall() {
        house.setWall("普通的墙板");
    }

    @Override
    public void buildRoof() {
        house.setRoof("普通的屋顶");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
