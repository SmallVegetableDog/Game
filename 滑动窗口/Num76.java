package 滑动窗口;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 * <p>
 * <p>
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 */
public class Num76 {

    public static void main(String[] args) {
        Num76 num76 = new Num76();
        System.out.println(num76.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        int begin = 0, end = 0;
        int len = s.length();
        int count = 0;
        int res = Integer.MAX_VALUE;
        String str = "";
        HashMap<Character, Integer> charToCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            Integer num = charToCount.getOrDefault(ch, 0);
            if (num == 0) {
                count++;
            }
            charToCount.put(ch, num + 1);
        }
        while (end < len) {
            char c = s.charAt(end);
            if (charToCount.containsKey(c)) {
                Integer num = charToCount.get(c);
                num--;
                if (num == 0) {
                    count--;
                }
                charToCount.put(c, num);
            }
            end++;
            if (count == 0) {
                while (begin < end) {
                    char ch = s.charAt(begin);
                    if (charToCount.containsKey(ch)) {
                        Integer num = charToCount.get(ch);
                        num++;
                        charToCount.put(ch, num);
                        if (num == 1) {
                            if (res > end - begin) {
                                res = end - begin;
                                str = s.substring(begin, end);
                            }
                            count++;
                            begin++;
                            break;
                        }
                    }
                    begin++;
                }
            }
        }
        return str;
    }
}
