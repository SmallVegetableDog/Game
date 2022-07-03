package matches.no300;

/**
 * 6109. 知道秘密的人数
 * 在第 1 天，有一个人发现了一个秘密。
 * <p>
 * 给你一个整数 delay ，表示每个人会在发现秘密后的 delay 天之后，每天 给一个新的人 分享 秘密。同时给你一个整数 forget ，表示每个人在发现秘密 forget 天之后会 忘记 这个秘密。一个人 不能 在忘记秘密那一天及之后的日子里分享秘密。
 * <p>
 * 给你一个整数 n ，请你返回在第 n 天结束时，知道秘密的人数。由于答案可能会很大，请你将结果对 109 + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6, delay = 2, forget = 4
 * 输出：5
 * 解释：
 * 第 1 天：假设第一个人叫 A 。（一个人知道秘密）
 * 第 2 天：A 是唯一一个知道秘密的人。（一个人知道秘密）
 * 第 3 天：A 把秘密分享给 B 。（两个人知道秘密）
 * 第 4 天：A 把秘密分享给一个新的人 C 。（三个人知道秘密）
 * 第 5 天：A 忘记了秘密，B 把秘密分享给一个新的人 D 。（三个人知道秘密）
 * 第 6 天：B 把秘密分享给 E，C 把秘密分享给 F 。（五个人知道秘密）
 * 示例 2：
 * <p>
 * 输入：n = 4, delay = 1, forget = 3
 * 输出：6
 * 解释：
 * 第 1 天：第一个知道秘密的人为 A 。（一个人知道秘密）
 * 第 2 天：A 把秘密分享给 B 。（两个人知道秘密）
 * 第 3 天：A 和 B 把秘密分享给 2 个新的人 C 和 D 。（四个人知道秘密）
 * 第 4 天：A 忘记了秘密，B、C、D 分别分享给 3 个新的人。（六个人知道秘密）
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 1000
 * 1 <= delay < forget <= n
 */
public class Num6109 {

    public static void main(String[] args) {
        Num6109 num6109 = new Num6109();
        //System.out.println(num6109.peopleAwareOfSecret(6, 2, 4));

        System.out.println(num6109.peopleAwareOfSecret(134, 4, 39));
    }

    static final int MOD = (int) 1e9 + 7;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        //第i天新增的人数
        //dp[i] = sum[ dp[i-forget],dp[i-delay] ]
        //求一个数组某个区间的和，常用优化技巧前缀和
        //dp数组使用前缀和表达的话，dp[i]就等于前i天一共知道秘密的人数（包括已经forget的）
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            long num = MOD + dp[Math.max(i - delay, 0)] - dp[Math.max(i - forget, 0)];
            dp[i] = (dp[i - 1] + num) % MOD;
        }
        long num = (MOD + dp[n] - dp[n - forget]) % MOD;
        if (num < 0) {
            return 0;
        }
        return (int) num;
    }

}
