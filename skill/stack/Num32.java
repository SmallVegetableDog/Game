package skill.stack;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 */
public class Num32 {

    public int longestValidParentheses(String s) {
        //栈底存储最后无法有效匹配括号字串的右括号的下标
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                //把左括号当前下标进栈，这只是为了让最后那个右括号能够匹配上最前面那个左括号
                stack.add(i);
            } else {
                //遇到右括号出栈，
                stack.pop();
                //栈为空，说明当前这个右括号是无法匹配一个左括号的，
                //那就把它的下标压入栈底，让它成为最后无法有效匹配括号字串的右括号的下标
                if (stack.isEmpty()) {
                    stack.add(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
