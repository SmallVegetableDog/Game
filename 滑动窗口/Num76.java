package 滑动窗口;

import java.util.HashMap;
import java.util.Map;

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
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        String result = "";
        int l = 0, r = 0, valid = 0;
        char[] sourceArray = s.toCharArray();
        Map<Character, Integer> windowMap = new HashMap<>();
        while (r < s.length()) {
            char c = sourceArray[r];
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            if (windowMap.get(c).equals(targetMap.get(c))) {
                valid++;
            }
            r++;
            while (valid == targetMap.size()) {
                if (result.length() == 0 || r - l < result.length()) {
                    result = s.substring(l, r);
                }
                if (windowMap.get(sourceArray[l]).equals(targetMap.get(sourceArray[l]))) {
                    valid--;
                }
                windowMap.put(sourceArray[l], windowMap.get(sourceArray[l]) - 1);
                l++;
            }
        }
        return result;
    }
}
