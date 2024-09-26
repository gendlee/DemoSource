package chap2;

/**
 * Java控制结构
 */
public class ControlStructure {
    public static void main(String[] args) {
        //1、条件语句
        int x = 6;
        ifElseStatement(6);
        //2、switch
        switchStatement(x);
        //3、while
        int i = 1;
        while (i < 5) {
            System.out.println("while语句输出：" + i);
            i++;
        }
        //4、do-while
        int j = 10;
        do {
            System.out.println(j);
            j++;
        } while (j < 10);
        //5.跳转语句
        int res = jumpStatement();
        System.out.println("返回结果为：" + res);


    }

    private static void ifElseStatement(int x) {
        if (x > 5) {
            System.out.println("x比5大");
        } else if (x == 5) {
            System.out.println("x等于5");
        } else {
            System.out.println("x比5小");
        }
    }

    private static void switchStatement(int x) {
        switch (x) {
            case 1:
                System.out.println("周一日程");
                break;
            case 2:
                System.out.println("周二日程");
                break;
            case 3:
                System.out.println("周三日程");
                break;
            case 4:
                System.out.println("周四日程");
                break;
            case 5:
                System.out.println("周五日程");
                break;
            case 6:
                System.out.println("周六日程");
                break;
            case 7:
                System.out.println("周日日程");
                break;
            default:
                System.out.println("无效的数值");
        }
    }


    private static int jumpStatement() {
        int res = -1;
        for (int i = 0; i <= 100; i++) {
            if (i == 10) {
                continue; // 后边的代码都不执行，继续下一个循环
            }
            if (i == 20) {
                res = i;
                break;
            }
            System.out.println("jumpStatement: " + i);
        }

        return res; // 返回处理结果
    }
}
