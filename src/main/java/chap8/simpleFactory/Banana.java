package chap8.simpleFactory;

// 香蕉类
public class Banana implements Fruit {
    @Override
    public void getType() {
        System.out.println("这是一个香蕉");
    }
}
