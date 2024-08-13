package chap3;

public class Addition {
    public static void main(String[] args) {
        // 代码片段1
        int myInt = 101;               // myInt赋值101
        int sum = myInt + 100;        // myInt加100
        System.out.println(sum);      // 输出 201
        System.out.println(myInt);    // 验证结果输出 201

        // 代码片段2
        myInt += 100;                    // myInt加100
        System.out.println(myInt);     // 输出 201

    }
}
