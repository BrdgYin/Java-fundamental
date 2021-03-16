package 建造者模式;

public class villaBuilder implements HouseBuilder{
    private House house = new House();

    @Override
    public void buildFloor() {
        this.house.setFloor("别墅地板");
    }

    @Override
    public void buildWall() {
        this.house.setWall("别墅的墙板");
    }

    @Override
    public void buildRoof() {
        this.house.setRoof("别墅的屋顶");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
