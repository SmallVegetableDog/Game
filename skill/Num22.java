package skill;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 */
public class Num22 {


    public static void main(String[] args) {
        Num22 num22 = new Num22();
        List<String> strings = num22.generateParenthesis(3);
        System.out.println(strings);
    }

    private Set<String> res;

    /**
     * todo 把左右括号作为数量进行模拟递归，根据合法括号的规律判断追加左括号还是右括号
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        res = new HashSet<>();
        recursion(n);
        return new ArrayList<>(res);
    }

    private void recursion(int n) {
        if (n == 1) {
            res.add("()");
            return;
        }
        recursion(n - 1);
        HashSet<String> set = new HashSet<>();
        for (String str : res) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    String newStr = str.substring(0, i + 1) + "()" + str.substring(i + 1);
                    set.add(newStr);
                }
            }
            set.add(str + "()");
        }
        res = set;
    }
}
