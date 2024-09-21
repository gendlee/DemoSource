package chap3.multiThread.createThread;

/**
 * 继承Thread类创建线程
 */
public class MyThread extends Thread {
    // 重写run方法
    @Override
    public void run() {
        // 线程执行的代码逻辑
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(1000); // 使当前线程休眠1秒
            } catch (InterruptedException e) {
                System.out.println("线程终止");
            }
        }
    }

    public static void main(String[] args) {
        // 创建线程对象
        MyThread thread = new MyThread();
        // 启动线程
        thread.start();
    }
}