package chap5.stack.seqStack;

import chap5.stack.linkedListStack.LinkedListStack;

public class SeqStackTest {
    public static void main(String[] args) throws Exception {
        // 1、创建堆栈：最大容量为4
        int maxSize = 4;
        SeqStack seqStack = new SeqStack(maxSize);

        // 入栈：1
        seqStack.push(1);
        seqStack.print(); // 输出：[1(top|bottom)]

        // 入栈：2
        seqStack.push(2);
        seqStack.print(); // 输出：[1(bottom)] [2(top)]

        // 入栈：3
        seqStack.push(3);
        seqStack.print(); // 输出：[1(bottom)] [2] [3(top)]

        // 入栈：4
        seqStack.push(4);
        seqStack.print(); // 输出：[1(bottom)] [2] [3] [4(top)]

        // 入栈：5
        //seqStack.push(5);  // 堆栈已满异常

        // 出栈：4
        seqStack.pop();
        seqStack.print(); // 输出：[1(bottom)] [2] [3(top)]

        // 连续出栈：3  2
        seqStack.pop();
        seqStack.pop();
        seqStack.print(); // 输出：[1(bottom|top)]

        // 出栈：1
        seqStack.pop();
        seqStack.print(); // 输出：堆栈为空，无法打印！
    }
}
