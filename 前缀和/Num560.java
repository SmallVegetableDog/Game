package 前缀和;

import java.util.HashMap;

/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class Num560 {
    public static void main(String[] args) {
        Num560 num560 = new Num560();
        System.out.println(num560.subarraySum(new int[]{1, 2, 1, 2, 1}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length];
        //前缀和=》数量
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i] = sum + nums[i];
            sum = sum + nums[i];
        }
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            //期待的前缀和
            int expectSum = preSum[i]-k;
            if (map.containsKey(expectSum)) {
                count = count + map.get(expectSum);
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        return count;
    }

}
