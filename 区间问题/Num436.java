package 区间问题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 436. 寻找右区间
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 * <p>
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
 * <p>
 * 返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,2]]
 * 输出：[-1]
 * 解释：集合中只有一个区间，所以输出-1。
 * 示例 2：
 * <p>
 * 输入：intervals = [[3,4],[2,3],[1,2]]
 * 输出：[-1,0,1]
 * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
 * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
 * 示例 3：
 * <p>
 * 输入：intervals = [[1,4],[2,3],[3,4]]
 * 输出：[-1,2,-1]
 * 解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 2 * 104
 * intervals[i].length == 2
 * -106 <= starti <= endi <= 106
 * 每个间隔的起点都 不相同
 */
public class Num436 {

    public static void main(String[] args) {
        Num436 num436 = new Num436();
        //int[][] intervals = {{3, 4}, {2, 3}, {1, 2}};
        int[][] intervals = {{1, 2}};
        int[] rightInterval = num436.findRightInterval(intervals);
        System.out.println(rightInterval);
    }

    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[] start = new int[len];
        int[] res = new int[len];
        Map<Integer, Integer> startMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            start[i] = intervals[i][0];
            startMap.put(start[i], i);
        }
        Arrays.sort(start);
        for (int i = 0; i < len; i++) {
            int numEnd = intervals[i][1];
            int numStart = findMoreThan(numEnd, start);
            if (numStart == Integer.MIN_VALUE) {
                res[i] = -1;
            } else {
                res[i] = startMap.get(numStart);
            }
        }
        return res;
    }

    private int findMoreThan(int numEnd, int[] start) {
        int left = 0, right = start.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (start[mid] >= numEnd) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (start[left] < numEnd) {
            return Integer.MIN_VALUE;
        }
        return start[left];
    }
}
