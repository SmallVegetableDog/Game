package 动态规划;

import java.util.HashMap;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class Num128 {

    public static void main(String[] args) {
        Num128 num128 = new Num128();
        num128.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
    }

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            Integer left = map.getOrDefault(num - 1, 0);
            Integer right = map.getOrDefault(num + 1, 0);
            res = Math.max(res, left + right + 1);
            map.put(num, 1);
            map.put(num - left, left + right + 1);
            map.put(num + right, left + right + 1);
        }
        return res;
    }
}
