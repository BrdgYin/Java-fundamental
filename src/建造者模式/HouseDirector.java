package 建造者模式;

public class HouseDirector {
    // 持有houseBuilder引用
    private HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }

    // 指导具体的过程--模板方法
    public void buildHouse(){
        houseBuilder.buildFloor();
        houseBuilder.buildWall();
        houseBuilder.buildRoof();
    }

}
