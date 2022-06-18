package 动态规划;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class Num42 {

    int sum = 0;

    /**
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int length = height.length;
        //保存当前下标往左的范围内的最高值
        int[] left = new int[length];
        //保存当前下标往右的范围内的最高值
        int[] right = new int[length];
        left[0] = height[0];
        for (int i = 1; i < length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int res = 0;
        //每个柱子的储水量 = min（左边柱子的最高值，右边柱子的最高值）- 当前柱子的高度
        for (int i = 1; i < length - 1; i++) {
            int min = Math.min(left[i - 1], right[i + 1]);
            if (min > height[i]) {
                res = res + (min - height[i]);
            }
        }
        return res;
    }

}
