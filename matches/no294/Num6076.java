package matches.no294;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 6076. 表示一个折线图的最少线段数 显示英文描述
 * 给你一个二维整数数组 stockPrices ，其中 stockPrices[i] = [dayi, pricei] 表示股票在 dayi 的价格为 pricei 。折线图 是一个二维平面上的若干个点组成的图，横坐标表示日期，纵坐标表示价格，折线图由相邻的点连接而成。比方说下图是一个例子：
 * 请你返回要表示一个折线图所需要的 最少线段数 。
 * <p>
 * 输入：stockPrices = [[1,7],[2,6],[3,5],[4,4],[5,4],[6,3],[7,2],[8,1]]
 * 输出：3
 * 解释：
 * 上图为输入对应的图，横坐标表示日期，纵坐标表示价格。
 * 以下 3 个线段可以表示折线图：
 * - 线段 1 （红色）从 (1,7) 到 (4,4) ，经过 (1,7) ，(2,6) ，(3,5) 和 (4,4) 。
 * - 线段 2 （蓝色）从 (4,4) 到 (5,4) 。
 * - 线段 3 （绿色）从 (5,4) 到 (8,1) ，经过 (5,4) ，(6,3) ，(7,2) 和 (8,1) 。
 * 可以证明，无法用少于 3 条线段表示这个折线图。
 * <p>
 * 提示：
 * <p>
 * 1 <= stockPrices.length <= 105
 * stockPrices[i].length == 2
 * 1 <= dayi, pricei <= 109
 * 所有 dayi 互不相同 。
 */
public class Num6076 {

    public static void main(String[] args) {
        Num6076 num6076 = new Num6076();
        int[][] stock = {{1, 1}, {499999999, 2}, {999999998, 3}, {1000000000, 5}};
        System.out.println(num6076.minimumLines(stock));
    }

    /**
     * 计算两个点之间的斜率是否相等，相等的话则说明是在同一条线
     * 直接相除的话会有精度丢失，后几个用例过不了
     * 转换为乘法解决，乘法肯定不会有精度丢失问题
     *
     * @param stockPrices
     * @return
     */
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        int count = 0;
        int len = stockPrices.length;
        long preX = 0L;
        long preY = 0L;
        for (int i = 1; i < len; i++) {
            if (i == 1) {
                preX = stockPrices[i][0] - stockPrices[i - 1][0];
                preY = stockPrices[i][1] - stockPrices[i - 1][1];
                count++;
                continue;
            }
            long nowX = stockPrices[i][0] - stockPrices[i - 1][0];
            long nowY = stockPrices[i][1] - stockPrices[i - 1][1];
            if (preX * nowY != preY * nowX) {
                count++;
            }
            preX = nowX;
            preY = nowY;
        }
        return count;
    }
}
