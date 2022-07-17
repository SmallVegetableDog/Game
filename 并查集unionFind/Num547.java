package 并查集unionFind;

/**
 * 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 * <p>
 * <p>
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class Num547 {

    public static void main(String[] args) {
        int[][] isConnected = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        Num547 num547 = new Num547();
        int circleNum = num547.findCircleNum(isConnected);
        System.out.println(circleNum);
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int len = n % 2 == 0 ? n / 2 : n / 2 + 1;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i <= len; i++) {
            int[] sub = isConnected[i];
            for (int j = 0; j < n; j++) {
                if (sub[j] == 0) {
                    continue;
                }
                if (i == j) {
                    continue;
                }
                unionFind.union(i, j);
            }
        }
        return unionFind.count;
    }

    class UnionFind {
        int count;

        int[] parent;

        int[] size;

        public UnionFind(int num) {
            parent = new int[num];
            size = new int[num];
            for (int i = 0; i < num; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            count = num;
        }

        public void union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi == pj) {
                return;
            }
            if (size[pi] < size[pj]) {
                parent[pj] = pi;
                size[pi] = size[pi] + size[pj];
            } else {
                parent[pi] = pj;
                size[pj] = size[pj] + size[pi];
            }
            count--;
        }

        public int find(int i) {
            while (parent[i] != i) {
                i = parent[parent[i]];
            }
            return i;
        }
    }
}
