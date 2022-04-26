package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示。一次 移动 定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * <p>
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * <p>
 * 给出一个谜板的初始状态 board ，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * <p>
 * 示例 2:
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * <p>
 * 示例 3:
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * <p>
 * 链接：https://leetcode-cn.com/problems/sliding-puzzle
 */
public class Num773 {

    public int slidingPuzzle(int[][] board) {
        int[][] neighbor = new int[][]{
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4}
        };
        StringBuilder sb = new StringBuilder();
        for (int[] nums : board) {
            for (int num : nums) {
                sb.append(num);
            }
        }
        String start = sb.toString();
        String end = "123450";
        int step = 0;
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String numsStr = queue.poll();
                if (numsStr.equals(end)) {
                    return step;
                }
                char[] nums = numsStr.toCharArray();
                int zeroIndex = 0;
                while (zeroIndex < nums.length && nums[zeroIndex] != '0') {
                    zeroIndex++;
                }
                for (int index : neighbor[zeroIndex]) {
                    char[] clone = nums.clone();
                    char temp = clone[zeroIndex];
                    clone[zeroIndex] = clone[index];
                    clone[index] = temp;
                    String cloneStr = new String(clone);
                    if (visited.add(cloneStr)) {
                        queue.add(cloneStr);
                    }
                }
            }
            step++;
        }
        return -1;
    }


}
