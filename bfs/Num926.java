package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 926. 将字符串翻转到单调递增
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 * <p>
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 * <p>
 * 返回使 s 单调递增的最小翻转次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "00110"
 * 输出：1
 * 解释：翻转最后一位得到 00111.
 * 示例 2：
 * <p>
 * 输入：s = "010110"
 * 输出：2
 * 解释：翻转得到 011111，或者是 000111。
 * 示例 3：
 * <p>
 * 输入：s = "00011000"
 * 输出：2
 * 解释：翻转得到 00000000。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 为 '0' 或 '1'
 */
public class Num926 {

    public static void main(String[] args) {
        Num926 num926 = new Num926();
        int count = num926.minFlipsMonoIncr("010110");
        System.out.println(count);
    }

    //BFS暴力解法会超时，最优解是动态规划
    public int minFlipsMonoIncr(String s) {
        HashSet<String> memo = new HashSet<>();
        memo.add(s);
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                char[] chars = queue.poll().toCharArray();
                if (doMinFlipsMonoIncr(chars)) {
                    System.out.println(new String(chars));
                    return count;
                }
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == '0') {
                        chars[i] = '1';
                    } else {
                        chars[i] = '0';
                    }
                    String str;
                    if (!memo.contains(str = new String(chars))) {
                        queue.add(str);
                        memo.add(str);
                    }
                    if (chars[i] == '0') {
                        chars[i] = '1';
                    } else {
                        chars[i] = '0';
                    }
                }
            }
            count++;
        }
        return count;
    }

    public boolean doMinFlipsMonoIncr(char[] chars) {
        int i = 0;
        while (i < chars.length && chars[i++] == '0') {
        }
        while (i < chars.length) {
            if (chars[i] == '0') {
                return false;
            }
            i++;
        }
        return true;
    }
}
