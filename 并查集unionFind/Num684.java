package 并查集unionFind;

/**
 * 684. 冗余连接
 * 树可以看成是一个连通且 无环 的 无向 图。
 * <p>
 * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 * <p>
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: edges = [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入: edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 * <p>
 * <p>
 * 提示:
 * <p>
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * edges 中无重复元素
 * 给定的图是连通的
 */
public class Num684 {

    int[] res = new int[2];

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            unionFind.union(edges[i][0]-1, edges[i][1]-1);
        }
        return res;
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
                res[0] = i+1;
                res[1] = j+1;
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
