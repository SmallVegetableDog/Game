package 单调栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入： heights = [2,4]
 * 输出： 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 */
public class Num84 {

    //again
    public static void main(String[] args) {
        Num84 num84 = new Num84();
//        int[] heights = new int[]{6, 7, 5, 2, 4, 5, 9, 3};
//        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        int[] heights = new int[]{1, 1};
        System.out.println(num84.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int length = heights.length;
        int[] left = new int[length];
        int[] right = new int[length];
        for (int i = 0; i < length; i++) {
            int height = heights[i];
            int pos = -1;
            while (!stack.isEmpty()) {
                int[] peek = stack.peek();
                if (peek[1] >= height) {
                    stack.pop();
                    continue;
                }
                //遇到当前柱子i的左边界
                pos = peek[0];
                break;
            }
            left[i] = pos;
            stack.add(new int[]{i, height});
        }
        stack = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            int height = heights[i];
            int pos = length;
            while (!stack.isEmpty()) {
                int[] peek = stack.peek();
                if (peek[1] >= height) {
                    stack.pop();
                    continue;
                }
                //遇到当前柱子i的右边界
                pos = peek[0];
                break;
            }
            right[i] = pos;
            stack.add(new int[]{i, height});
        }
        int max = -1;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }
}
