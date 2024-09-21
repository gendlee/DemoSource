package chap3.multiThread.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
            Thread.sleep(200); // 模拟耗时操作
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 创建Callable任务
        MyCallable myCallable = new MyCallable();

        // 提交Callable任务，并获取Future对象
        Future<Integer> future = executor.submit(myCallable);

        // 获取Callable任务的返回值
        Integer result = future.get();  // 阻塞直到任务执行完毕
        System.out.println("多线程返回的结果: " + result);

        // 关闭线程池
        executor.shutdown();
    }
}
