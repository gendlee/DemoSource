package chap7.linux;

/**
 * 这个应用我们部署到Linux运行
 */
public class DeployOnLinux {

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (i++ < 10000) {
            System.out.print("当前时间戳：" + System.currentTimeMillis());
            System.out.println("  日志输出：" + i);
            Thread.sleep(2000);
        }
    }

}
