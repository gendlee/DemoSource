package chap3;

public class Car {
    // 属性（成员变量）
    String model; // 品牌
    String color; // 颜色

    // 构造方法，如果不提供会使用默认的构造函数：public Car() {this.model = null;this.color = null;}
    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    // 方法（行为）
    void run() {
        System.out.println(String.format("%s的%s在奔跑。", color, model));
    }
}
