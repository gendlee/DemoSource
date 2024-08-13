package chap5.array;

public class ArrayFindTest {
    public static void main(String[] args) {
        // 定义数组
        int[] myArray = new int[]{-1, 5, 8, 4, 7, 0};

        // 遍历查找存在的目标元素
        int existedTarget = 4;
        int index1 = findInArray(myArray, existedTarget);
        System.out.println(existedTarget + (index1 == -1 ? "未找到" : "已找到，下标为：" + index1)); // 输出：4已找到，下标为：3

        // 遍历查找不存在的目标元素
        int notExistedTarget = 20;
        int index2 = findInArray(myArray, notExistedTarget);
        System.out.println(notExistedTarget + (index2 == -1 ? "未找到" : "已找到，下标为：" + index1)); // 输出：20未找到
    }

    /**
     * 查找方法
     */
    private static int findInArray(int[] myArray, int target) {
        for (int i = 0; i <= myArray.length - 1; i++) {
            if (target == myArray[i]) {
                return i;
            }
        }

        // 未查找到返回特殊标识-1
        return -1;
    }
}
