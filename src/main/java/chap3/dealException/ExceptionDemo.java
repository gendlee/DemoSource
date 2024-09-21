package chap3.dealException;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            // 可能引发数组越界异常：ArrayIndexOutOfBoundsException
            System.out.println(numbers[5]);
            System.out.println(numbers[0]); // 不会执行到
        } catch (ArithmeticException e) {
            System.out.println("运行时算术异常: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("编译时数组越界异常: " + e.getMessage());
        } finally {
            System.out.println("最后执行finally");
        }
    }
}
