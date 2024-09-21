package chap3.fourPrinciples;

/**
 * Dog类继承了抽象类Animal
 */
public class Dog extends Animal {
    // 方法重写
    @Override
    public void makeSound() {
        System.out.println(getName() + ": 汪汪汪");
    }

    // 方法重载
    public void makeSound(String name) {
        System.out.println(name + "：汪汪汪");
    }
}
