package 滑动窗口;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1456. 定长子串中元音的最大数目
 * 提示
 * 中等
 * 62
 * 相关企业
 * 给你字符串 s 和整数 k 。
 * <p>
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * <p>
 * 英文中的 元音字母 为（a, e, i, o, u）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * 示例 2：
 * <p>
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * 示例 3：
 * <p>
 * 输入：s = "leetcode", k = 3
 * 输出：2
 * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 * 示例 4：
 * <p>
 * 输入：s = "rhythms", k = 4
 * 输出：0
 * 解释：字符串 s 中不含任何元音字母。
 * 示例 5：
 * <p>
 * 输入：s = "tryhard", k = 4
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * 1 <= k <= s.length
 */
public class Num1456 {

    public int maxVowels(String s, int k) {
        int res = 0, midRes = 0;
        Set<Character> target = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = 0; i < k; i++) {
            if (target.contains(s.charAt(i))) {
                midRes++;
            }
        }
        if (midRes > res) {
            res = midRes;
            if (res == k) {
                return res;
            }
        }

        for (int l = 0, h = k; h < s.length(); l++, h++) {
            if (target.contains(s.charAt(l))) {
                midRes--;
            }
            if (target.contains(s.charAt(h))) {
                midRes++;
            }
            if (midRes > res) {
                res = midRes;
                if (res == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
