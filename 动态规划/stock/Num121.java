package 动态规划.stock;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * <p>
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 */
public class Num121 {
    public static void main(String[] args) {
        Num121 num121 = new Num121();
        System.out.println(num121.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        //dp[i][0]==第i天不持有股票的利润、dp[i][1]==第i天持有股票的利润
        int[][] dp = new int[n][2];
        //base case
        dp[0][0] = 0; //第一天不持有股票
        dp[0][1] = -prices[0]; //第一天买入股票

        //从第二天开始
        for (int i = 1; i < n; i++) {
            //今天不持有股票 = max（上一天不持有股票，上一天持有股票然后今天卖掉）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //今天持有股票 = max（上一天持有股票，上一天不持有股票然后今天买入股票）
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

}
