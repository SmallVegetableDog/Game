package skill;

/**
 * 668. 乘法表中第k小的数
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 * <p>
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 * <p>
 * 例 1：
 * <p>
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 * <p>
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 * 例 2：
 * <p>
 * 输入: m = 2, n = 3, k = 6
 * 输出: 6
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * <p>
 * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 * 注意：
 * <p>
 * m 和 n 的范围在 [1, 30000] 之间。
 * k 的范围在 [1, m * n] 之间。
 */
public class Num668 {

    /**
     * 找第k小的数可转化为
     * 给定一个数x，找出小于等于x的数的数量count
     * 于是可以使用二分查找逼出这个数x（1，m*n）
     * 数x需要取尽可能小，因为最小的x才会存在乘法表中
     * 为什么最小的x才会存在乘法表中？因为要保证数x在乘法表中
     * 假设法：假设符合条件的x取得是最小的，并且小于等于x的数量等于count。那么小于等于(x-1)的数量一定小于count。因此x这个数肯定是在乘法表中才会导致(x-1)的数量一定小于count
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; i++) {
                count = count + x / i;
            }
            if (count > k) {
                right = x;
            } else if (count < k) {
                left = x + 1;
            } else {
                right = x;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Num668 num668 = new Num668();
        System.out.println(num668.findKthNumber(11,13,57));
    }
}
