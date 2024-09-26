package chap4.array;

public class ArrayTest {
    public static void main(String[] args) {
        // 定义数组
        int[] myArray = new int[]{-1, 5, 8, 4, 7, 0};
        // 数组长度
        int length = myArray.length;

        // 正向遍历
        for (int i = 0; i <= length - 1; i++) {
            System.out.print(myArray[i] + " "); // 输出：-1 5 8 4 7 0
        }
        System.out.println();

        // 逆向遍历
        for (int i = length - 1; i >= 0; i--) {
            System.out.print(myArray[i] + " ");  // 输出：0 7 4 8 5 -1
        }
        System.out.println();

        // 随机下标访问
        int randomIndex = (int) (Math.random() * length);
        System.out.println("随机下标为：" + randomIndex); // 输出0到5的随机下标
        System.out.println("随机访问到的元素为：" + myArray[randomIndex]); // 输出上面下标的元素
    }
}
