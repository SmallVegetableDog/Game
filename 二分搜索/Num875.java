package 二分搜索;

/**
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 示例 3：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 */
public class Num875 {


    public int minEatingSpeed(int[] piles, int h) {
        //left——吃香蕉的最小速度
        //right——吃香蕉的最大速度
        int left = 1, right = piles[0];

        for (int pile : piles) {
            if (pile < left) {
                left = pile;
            }
            if (pile > right) {
                right = pile;
            }
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int res = match(mid, h, piles);
            // 香蕉能吃的过来，那么速度继续往左边最小值靠拢
            if (res >= 0) {
                right = mid;
            } else { //香蕉吃不过来，速度需要往右增大
                left = mid + 1;
            }
        }
        return left;
    }

    private int match(int spread, int h, int[] piles) {
        for (int pile : piles) {
            int mod = pile % spread;
            int div = pile / spread;
            if (mod > 0) {
                div++;
            }
            h = h - div;
            if (h < 0) {
                return h;
            }
        }
        return h;
    }
}
