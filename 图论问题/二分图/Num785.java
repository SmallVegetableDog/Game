package 图论问题.二分图;

/**
 * 785. 判断二分图
 * 存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。给你一个二维数组 graph ，其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于 graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有以下属性：
 * 不存在自环（graph[u] 不包含 u）。
 * 不存在平行边（graph[u] 不包含重复值）。
 * 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
 * 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
 * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
 * <p>
 * 如果图是二分图，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * 输出：false
 * 解释：不能将节点分割成两个独立的子集，以使每条边都连通一个子集中的一个节点与另一个子集中的一个节点。
 * 示例 2：
 * <p>
 * <p>
 * 输入：graph = [[1,3],[0,2],[1,3],[0,2]]
 * 输出：true
 * 解释：可以将节点分成两组: {0, 2} 和 {1, 3} 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * graph.length == n
 * 1 <= n <= 100
 * 0 <= graph[u].length < n
 * 0 <= graph[u][i] <= n - 1
 * graph[u] 不会包含 u
 * graph[u] 的所有值 互不相同
 * 如果 graph[u] 包含 v，那么 graph[v] 也会包含 u
 */
public class Num785 {

    Boolean[] color;
    boolean ok;

    public boolean isBipartite(int[][] graph) {
        color = new Boolean[graph.length];
        ok = true;
        //解决某些节点不存在边的case
        //[[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == null && graph[i].length > 0) {
                dfs(i, graph, true);
            }
        }
        return ok;
    }

    private void dfs(int i, int[][] graph, boolean col) {
        if (!ok) {
            return;
        }
        color[i] = col;
        //遍历i节点的邻接节点 染成和col相反的颜色
        for (int points : graph[i]) {
            //未染色
            if (color[points] == null) {
                dfs(points, graph, !col);
            } else { //染色了
                if (col == color[points]) {
                    ok = false;
                    return;
                }
            }
        }
    }
}
