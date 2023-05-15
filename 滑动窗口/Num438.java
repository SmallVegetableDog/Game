package 滑动窗口;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * 中等
 * 1.2K
 * 相关企业
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 * <p>
 * todo 更优解（转成integer数组，使用Arrays.equal判断数组是否相等）
 */
public class Num438 {

    public List<Integer> findAnagrams(String s, String p) {
        char[] sToChars = s.toCharArray();
        char[] pToChars = p.toCharArray();
        int sLen = s.length();
        int pLen = p.length();
        Map<Character, Integer> charToNum = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (char ch : pToChars) {
            charToNum.put(ch, charToNum.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0, j = 0; j < sLen; ) {
            char ch = sToChars[j];
            if (!charToNum.containsKey(ch)) {
                j++;
                i = j;
                continue;
            }
            if (j - i == pLen - 1) {
                HashMap<Character, Integer> map = new HashMap<>(charToNum);
                for (int ii = i, jj = j; ii <= jj; ii++) {
                    int preVal = map.put(sToChars[ii], map.get(sToChars[ii]) - 1);
                    if (preVal <= 0) {
                        i++;
                        j++;
                        break;
                    }
                    if (ii == jj) {
                        res.add(i);
                        j++;
                        i++;
                    }
                }
            } else {
                j++;
            }

        }
        return res;
    }
}
