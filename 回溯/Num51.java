package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * 困难
 * 1.8K
 * 相关企业
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 */
public class Num51 {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        doSolveNQueens(n, 0, new int[n][n]);
        return result;
    }

    private void doSolveNQueens(int n, int now, int[][] res) {
        if (now == n) {
            result.add(trans(res));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (assertPosition(now, i, res)) {
                res[now][i] = 1;
                doSolveNQueens(n, now + 1, res);
            }
            res[now][i] = 0;
        }
    }

    private List<String> trans(int[][] res) {
        ArrayList<String> strings = new ArrayList<>();
        for (int[] subRes : res) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int val : subRes) {
                if (val == 1) {
                    stringBuilder.append('Q');
                } else {
                    stringBuilder.append('.');
                }
            }
            strings.add(stringBuilder.toString());
        }
        return strings;
    }

    private boolean assertPosition(int now, int col, int[][] res) {
        for (int i = 0; i < now; i++) {
            for (int j = 0; j < res.length; j++) {
                if (res[i][j] == 1) {
                    if (j == col) {
                        return false;
                    }
                    if (Math.abs(i - now) == Math.abs(j - col)) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }
}
