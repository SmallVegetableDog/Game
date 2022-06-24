package dfs;

/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 */
public class Num79 {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A' , 'B' , 'C' , 'E'}, {'S' , 'F' , 'C' , 'S'}, {'A' , 'D' , 'E' , 'E'}};
        Num79 num79 = new Num79();
        System.out.println(num79.exist(board, "ABCCEDF"));
    }

    boolean[][] visit;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word.toCharArray(), 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int index, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (index == words.length) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (visit[i][j]) {
            return false;
        }
        if (words[index] != board[i][j]) {
            return false;
        }
        visit[i][j] = true;
        boolean res = dfs(board, words, index + 1, i - 1, j)
                || dfs(board, words, index + 1, i + 1, j)
                || dfs(board, words, index + 1, i, j - 1)
                || dfs(board, words, index + 1, i, j + 1);
        visit[i][j] = false;
        return res;
    }
}





























