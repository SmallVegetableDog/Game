package interval;

import java.util.Arrays;

/**
 * 删除被覆盖区间
 * <p>
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * <p>
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 * <p>
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 *  
 * <p>
 * 提示：​​​​​​
 * <p>
 * 1 <= intervals.length <= 1000
 * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
 * 对于所有的 i != j：intervals[i] != intervals[j]
 * 通过次数19,137提交次数33,949
 * <p>
 * 链接：https://leetcode.cn/problems/remove-covered-intervals
 */
public class Num1288 {

    public static void main(String[] args) {
        int[][] ints = {{2, 10}, {1, 4}, {3, 6}, {2, 8}};
        Num1288 num1288 = new Num1288();
        System.out.println(num1288.removeCoveredIntervals(ints));
    }

    //区间问题，一般先排序，画图看规律
    //本题先转化为求被覆盖的区间个数，答案即为总数-被覆盖的区间个数
    public int removeCoveredIntervals(int[][] intervals) {
        int coverIntervalCount = 0;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (right >= interval[1]) {
                coverIntervalCount++;
            } else {
                right = interval[1];
            }
        }

        return intervals.length - coverIntervalCount;
    }
}
