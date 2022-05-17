package divide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 为运算表达式设计优先级
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2：
 * <p>
 * 输入：expression = "2*3-4*5"
 * 输出：[-34,-14,-10,-10,10]
 * 解释：
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= expression.length <= 20
 * expression 由数字和算符 '+'、'-' 和 '*' 组成。
 * 输入表达式中的所有整数值在范围 [0, 99] 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/different-ways-to-add-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num241 {

    public static void main(String[] args) {
        Num241 num241 = new Num241();
        List<Integer> integers = num241.diffWaysToCompute("2*3-4*5");
        System.out.println(integers);
    }

    /**
     * 分治算法，明确递归函数定义，相信定义，相信程序
     *
     * @param expression
     * @return
     */
    public List<Integer> diffWaysToCompute(String expression) {
        List<Character> exps = Arrays.asList('+', '-', '*');
        LinkedList<Integer> res = new LinkedList<>();
        if (!expression.contains("+") && !expression.contains("-") && !expression.contains("*")) {
            return Collections.singletonList(Integer.valueOf(expression));
        }
        for (int i = 0; i < expression.length(); i++) {
            char exp = expression.charAt(i);
            if (exps.contains(exp)) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        int num = 0;
                        if (exp == '+') {
                            num = l + r;
                        } else if (exp == '-') {
                            num = l - r;
                        } else {
                            num = l * r;
                        }
                        res.add(num);
                    }
                }
            }
        }
        return res;
    }

}
