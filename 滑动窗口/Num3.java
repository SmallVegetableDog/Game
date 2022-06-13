package 滑动窗口;

import java.util.HashSet;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 */
public class Num3 {
    public static void main(String[] args) {
        Num3 num3 = new Num3();

        System.out.println(num3.lengthOfLongestSubstring("abcabcbb"));
    }

    //滑动窗口解法
    private int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        int i = 0, j = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(i));
        int count = 0;
        while (j < len) {
            char c = s.charAt(j);
            if (set.contains(c)) {
                while (s.charAt(i) != c) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
            }
            set.add(c);
            count = Math.max(count, j - i+1);
            j++;
        }
        return count;
    }

    //暴力思路
//    public int lengthOfLongestSubstring(String s) {
//        int length = s.length();
//        if (length <= 1) {
//            return length;
//        }
//        int res = 0;
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < length && length - i > res; i++) {
//            HashSet<Character> set = new HashSet<>();
//            set.add(chars[i]);
//            int subRes = 1;
//            for (int j = i + 1; j < length; j++) {
//                if (!set.contains(chars[j])) {
//                    set.add(chars[j]);
//                    subRes++;
//                } else {
//                    break;
//                }
//            }
//            if (res < subRes) {
//                res = subRes;
//            }
//        }
//        return res;
//    }
}
