package 图论问题.二分图;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * <p>
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 * <p>
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 * <p>
 * 链接：https://leetcode-cn.com/problems/possible-bipartition
 */
public class Num886 {

    private boolean[] visited;

    private boolean[] color;

    private boolean ok;


    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n];
        color = new boolean[n];
        ok = true;
        List<Integer>[] graph = buildGraph(n, dislikes);
        for (int i = 0; i < n; i++) {
            traverse(i, graph);
        }
        return ok;
    }

    private void traverse(int i, List<Integer>[] graph) {
        if(!ok){
            return;
        }
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        List<Integer> subGraph = graph[i];
        if (Objects.isNull(subGraph)) {
            return;
        }
        for (Integer num : subGraph) {
            if (visited[num] && color[num] == color[i]) {
                ok = false;
                return;
            }
            if (!visited[num]) {
                color[num] = !color[i];
            }
            traverse(num, graph);
        }
    }

    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        ArrayList[] graph = new ArrayList[n];
        for (int[] dislike : dislikes) {
            int from = dislike[0] - 1;
            int to = dislike[1] - 1;
            ArrayList fromList = graph[from];
            ArrayList toList = graph[to];
            if (Objects.isNull(fromList)) {
                fromList = new ArrayList();
                graph[from] = fromList;
            }
            if (Objects.isNull(toList)) {
                toList = new ArrayList();
                graph[to] = toList;
            }
            fromList.add(to);
            toList.add(from);
        }
        return graph;
    }

    public static void main(String[] args) {
        Num886 num886 = new Num886();
        boolean b = num886.possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}});
        //boolean b = num886.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}});
        System.out.println(b);
    }
}





















