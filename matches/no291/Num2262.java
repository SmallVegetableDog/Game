package matches.no291;

import java.util.Arrays;

/**
 * 2262. 字符串的总引力 显示英文描述
 * 通过的用户数972
 * 尝试过的用户数1943
 * 用户总通过次数1089
 * 用户总提交次数3403
 * 题目难度Hard
 * 字符串的 引力 定义为：字符串中 不同 字符的数量。
 * <p>
 * 例如，"abbca" 的引力为 3 ，因为其中有 3 个不同字符 'a'、'b' 和 'c' 。
 * 给你一个字符串 s ，返回 其所有子字符串的总引力 。
 * <p>
 * 子字符串 定义为：字符串中的一个连续字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abbca"
 * 输出：28
 * 解释："abbca" 的子字符串有：
 * - 长度为 1 的子字符串："a"、"b"、"b"、"c"、"a" 的引力分别为 1、1、1、1、1，总和为 5 。
 * - 长度为 2 的子字符串："ab"、"bb"、"bc"、"ca" 的引力分别为 2、1、2、2 ，总和为 7 。
 * - 长度为 3 的子字符串："abb"、"bbc"、"bca" 的引力分别为 2、2、3 ，总和为 7 。
 * - 长度为 4 的子字符串："abbc"、"bbca" 的引力分别为 3、3 ，总和为 6 。
 * - 长度为 5 的子字符串："abbca" 的引力为 3 ，总和为 3 。
 * 引力总和为 5 + 7 + 7 + 6 + 3 = 28 。
 * 示例 2：
 * <p>
 * 输入：s = "code"
 * 输出：20
 * 解释："code" 的子字符串有：
 * - 长度为 1 的子字符串："c"、"o"、"d"、"e" 的引力分别为 1、1、1、1 ，总和为 4 。
 * - 长度为 2 的子字符串："co"、"od"、"de" 的引力分别为 2、2、2 ，总和为 6 。
 * - 长度为 3 的子字符串："cod"、"ode" 的引力分别为 3、3 ，总和为 6 。
 * - 长度为 4 的子字符串："code" 的引力为 4 ，总和为 4 。
 * 引力总和为 4 + 6 + 6 + 4 = 20 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 */
public class Num2262 {
    public static void main(String[] args) {
        Num2262 num2262 = new Num2262();
        System.out.println(num2262.appealSum("ab"));
    }


    public long appealSum(String s) {
        long ans = 0L,sumG = 0L;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0;i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            sumG += i - last[c];
            ans += sumG;
            last[c] = i;
        }
        return ans;
    }

    //暴力解法 超时
//    public long appealSum(String s) {
//        long res = 0;
//        int len = s.length();
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < len; i++) {
//            int count = 1;
//            int[] nums = new int[26];
//            nums[chars[i] - 'a']++;
//            res = res + count;
//            for (int j = i + 1; j < len; j++) {
//                if (nums[chars[j]-'a']++ == 0) {
//                    count++;
//                }
//                res = res + count;
//            }
//        }
//        return res;
//    }
}
