package chap4.stack.linkedListStack;

public class LinkedListStackTest {
    public static void main(String[] args) throws Exception {
        // 1、创建堆栈：最大容量为4
        int maxSize = 4;
        LinkedListStack linkedListStack = new LinkedListStack(maxSize);

        // 入栈：1
        linkedListStack.push(1);
        linkedListStack.print(); // 输出：[1(top|bottom)]

        // 入栈：2
        linkedListStack.push(2);
        linkedListStack.print(); // 输出：[2(top)]->[1(bottom)]

        // 入栈：3
        linkedListStack.push(3);
        linkedListStack.print(); // 输出：[3(top)]->[2]->[1(bottom)]

        // 入栈：4
        linkedListStack.push(4);
        linkedListStack.print(); // 输出：[4(top)]->[3]->[2]->[1(bottom)]

        // 入栈：5
        //linkedListStack.push(5);  // 堆栈已满异常

        // 出栈：4
        linkedListStack.pop();
        linkedListStack.print(); // 输出：[3(top)]->[2]->[1(bottom)]

        // 连续出栈：3  2
        linkedListStack.pop();
        linkedListStack.pop();
        linkedListStack.print(); // 输出：[1(top|bottom)]

        // 出栈：1
        linkedListStack.pop();
        linkedListStack.print(); // 输出：堆栈为空，无法打印！
    }
}
