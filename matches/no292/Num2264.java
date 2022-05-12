package matches.no292;

/**
 * 给你一个字符串 num ，表示一个大整数。如果一个整数满足下述所有条件，则认为该整数是一个 优质整数 ：
 * <p>
 * 该整数是 num 的一个长度为 3 的 子字符串 。
 * 该整数由唯一一个数字重复 3 次组成。
 * 以字符串形式返回 最大的优质整数 。如果不存在满足要求的整数，则返回一个空字符串 "" 。
 * <p>
 * 注意：
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * num 或优质整数中可能存在 前导零 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "6777133339"
 * 输出："777"
 * 解释：num 中存在两个优质整数："777" 和 "333" 。
 * "777" 是最大的那个，所以返回 "777" 。
 * 示例 2：
 * <p>
 * 输入：num = "2300019"
 * 输出："000"
 * 解释："000" 是唯一一个优质整数。
 * 示例 3：
 * <p>
 * 输入：num = "42352338"
 * 输出：""
 * 解释：不存在长度为 3 且仅由一个唯一数字组成的整数。因此，不存在优质整数。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= num.length <= 1000
 * num 仅由数字（0 - 9）组成
 * <p>
 * 链接：https://leetcode.cn/problems/largest-3-same-digit-number-in-string
 */
public class Num2264 {

    public static void main(String[] args) {
        Num2264 num2264 = new Num2264();
        System.out.println(num2264.largestGoodInteger("6777133339"));
    }

    public String largestGoodInteger(String num) {
        char[] nums = num.toCharArray();
        char pre = 't';
        int count = 1;
        String res = "";
        for (char ch : nums) {
            if (ch == pre) {
                count++;
            } else {
                count = 1;
                pre = ch;
            }
            if (count == 3) {
                String str = new String(new char[]{pre, pre, pre});
                if (res.equals("")) {
                    res = str;
                } else if (res.charAt(0) < pre) {
                    res = str;
                }
                count = 1;
            }
        }
        return res;
    }
}
