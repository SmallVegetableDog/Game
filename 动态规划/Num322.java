package 动态规划;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * 链接：https://leetcode-cn.com/problems/coin-change
 */
public class Num322 {
    public static void main(String[] args) {
        int[] nums = {186,419,83,408};
        Num322 num322 = new Num322();
        int i = num322.coinChange(nums, 6249);
        System.out.println(i);
    }


    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount,new int[amount + 1]);
    }

    private int dp(int[] coins, int amount,int[] memo) {
        if(amount<0){
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int dp = dp(coins, amount - coin,memo);
            if(dp==-1){
                continue;
            }
            res = Math.min(res, dp + 1);
        }
        if( res == Integer.MAX_VALUE ){
            res = -1;
        }
        memo[amount] = res;
        return res;
    }
}
