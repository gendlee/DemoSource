package chap5.array;

public class ArrayInsertTest {
    public static void main(String[] args) {
        // 定义长度为3的数组
        int[] myArray = new int[3];
        myArray[0] = -1;
        myArray[1] = 5;
        // 此时下标2未分配元素，会被初始化为0
        printArray(myArray);  // 打印原始数组，输出：-1 5 0

        int curLastIndex = 1; // 数组已使用的下标最大值
        int val = 8; // 待插入的值
        int index = 1; // 插入位置为下标1处，当前该位置被元素5占用
        insertByIndex(myArray, curLastIndex, index, val); // 指定下标插入元素
        printArray(myArray);  // 打印插入后的数组，输出：-1 8 5
    }

    /**
     * 指定下标插入
     * @param myArray 原数组
     * @param curLastIndex 数组使用的游标：标识当前数组已经占用的最大下标
     * @param index 指定下标
     * @param val 待插入的元素值
     */
    private static void insertByIndex(int[] myArray, int curLastIndex, int index, int val) throws IllegalArgumentException{
        if (curLastIndex == myArray.length - 1) {
            throw new IllegalArgumentException("当前数组已满，无法再添加元素！");
        }
        // 从最后一个元素开始依次向后移一个位置
        for (int i = curLastIndex; i >= index; i--) {
            myArray[i + 1] = myArray[i];
        }
        // 将元素放到 index 位置
        myArray[index] = val;
    }

    /**
     * 打印数组myArray
     */
    public static void printArray(int[] myArray) {
        for (int val : myArray) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
