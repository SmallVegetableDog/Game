package 单调栈;

import java.util.Stack;

/**
 * 85. 最大矩形
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 * <p>
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：matrix = [["0","0"]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * rows == matrix.length
 * cols == matrix[0].length
 * 1 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 */
public class Num85 {

    //again
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        Num85 num85 = new Num85();
        System.out.println(num85.maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //记录matrix[i][j]的左边连续为1个最大个数
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        left[i][j] = 1;
                    } else {
                        left[i][j] = left[i][j - 1] + 1;
                    }
                }
            }
        }
        int res = Integer.MIN_VALUE;
        //枚举每一列，通过单调递增栈和left[][]数组计算出，每一列每一行的上下界坐标
        for (int j = 0; j < n; j++) {
            int[] up = new int[m];
            int[] down = new int[m];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < m; i++) {
                //确保栈是单调递增的
                while (!stack.isEmpty()) {
                    Integer peek = stack.peek();
                    if (left[peek][j] >= left[i][j]) {
                        stack.pop();
                        continue;
                    }
                    break;
                }
                if (stack.isEmpty()) {
                    up[i] = -1;
                } else {
                    up[i] = stack.peek();
                }
                stack.add(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                //确保栈是单调递增的
                while (!stack.isEmpty()) {
                    Integer peek = stack.peek();
                    if (left[peek][j] >= left[i][j]) {
                        stack.pop();
                        continue;
                    }
                    break;
                }
                if (stack.isEmpty()) {
                    down[i] = m;
                } else {
                    down[i] = stack.peek();
                }
                stack.add(i);
            }

            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                res = Math.max(res, height * left[i][j]);
            }
        }
        return res;
    }
}

























