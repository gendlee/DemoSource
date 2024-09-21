package chap3.fourPrinciples;

public class AnimalTest {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.setName("猫");

        Animal dog = new Dog();
        dog.setName("狗");

        cat.makeSound(); // 输出：猫: 喵喵喵
        dog.makeSound(); // 输出：狗: 汪汪汪

        // 接口定义的
        AnimalInterface cat1 = new CatImpl();
        AnimalInterface dog1 = new DogImpl();
        cat1.makeSound(); // 输出：喵喵喵
        dog1.makeSound(); // 输出：汪汪汪
    }
}
