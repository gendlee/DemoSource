package chap3.fourPrinciples;

/**
 * 实现接口
 */
public class DogImpl implements AnimalInterface {
    @Override
    public void makeSound() {
        System.out.println("汪汪汪");
    }
}
