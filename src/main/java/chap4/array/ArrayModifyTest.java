package chap4.array;

public class ArrayModifyTest {
    public static void main(String[] args) {
        // 定义数组
        int[] myArray = new int[]{-1, 5, 8, 4, 7, 0};
        ArrayInsertTest.printArray(myArray);  // 打印修改前数组，输出：-1, 5, 8, 4, 7, 0

        myArray[1] = 20;   // 下标1处的元素修改为20
        ArrayInsertTest.printArray(myArray);  // 打印修改后数组，输出：-1, 20, 8, 4, 7, 0
    }
}
