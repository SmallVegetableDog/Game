package matches.no292;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
 * <p>
 * <p>
 * <p>
 * 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
 * <p>
 * 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
 * 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
 * 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。
 * <p>
 * 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
 * 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
 * <p>
 * 由于答案可能很大，将它对 109 + 7 取余 后返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：pressedKeys = "22233"
 * 输出：8
 * 解释：
 * Alice 可能发出的文字信息包括：
 * "aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
 * 由于总共有 8 种可能的信息，所以我们返回 8 。
 * 示例 2：
 * <p>
 * 输入：pressedKeys = "222222222222222222222222222222222222"
 * 输出：82876089
 * 解释：
 * 总共有 2082876103 种 Alice 可能发出的文字信息。
 * 由于我们需要将答案对 109 + 7 取余，所以我们返回 2082876103 % (109 + 7) = 82876089 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= pressedKeys.length <= 105
 * pressedKeys 只包含数字 '2' 到 '9' 。
 * <p>
 * 链接：https://leetcode.cn/problems/count-number-of-texts
 */
public class Num2266 {
    public static void main(String[] args) {
        Num2266 num2266 = new Num2266();
        System.out.println(num2266.countTextsBetter("444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664"));

       // System.out.println(num2266.countTexts("444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664"));
    }

    public int countTexts(String pressedKeys) {
        int len = pressedKeys.length();
        char[] chars = pressedKeys.toCharArray();
        long[] dp = new long[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        int pre1 = chars[0] - '0';
        int pre2 = -1;
        int pre3 = -1;


        for (int i = 1; i < len; i++) {
            int now = chars[i] - '0';
            long res = 0;
            if (now != pre1) {
                res = dp[i];
            } else {
                if (now == 7 || now == 9) {
                    if (now == pre2 && now == pre3) {
                        res = dp[i] + dp[i - 1] + dp[i - 2] + dp[i - 3];
                    } else if (now == pre2) {
                        res = dp[i] + dp[i - 1] + dp[i - 2];
                    } else {
                        res = dp[i] + dp[i - 1];
                    }
                } else {
                    if (now == pre2) {
                        res = dp[i] + dp[i - 1] + dp[i - 2];
                    } else {
                        //now单独作为一个字符加在dp[i]的字符后
                        //now和pre1连起来作为一个字符加在dp[i-1]后
                        res = dp[i] + dp[i - 1];
                    }
                }
            }
            dp[i + 1] = res % 1000000007;
            if (i == 1) {
                pre2 = pre1;
                pre1 = now;
            } else {
                pre3 = pre2;
                pre2 = pre1;
                pre1 = now;
            }
        }
        return (int) dp[len] % 1000000007;
    }

    //优化成常数空间复杂度
    public int countTextsBetter(String pressedKeys) {
        int len = pressedKeys.length();
        char[] chars = pressedKeys.toCharArray();
        int pre1 = chars[0] - '0';
        int pre2 = -1;
        int pre3 = -1;

        long dp0 = 1, dp1 = 1, dp2 = 0, dp3 = 0;

        for (int i = 1; i < len; i++) {
            int now = chars[i] - '0';
            long res = 0;
            if (now != pre1) {
                res = dp0;
            } else {
                if (now == 7 || now == 9) {
                    if (now == pre2 && now == pre3) {
                        res = dp0 + dp1 + dp2 + dp3;
                    } else if (now == pre2) {
                        res = dp0 + dp1 + dp2;
                    } else {
                        res = dp0 + dp1;
                    }
                } else {
                    if (now == pre2) {
                        res = dp0 + dp1 + dp2;
                    } else {
                        res = dp0 + dp1;
                    }
                }
            }
            dp3 = dp2;
            dp2 = dp1;
            dp1 = dp0;
            dp0 = res % 1000000007;
            if (i == 1) {
                pre2 = pre1;
                pre1 = now;
            } else {
                pre3 = pre2;
                pre2 = pre1;
                pre1 = now;
            }
        }
        return (int) dp0;
    }
}
