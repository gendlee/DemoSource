package chap3.fourPrinciples;

/**
 * 抽象类：动物
 */
public abstract class Animal {
    // 私有属性，只能通过setter和getter方法访问（体现封装）
    private String name;
    // 抽象方法，需要子类实现
    public abstract void makeSound();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
