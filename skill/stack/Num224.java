package skill.stack;

import 树.Num230;

import java.util.Stack;

/**
 * 224. 基本计算器
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
 * '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
 * 输入中不存在两个连续的操作符
 * 每个数字和运行的计算将适合于一个有符号的 32位 整数
 */
public class Num224 {

    public static void main(String[] args) {
        System.out.println(new Num224().calculate("(1+(4+5+2)-3)+(6 + 8  ) "));
    }

    int i = 0;

    public int calculate(String s) {
        return doCalculate(s.replaceAll(" ", ""));
    }

    private int doCalculate(String s) {
        Stack<Integer> stack = new Stack<>();
        //标记前一个操作符
        char flag = '+';
        int n = 10, sum = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sum = sum * n + (c - '0');
                if (i != s.length() - 1) {
                    continue;
                }
            }
            if (c == '(') {
                i++;
                sum = doCalculate(s);
            }
            if (!Character.isDigit(c) || i == s.length() - 1) {
                switch (flag) {
                    case '+':
                        stack.push(sum);
                        break;
                    case '-':
                        stack.push(sum * -1);
                        break;
                    case '*':
                        stack.push(stack.pop() * sum);
                        break;
                    case '/':
                        stack.push(stack.pop() / sum);
                        break;
                }
                flag = c;
                sum = 0;
            }
            if (c == ')') {
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res = res + stack.pop();
        }
        return res;
    }
}
