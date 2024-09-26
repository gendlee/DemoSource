package chap2;

public class Operators {
    public static void main(String[] args) {
        // 代码片段1
        int a = 1;
        int b = 2;
        System.out.println(a & b);      // 输出 0，a=1(二进制0000 0001)，b=2(二进制0000 0010)，按位与后得0000 0000,即十进制的0
        System.out.println(a | b);      // 输出 3，a=1(二进制0000 0001)，b=2(二进制0000 0010)，按位或后得0000 0011,即十进制的3

        // 代码片段2
        boolean c = false;
        boolean d = true;
        System.out.println(c && d);      // 输出 false
        System.out.println(c || d);      // 输出 true

        // 代码片段3
        System.out.println(a = b);       // 输出 2, a=2，b=2
        System.out.println(a == b);      // 输出 true
    }
}
