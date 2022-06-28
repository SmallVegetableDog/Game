package nuike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * HJ6 质数因子
 * 题目
 * 题解(499)
 * 讨论(1k)
 * 排行
 * 面经new
 * 简单  通过率：27.69%  时间限制：1秒  空间限制：32M
 * 知识点
 * 排序
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * <p>
 * <p>
 * 数据范围： 1 \le n \le 2 \times 10^{9} + 14 \1≤n≤2×10
 * 9
 * +14
 * 输入描述：
 * 输入一个整数
 * <p>
 * 输出描述：
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
 * <p>
 * 示例1
 * 输入：
 * 180
 * 复制
 * 输出：
 * 2 2 3 3 5
 */
public class HJ6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();
        boolean flag = false;
        for (int i = 2; i <= num; ) {
            if (num % i == 0) {
                if (flag || isSuShu(i)) {
                    nums.add(i);
                    flag = true;
                    num = num / i;
                    continue;
                }
            }
            i++;
            flag = false;
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    private static boolean isSuShu(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
