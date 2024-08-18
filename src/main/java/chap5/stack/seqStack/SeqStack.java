package chap5.stack.seqStack;

public class SeqStack {
    private int[] stack;
    private int maxSize;
    private int top;

    // 构造函数
    public SeqStack(int maxSize) {
        this.stack = new int[maxSize];
        this.maxSize = maxSize;
        this.top = -1;
    }

    /**
     * 堆栈是否为空
     */
    public boolean isEmpty() {
        return top == -1;
    }
    /**
     * 堆栈是否已满
     */
    public boolean isFull() {
        return top == (maxSize - 1);
    }

    /**
     * 入栈操作
     * @param val 入栈元素
     * @throws Exception 堆栈已满异常
     */
    public void push(int val) throws Exception {
        if (isFull()) {
            throw new Exception("堆栈已满，不能再入栈！");
        }
        stack[++top] = val;
    }

    /**
     * 出栈操作
     * @return 栈顶元素值
     * @throws Exception 堆栈为空异常
     */
    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("堆栈为空，不能出栈！");
        }
        int val = stack[top];
        top--;
        return val;
    }

    /**
     * 获取栈顶元素
     * @return 栈顶元素值
     * @throws Exception 堆栈为空异常
     */
    public int getTopElement() throws Exception {
        if (isEmpty()) {
            throw new Exception("堆栈为空，不能获取栈顶元素！");
        }
        return stack[top];
    }

    /**
     * 打印堆栈
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("堆栈为空，无法打印！");
        }

        for (int i = 0; i <= top; i++) {
            if (i == 0 && top == 0) {
                System.out.print(String.format("[%d(bottom|top)] ", stack[i]));
            } else if (i == 0 && top != 0) {
                System.out.print(String.format("[%d(bottom)] ", stack[i]));
            } else if (i != 0 && i == top) {
                System.out.print(String.format("[%d(top)] ", stack[i]));
            } else {
                System.out.print(String.format("[%d] ", stack[i]));
            }
        }
        System.out.println();
    }
}
