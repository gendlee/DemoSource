package chap8.simpleFactory;

public class FruitFactoryTest {
    public static void main(String[] args) {
        // 通过工厂类创建苹果对象
        Fruit apple = FruitFactory.createFruit("apple");
        apple.getType();  // 输出: 这是一个苹果。

        // 通过工厂类创建香蕉对象
        Fruit banana = FruitFactory.createFruit("banana");
        banana.getType();  // 输出: 这是一个香蕉
    }
}
