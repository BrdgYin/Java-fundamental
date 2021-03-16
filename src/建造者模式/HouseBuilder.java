package 建造者模式;

public interface HouseBuilder {
    // 修地板
    void buildFloor();

    // 修墙
    void buildWall();

    // 修屋顶
    void buildRoof();

    House getHouse();
}
