package interval;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间列表的交集
 * <p>
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 * <p>
 * 返回这 两个区间列表的交集 。
 * <p>
 * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
 * <p>
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：firstList = [[1,3],[5,9]], secondList = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：firstList = [], secondList = [[4,8],[10,12]]
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：firstList = [[1,7]], secondList = [[3,10]]
 * 输出：[[3,7]]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= firstList.length, secondList.length <= 1000
 * firstList.length + secondList.length >= 1
 * 0 <= starti < endi <= 109
 * endi < starti+1
 * 0 <= startj < endj <= 109
 * endj < startj+1
 * <p>
 * 链接：https://leetcode.cn/problems/interval-list-intersections
 */
public class Num986 {

    public static void main(String[] args) {
        Num986 num986 = new Num986();
        int[][] firstList = {{1, 3}, {5, 9}};
        int[][] secondList = {{2, 4}};
        System.out.println(num986.intervalIntersection(firstList, secondList));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int len1 = firstList.length;
        int len2 = secondList.length;
        int len = Math.max(len1, len2);
        if (len1 == 0) {
            return firstList;
        }
        if (len2 == 0) {
            return secondList;
        }
        ArrayList<int[]> fList = new ArrayList<>();
        ArrayList<int[]> sList = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            fList.add(firstList[i]);
        }
        for (int i = fList.size(); i <= len; i++) {
            fList.add(i, new int[]{-1, -1});
        }
        for (int i = 0; i < len2; i++) {
            sList.add(secondList[i]);
        }
        for (int i = sList.size(); i <= len; i++) {
            sList.add(i, new int[]{-1, -1});
        }
        List<int[]> res = new ArrayList<>();

        for (int i = 0, j = 0; i < len || j < len; ) {
            int l1 = fList.get(i)[0];
            int r1 = fList.get(i)[1];
            int l2 = sList.get(j)[0];
            int r2 = sList.get(j)[1];
            if (l1 == -1 || l2 == -1) {
                break;
            }
            int[] subRes = getData(l1, r1, l2, r2);
            if (subRes != null) {
                res.add(subRes);
            }
            if (r1 > r2) {
                j++;
            } else {
                i++;
            }
        }
        int index = 0;
        int[][] finalRes = new int[res.size()][2];
        for (int[] subRes : res) {
            finalRes[index++] = subRes;
        }
        return finalRes;
    }

    private int[] getData(int l1, int r1, int l2, int r2) {
        if (l1 == -1 || l2 == -1) {
            return null;
        }
        if (r1 < l2 || l1 > r2) {
            return null;
        }
        return new int[]{Math.max(l1, l2), Math.min(r1, r2)};
    }
}
