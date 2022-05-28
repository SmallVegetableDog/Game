package matches.no290;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * 6043. 统计包含每个点的矩形数目 显示英文描述
 * 通过的用户数951
 * 尝试过的用户数2903
 * 用户总通过次数1002
 * 用户总提交次数6670
 * 题目难度Medium
 * 给你一个二维整数数组 rectangles ，其中 rectangles[i] = [li, hi] 表示第 i 个矩形长为 li 高为 hi 。给你一个二维整数数组 points ，其中 points[j] = [xj, yj] 是坐标为 (xj, yj) 的一个点。
 * <p>
 * 第 i 个矩形的 左下角 在 (0, 0) 处，右上角 在 (li, hi) 。
 * <p>
 * 请你返回一个整数数组 count ，长度为 points.length，其中 count[j]是 包含 第 j 个点的矩形数目。
 * <p>
 * 如果 0 <= xj <= li 且 0 <= yj <= hi ，那么我们说第 i 个矩形包含第 j 个点。如果一个点刚好在矩形的 边上 ，这个点也被视为被矩形包含。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：rectangles = [[1,2],[2,3],[2,5]], points = [[2,1],[1,4]]
 * 输出：[2,1]
 * 解释：
 * 第一个矩形不包含任何点。
 * 第二个矩形只包含一个点 (2, 1) 。
 * 第三个矩形包含点 (2, 1) 和 (1, 4) 。
 * 包含点 (2, 1) 的矩形数目为 2 。
 * 包含点 (1, 4) 的矩形数目为 1 。
 * 所以，我们返回 [2, 1] 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：rectangles = [[1,1],[2,2],[3,3]], points = [[1,3],[1,1]]
 * 输出：[1,3]
 * 解释：
 * 第一个矩形只包含点 (1, 1) 。
 * 第二个矩形只包含点 (1, 1) 。
 * 第三个矩形包含点 (1, 3) 和 (1, 1) 。
 * 包含点 (1, 3) 的矩形数目为 1 。
 * 包含点 (1, 1) 的矩形数目为 3 。
 * 所以，我们返回 [1, 3] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= rectangles.length, points.length <= 5 * 104
 * rectangles[i].length == points[j].length == 2
 * 1 <= li, xj <= 109
 * 1 <= hi, yj <= 100
 * 所有 rectangles 互不相同 。
 * 所有 points 互不相同 。
 */
public class Num6043 {
    public static void main(String[] args) {
        Num6043 num6043 = new Num6043();
        int[][] rectangles = {{1, 2}, {2, 3}, {2, 5}};
        int[][] points = {{2, 1}, {1, 4}};
        int[] ints = num6043.countRectangles(rectangles, points);
        System.out.println(ints);

    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        Arrays.sort(rectangles, (o1, o2) -> o2[1] - o1[1]);
        HashMap<Integer, List<Integer>> yToXNums = new HashMap<>();
        int[] counts = new int[points.length];
        int i = 0;
        for (int[] point : points) {
            int x = point[0], y = point[1];
            List<Integer> xNums = yToXNums.get(y);
            if (Objects.isNull(xNums)) {
                xNums = buildXNumsForY(rectangles, y);
                yToXNums.put(y, xNums);
            }
            int count = findMediaNum(x, xNums);
            counts[i++] = count;
        }
        return counts;
    }

    private List<Integer> buildXNumsForY(int[][] rectangles, int yy) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int[] rec : rectangles) {
            int x = rec[0], y = rec[1];
            if (y < yy) {
                break;
            }
            nums.add(x);
        }
        Collections.sort(nums);
        return nums;
    }

    private int findMediaNum(int x, List<Integer> xNums) {
        int l = 0, r = xNums.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            Integer val = xNums.get(mid);
            if (val < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return xNums.size() - l;
    }
}
