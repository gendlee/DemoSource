package chap5.array;

public class ArrayAppendTest {
    public static void main(String[] args) {
        // 定义长度为3的数组
        int[] myArray = new int[3];
        myArray[0] = -1;
        myArray[1] = 5;
        // 此时下标2未分配元素，会被初始化为0
        ArrayInsertTest.printArray(myArray);  // 打印原始数组，输出：-1 5 0

        int curLastIndex = 1; // 数组已使用的下标最大值
        int val = 8; // 待插入的值
        append(myArray, curLastIndex, val); // 数组尾部添加元素
        ArrayInsertTest.printArray(myArray);  // 打印插入后的数组，输出：-1 5 8
    }

    /**
     * 尾部插入
     * @param myArray 原数组
     * @param curLastIndex 数组使用的游标：标识当前数组已经占用的最大下标
     * @param val 待插入的元素值
     */
    private static void append(int[] myArray, int curLastIndex, int val) throws IllegalArgumentException{
        if (curLastIndex == myArray.length - 1) {
            throw new IllegalArgumentException("当前数组已满，无法再添加元素！");
        }
        // 将元素放到 curLastIndex + 1 位置
        myArray[curLastIndex + 1] = val;
    }
}
