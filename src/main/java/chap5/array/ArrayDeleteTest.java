package chap5.array;

public class ArrayDeleteTest {
    public static void main(String[] args) {
        // 定义数组
        int[] myArray = new int[]{-1, 5, 8, 4, 7, 0};
        ArrayInsertTest.printArray(myArray);  // 打印原始数组，输出：-1, 5, 8, 4, 7, 0
        int deleteIndex = 2; // 删除下标为2的元素，即8
        int curLastIndex = 5; // 当前最大下标为5
        delete(myArray, deleteIndex, curLastIndex); // 删除元素
        ArrayInsertTest.printArray(myArray);  // 打印插入后的数组，输出：-1, 5, 4, 7, 0, 0
    }

    /**
     * 删除数组元素
     * @param myArray 原数组
     * @param deleteIndex 待删除的元素的下标
     * @param curLastIndex 当前最大下标
     * @return 当前删除后的最大下标
     */
    private static int delete(int[] myArray, int deleteIndex, int curLastIndex) throws IllegalArgumentException{
        if (deleteIndex >= myArray.length - 1) {
            throw new IllegalArgumentException("下标已越界，无法删除！");
        }
        // 尾部删除，则数组元素个数减1即可
        if (deleteIndex == myArray.length - 1) {
            return curLastIndex - 1;  // 最大下标减1
        }

        // 指定下标
        for (int i = deleteIndex; i < curLastIndex; i++) {
            myArray[i] = myArray[i + 1];
        }

        return curLastIndex - 1;
    }
}
