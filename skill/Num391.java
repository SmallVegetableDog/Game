package skill;

import java.util.HashSet;
import java.util.Set;

/**
 * 391. 完美矩形
 * 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。
 * <p>
 * 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
 * 输出：true
 * 解释：5 个矩形一起可以精确地覆盖一个矩形区域。
 * 示例 2：
 * <p>
 * <p>
 * 输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
 * 输出：false
 * 解释：两个矩形之间有间隔，无法覆盖成一个矩形。
 * 示例 3：
 * <p>
 * <p>
 * 输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
 * 输出：false
 * 解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= rectangles.length <= 2 * 104
 * rectangles[i].length == 4
 * -105 <= xi, yi, ai, bi <= 105
 */
public class Num391 {

    public static void main(String[] args) {
        Num391 num391 = new Num391();
        int[][] rec = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
        System.out.println(num391.isRectangleCover(rec));
    }

    public boolean isRectangleCover(int[][] rectangles) {
        int X1 = rectangles[0][0];
        int Y1 = rectangles[0][1];
        int X2 = rectangles[0][2];
        int Y2 = rectangles[0][3];
        int area = 0;
        for (int[] rec : rectangles) {
            X1 = Math.min(rec[0], X1);
            Y1 = Math.min(rec[1], Y1);
            X2 = Math.max(rec[2], X2);
            Y2 = Math.max(rec[3], Y2);
            area += (rec[2] - rec[0]) * (rec[3] - rec[1]);
        }
        //根据面积初步判断
        if (area != ((X2 - X1) * (Y2 - Y1))) {
            return false;
        }
        //根据顶点数判断，去除出现偶数次的顶点，保留出现奇数次的顶点。最后保留下来的顶点必是完美矩形的四个顶点
        Set<String> set = new HashSet<>();
        for (int[] rec : rectangles) {
            int x1 = rec[0];
            int y1 = rec[1];
            int x2 = rec[2];
            int y2 = rec[3];
            addSet(set, x1, y1);
            addSet(set, x2, y2);
            addSet(set, x1, y2);
            addSet(set, x2, y1);
        }
        if (set.size() != 4) {
            return false;
        }
        if (!set.contains(X1 + "," + Y1)) {
            return false;
        }
        if (!set.contains(X2 + "," + Y2)) {
            return false;
        }
        if (!set.contains(X1 + "," + Y2)) {
            return false;
        }
        if (!set.contains(X2 + "," + Y1)) {
            return false;
        }
        return true;
    }

    private void addSet(Set<String> set, int x1, int y1) {
        String s = x1 + "," + y1;
        if (set.contains(s)) {
            set.remove(s);
        } else {
            set.add(s);
        }
    }
}
