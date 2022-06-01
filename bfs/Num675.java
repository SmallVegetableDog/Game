package bfs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 675. 为高尔夫比赛砍树
 * 你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个 m x n 的矩阵表示， 在这个矩阵中：
 * <p>
 * 0 表示障碍，无法触碰
 * 1 表示地面，可以行走
 * 比 1 大的数 表示有树的单元格，可以行走，数值表示树的高度
 * 每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。
 * <p>
 * 你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 1（即变为地面）。
 * <p>
 * 你将从 (0, 0) 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。
 * <p>
 * 可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：forest = [[1,2,3],[0,0,4],[7,6,5]]
 * 输出：6
 * 解释：沿着上面的路径，你可以用 6 步，按从最矮到最高的顺序砍掉这些树。
 * 示例 2：
 * <p>
 * <p>
 * 输入：forest = [[1,2,3],[0,0,0],[7,6,5]]
 * 输出：-1
 * 解释：由于中间一行被障碍阻塞，无法访问最下面一行中的树。
 * 示例 3：
 * <p>
 * 输入：forest = [[2,3,4],[0,0,5],[8,7,6]]
 * 输出：6
 * 解释：可以按与示例 1 相同的路径来砍掉所有的树。
 * (0,0) 位置的树，可以直接砍去，不用算步数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == forest.length
 * n == forest[i].length
 * 1 <= m, n <= 50
 * 0 <= forest[i][j] <= 109
 */
public class Num675 {
    //[[54581641,64080174,24346381,69107959],[86374198,61363882,68783324,79706116],[668150,92178815,89819108,94701471],[83920491,22724204,46281641,47531096],[89078499,18904913,25462145,60813308]]

    public static void main(String[] args) {
        Num675 num675 = new Num675();
        List<List<Integer>> forest = Arrays.asList(
                Arrays.asList(4, 2, 3),
                Arrays.asList(0, 0, 1), Arrays.asList(7, 6, 5)
        );
//        List<List<Integer>> forest = Arrays.asList(
//                Arrays.asList(54581641, 64080174, 24346381, 69107959),
//                Arrays.asList(86374198, 61363882, 68783324, 79706116),
//                Arrays.asList(668150, 92178815, 89819108, 94701471),
//                Arrays.asList(83920491, 22724204, 46281641, 47531096),
//                Arrays.asList(89078499, 18904913, 25462145, 60813308)
//        );
        System.out.println(num675.cutOffTree(forest));
    }

    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] nums = new int[m * n][3];
        int[][] digit = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Integer val = forest.get(i).get(j);
                digit[i][j] = val;
                if (val <= 1) {
                    continue;
                }
                int[] num = {val, i, j};
                nums[count++] = num;
            }
        }
        Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));
        int sum = 0;
        int si = 0, sj = 0;
        for (int i = 0; i < nums.length; i++) {
            int res = bfs(si, sj, nums[i], buildGraph(forest));
            if (res == -1) {
                return -1;
            }
            si = nums[i][1];
            sj = nums[i][2];
            sum = sum + res;
        }
        return sum;
    }

    private int[][] buildGraph(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] digit = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Integer val = forest.get(i).get(j);
                digit[i][j] = val;
            }
        }
        return digit;
    }

    private int bfs(int si, int sj, int[] num, int[][] digit) {
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{si, sj});
        digit[si][sj] = 0;
        int ei = num[1];
        int ej = num[2];
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (ei == poll[0] && ej == poll[1]) {
                    return count;
                }
                addQueue(poll[0], poll[1], digit, queue);
            }
            count++;
        }
        return -1;
    }

    private void addQueue(int i, int j, int[][] digit, Queue<int[]> queue) {
        doAddQueue(i - 1, j, digit, queue);
        doAddQueue(i + 1, j, digit, queue);
        doAddQueue(i, j - 1, digit, queue);
        doAddQueue(i, j + 1, digit, queue);
    }

    private void doAddQueue(int i, int j, int[][] digit, Queue<int[]> queue) {
        if (i < 0 || j < 0 || i >= digit.length || j >= digit[0].length) {
            return;
        }
        if (digit[i][j] == 0) {
            return;
        }
        queue.add(new int[]{i, j});
        digit[i][j] = 0;
    }
}
