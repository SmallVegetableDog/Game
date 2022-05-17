package matches.no293;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 对数组 nums 执行 按位与 相当于对数组 nums 中的所有整数执行 按位与 。
 * <p>
 * 例如，对 nums = [1, 5, 3] 来说，按位与等于 1 & 5 & 3 = 1 。
 * 同样，对 nums = [7] 而言，按位与等于 7 。
 * 给你一个正整数数组 candidates 。计算 candidates 中的数字每种组合下 按位与 的结果。 candidates 中的每个数字在每种组合中只能使用 一次 。
 * <p>
 * 返回按位与结果大于 0 的 最长 组合的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [16,17,71,62,12,24,14]
 * 输出：4
 * 解释：组合 [16,17,62,24] 的按位与结果是 16 & 17 & 62 & 24 = 16 > 0 。
 * 组合长度是 4 。
 * 可以证明不存在按位与结果大于 0 且长度大于 4 的组合。
 * 注意，符合长度最大的组合可能不止一种。
 * 例如，组合 [62,12,24,14] 的按位与结果是 62 & 12 & 24 & 14 = 8 > 0 。
 * 示例 2：
 * <p>
 * 输入：candidates = [8,8]
 * 输出：2
 * 解释：最长组合是 [8,8] ，按位与结果 8 & 8 = 8 > 0 。
 * 组合长度是 2 ，所以返回 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 105
 * 1 <= candidates[i] <= 107
 */
public class Num6065 {

    public static void main(String[] args) {
        Num6065 num6065 = new Num6065();
        System.out.println(num6065.largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14}));
    }

    //返回按位与结果大于 0 的 最长 组合的长度。也就是找出某一位都是1的组合的最长长度
    public int largestCombination(int[] candidates) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int subRes = 0;
            for (int candidate : candidates) {
                if ((candidate >> i & 1) == 1) {
                    subRes++;
                }
            }
            if (subRes > res) {
                res = subRes;
            }
        }
        return res;
    }
}
