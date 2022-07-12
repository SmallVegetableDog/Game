package skill;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 301. 删除无效的括号
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * <p>
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * 示例 2：
 * <p>
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * 示例 3：
 * <p>
 * 输入：s = ")("
 * 输出：[""]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 25
 * s 由小写英文字母以及括号 '(' 和 ')' 组成
 * s 中至多含 20 个括号
 */
public class Num301 {

    public static void main(String[] args) {
        Num301 num301 = new Num301();
        System.out.println(num301.removeInvalidParentheses("()())()"));
    }

    HashSet<String> res = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int removeL = 0;
        int removeR = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                removeL++;
            } else if (c == ')') {
                if (removeL == 0) {
                    removeR++;
                } else {
                    removeL--;
                }
            }
        }

        backTrack(s, 0, removeL, removeR);
        return new ArrayList<>(res);
    }

    private void backTrack(String s, int start, int removeL, int removeR) {
        if (removeL == 0 && removeR == 0) {
            if (valid(s)) {
                res.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (s.length() - i < removeL + removeR) {
                return;
            }
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            char ch = s.charAt(i);
            if (ch == '(' && removeL > 0) {
                backTrack(s.substring(0, i) + s.substring(i + 1), i, removeL - 1, removeR);
            } else if (ch == ')' && removeR > 0) {
                backTrack(s.substring(0, i) + s.substring(i + 1), i, removeL, removeR - 1);
            }
        }
    }

    private boolean valid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }
}
