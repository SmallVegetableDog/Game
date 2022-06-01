package matches.no291;

/**
 * 2259. 移除指定数字得到的最大结果 显示英文描述
 * 通过的用户数4752
 * 尝试过的用户数5127
 * 用户总通过次数4851
 * 用户总提交次数10901
 * 题目难度Easy
 * 给你一个表示某个正整数的字符串 number 和一个字符 digit 。
 * <p>
 * 从 number 中 恰好 移除 一个 等于 digit 的字符后，找出并返回按 十进制 表示 最大 的结果字符串。生成的测试用例满足 digit 在 number 中出现至少一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：number = "123", digit = "3"
 * 输出："12"
 * 解释："123" 中只有一个 '3' ，在移除 '3' 之后，结果为 "12" 。
 * 示例 2：
 * <p>
 * 输入：number = "1231", digit = "1"
 * 输出："231"
 * 解释：可以移除第一个 '1' 得到 "231" 或者移除第二个 '1' 得到 "123" 。
 * 由于 231 > 123 ，返回 "231" 。
 * 示例 3：
 * <p>
 * 输入：number = "551", digit = "5"
 * 输出："51"
 * 解释：可以从 "551" 中移除第一个或者第二个 '5' 。
 * 两种方案的结果都是 "51" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= number.length <= 100
 * number 由数字 '1' 到 '9' 组成
 * digit 是 '1' 到 '9' 中的一个数字
 * digit 在 number 中出现至少一次
 */
public class Num2259 {

    public static void main(String[] args) {
        Num2259 num2259 = new Num2259();
        System.out.println(num2259.removeDigit("5", '5'));
    }

    public String removeDigit(String number, char digit) {
        int idx = -1;
        int length = number.length();
        for (int i = 0; i < length; i++) {
            char num = number.charAt(i);
            if (num == digit) {
                if (i == length - 1) {
                    idx = length - 1;
                } else {
                    if (number.charAt(i + 1) > num) {
                        idx = i;
                        break;
                    } else {
                        idx = i;
                    }
                }
            }
        }
        if (idx == length - 1) {
            return number.substring(0, length - 1);
        }
        return number.substring(0, idx) + number.substring(idx + 1);
    }
}
