package chap9.designPattern.simpleFactory;

// 简单工厂类
public class FruitFactory {
    // 工厂方法，根据传入的水果类型创建对应的水果对象
    public static Fruit createFruit(String type) {
        if (type.equalsIgnoreCase("apple")) {
            return new Apple();
        } else if (type.equalsIgnoreCase("banana")) {
            return new Banana();
        } else {
            throw new IllegalArgumentException("未知的水果类型: " + type);
        }
    }
}

