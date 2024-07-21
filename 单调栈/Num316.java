package 单调栈;

import java.util.Stack;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的
 * 字典序
 * 最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 */
public class Num316 {

    public String removeDuplicateLetters(String s) {
        boolean[] exists = new boolean[26];
        int[] lastIndex = new int[26];
        Stack<Character> stack = new Stack<>();
        for (int i = s.toCharArray().length - 1; i >= 0; i--) {
            if (lastIndex[s.charAt(i) - 'a'] == 0) {
                lastIndex[s.charAt(i) - 'a'] = i;
            }
        }
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if (exists[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty()
                    && stack.peek() > c
                    && lastIndex[stack.peek() - 'a'] > i) {
                Character pop = stack.pop();
                exists[pop - 'a'] = false;
            }
            stack.push(c);
            exists[c - 'a'] = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
