package matches.no290;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2248. 多个数组求交集 显示英文描述
 * 通过的用户数4614
 * 尝试过的用户数4709
 * 用户总通过次数4679
 * 用户总提交次数7100
 * 题目难度Easy
 * 给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，按 升序排列 返回一个数组，数组中的每个元素在 nums 所有数组 中都出现过。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
 * 输出：[3,4]
 * 解释：
 * nums[0] = [3,1,2,4,5]，nums[1] = [1,2,3,4]，nums[2] = [3,4,5,6]，在 nums 中每个数组中都出现的数字是 3 和 4 ，所以返回 [3,4] 。
 * 示例 2：
 * <p>
 * 输入：nums = [[1,2,3],[4,5,6]]
 * 输出：[]
 * 解释：
 * 不存在同时出现在 nums[0] 和 nums[1] 的整数，所以返回一个空列表 [] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= sum(nums[i].length) <= 1000
 * 1 <= nums[i][j] <= 1000
 * nums[i] 中的所有值 互不相同
 */
public class Num2248 {

    public List<Integer> intersection(int[][] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] numss : nums) {
            for (int num : numss) {
                Integer n = map.getOrDefault(num, 0);
                map.put(num, n + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value == nums.length) {
                res.add(entry.getKey());
            }
        }
        Collections.sort(res);
        return res;
    }
}
