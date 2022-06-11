package 动态规划;

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
        int count = num926.minFlipsMonoIncr("00110");
        System.out.println(count);
    }

    //BFS暴力解法会超时，最优解是动态规划
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        //dp[i][0] 字符串s前i位（第i位为0）翻转成递增序列的次数
        //dp[i][1] 字符串s前i位（第i位为1）翻转成递增序列的次数
        int[][] dp = new int[len][2];
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            //base case
            if (i == 0) {
                if (ch == '0') {
                    dp[0][0] = 0;
                    dp[0][1] = 1;
                } else {
                    dp[0][0] = 1;
                    dp[0][1] = 0;
                }
                continue;
            }
            if (ch == '0') {
                dp[i][0] = dp[i - 1][0];
                //将第i位值反转，需要满足前i位递增，所以取dp[i-1]位较小的值即可
                dp[i][1] = Math.min(dp[i - 1][1],dp[i - 1][0]) + 1;
            } else {
                dp[i][0] = dp[i - 1][0] +1;
                dp[i][1] = Math.min(dp[i - 1][1],dp[i - 1][0]);
            }
        }
        return Math.min(dp[len - 1][0], dp[len - 1][1]);
    }

}
