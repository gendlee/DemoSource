package chap2.fourPrinciples;

/**
 * CatImpl实现接口
 */
public class CatImpl implements AnimalInterface {
    @Override
    public void makeSound() {
        System.out.println("喵喵喵");
    }
}
