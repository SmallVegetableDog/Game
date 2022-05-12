package dp;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * K站中转内最便宜的航班
 * <p>
 * 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 * <p>
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
 * 示例 2：
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 * 解释:
 * 城市航班图如下
 * <p>
 * <p>
 * 从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 104
 * 0 <= src, dst, k < n
 * src != dst
 * <p>
 * 链接：https://leetcode.cn/problems/cheapest-flights-within-k-stops
 */
public class Num787 {

    int[][] memo;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        memo = new int[n + 1][k + 1];
        Map<Integer, List<int[]>> flightMap = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            flightMap.putIfAbsent(to, new LinkedList<>());
            flightMap.get(to).add(new int[]{from, price});
        }
        return dp(flightMap, src, dst, k + 1);
    }

    /**
     * @param flightMap
     * @param src
     * @param dst
     * @param k
     * @return
     */
    private int dp(Map<Integer, List<int[]>> flightMap, int src, int dst, int k) {
        if (dst == src) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }
        if (memo[dst][k] != 0) {
            return memo[dst][k];
        }
        List<int[]> list = flightMap.get(dst);
        int res = Integer.MAX_VALUE;
        if (Objects.nonNull(list)) {
            for (int[] flight : list) {
                int subRes = dp(flightMap, src, flight[0], k - 1);
                if (subRes == -1) {
                    continue;
                }
                res = Math.min(res, subRes + flight[1]);
            }
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        memo[dst][k] = res;
        return res;
    }
}
