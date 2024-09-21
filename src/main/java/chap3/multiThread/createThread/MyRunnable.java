package chap3.multiThread.createThread;

/**
 * 实现Runnable接口创建线程
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Runnable实现的线程: " + i);
            try {
                Thread.sleep(1000); // 使当前线程休眠1秒
            } catch (InterruptedException e) {
                System.out.println("线程终止");
            }
        }
    }
    public static void main(String[] args) {
        // 创建Runnable实现类的实例
        MyRunnable myRunnable = new MyRunnable();
        // 创建Thread对象，并将Runnable实例传递给Thread构造函数
        Thread thread = new Thread(myRunnable);
        // 启动线程
        thread.start();
    }
}
