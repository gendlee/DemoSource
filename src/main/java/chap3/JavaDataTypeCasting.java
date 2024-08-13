package chap3;

public class JavaDataTypeCasting {
    public static void main(String[] args) {
        int myInt = 101;                  // int 类型
        float castingFloat = myInt;     // 自动将int转换成float类型
        System.out.println(myInt);           // 输出 101
        System.out.println(castingFloat);   // 输出101.0

        double myDouble = 103.99;         // double 类型
        int castingInt = (int) myDouble; // 强制将double转换成int类型
        System.out.println(myDouble);     // 输出 103.99
        System.out.println(castingInt);   // 输出103，丢失小数部分
    }
}
