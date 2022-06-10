package 图论问题;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 *
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 *
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 *
 * 链接：https://leetcode-cn.com/problems/course-schedule-ii
 */
public class Num210 {


    private boolean[] visited;

    private boolean[] onPath;

    private ArrayList<Integer> res;


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        res = new ArrayList<>(numCourses);
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            if (!traverse(i, graph)) {
                return new int[]{};
            }
        }
        int[] finalRes = new int[this.res.size()];
        for (int i = 0;i<res.size();i++) {
            finalRes[i] = res.get(res.size()-1-i);
        }
        return finalRes;
    }

    private boolean traverse(int i, List<Integer>[] graph) {
        List<Integer> routes = graph[i];
        if (onPath[i]) {
            return false;
        }
        if (visited[i]) {
            return true;
        }
        visited[i] = true;
        if (!Objects.isNull(routes)) {
            onPath[i] = true;
            for (Integer route : routes) {
                if (!traverse(route, graph)) {
                    return false;
                }
            }
            onPath[i] = false;
        }
        res.add(i);
        return true;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            List<Integer> subGraph = graph[from];
            if (Objects.isNull(subGraph)) {
                subGraph = new ArrayList<>();
            }
            subGraph.add(to);
            graph[from] = subGraph;
        }
        return graph;
    }

    public static void main(String[] args) {
        Num210 num210 = new Num210();
//        boolean canFinish = num207.canFinish(2, new int[][]{{1, 0}, {0, 1}});
        int[]res =  num210.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});

        System.out.println(res);
    }
}
