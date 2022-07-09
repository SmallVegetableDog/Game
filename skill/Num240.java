package skill;

/**
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 */
public class Num240 {

    public static void main(String[] args) {
//        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};

        Num240 num240 = new Num240();
        num240.searchMatrix(matrix, 5);
    }

    int m, n;

    //最优解法 Z字形走法，从右上角开始遍历
    public boolean searchMatrix(int[][] matrix, int target) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        return doSearchMatrix(matrix, 0, 0, m - 1, n - 1, target);
    }

    private boolean doSearchMatrix(int[][] matrix, int s0, int s1, int e0, int e1, int target) {
        if (s0 < 0 || s0 >= m || e0 < 0 || e0 >= m || s1 < 0 || s1 >= n || e1 < 0 || e1 >= n) {
            return false;
        }
        if (e0 < s0 || e1 < s1) {
            return false;
        }
        int mid0 = s0 + (e0 - s0) / 2;
        int mid1 = s1 + (e1 - s1) / 2;
        int val = matrix[mid0][mid1];
        if (val == target) {
            return true;
        }
        if (s0 == e0 && s1 == e1) {
            return false;
        }
        if (val < target) {
            return doSearchMatrix(matrix, mid0 + 1, s1, e0, e1, target) || doSearchMatrix(matrix, s0, mid1 + 1, mid0, e1, target);
        } else {
            return doSearchMatrix(matrix, s0, s1, mid0 - 1, e1, target) || doSearchMatrix(matrix, mid0, s1, e0, mid1 - 1, target);
        }
    }
}
