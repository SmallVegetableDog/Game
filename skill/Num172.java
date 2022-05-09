package skill;

/**
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * <p>
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：0
 * 提示：
 * <p>
 * 0 <= n <= 104
 * <p>
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 */
public class Num172 {

    public static void main(String[] args) {
        Num172 num172 = new Num172();
        System.out.println(num172.trailingZeroes(200));
    }


    public int trailingZeroes(int n) {
        int k = 5;
        int sum = 0;
        while (k <= n) {
            sum = sum + n / k;
            k = k * 5;
        }
        return sum;
    }
}
