package chap9.simpleFactory;

// 苹果类
public class Apple implements Fruit {
    @Override
    public void getType() {
        System.out.println("这是一个苹果");
    }
}
