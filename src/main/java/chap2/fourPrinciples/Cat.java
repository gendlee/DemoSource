package chap2.fourPrinciples;

/**
 * Cat类继承了抽象类Animal
 */
public class Cat extends Animal {
    // 方法重写
    @Override
    public void makeSound() {
        System.out.println(getName() + ": 喵喵喵");
    }
}
