package chap9.singleton;

public class Singleton {
    // 特点1：静态私有成员变量
    private volatile static Singleton instance;
    // 特点2：私有构造函数
    private Singleton() {
    }
    // 特点3：公有的静态工厂方法
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
