package skill;

import java.util.Arrays;

/**
 * 462. 最少移动次数使数组元素相等 II
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 * <p>
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,2,9]
 * 输出：16
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class Num462 {


    public static void main(String[] args) {
        Num462 num462 = new Num462();
        System.out.println(num462.minMoves2(new int[]{203125577, -349566234, 230332704, 48321315, 66379082, 386516853, 50986744, -250908656, -425653504, -212123143}));
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int s = nums[nums.length/2];
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            res = res + Math.abs(nums[i]-s);
        }
        return res;
    }

//    HashSet<String> memo = new HashSet<>();
//    int res;
//
//
//    //暴力bfs 超时
//    public int minMoves2(int[] nums) {
//
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(nums);
//        StringBuilder numsStr1 = new StringBuilder();
//        for (int num : nums) {
//            numsStr1.append(num);
//            numsStr1.append("-");
//        }
//        memo.add(numsStr1.toString());
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size-- != 0) {
//                int[] poll = queue.poll();
//                int preNum = poll[0];
//                int i;
//                for (i = 1; i < poll.length; i++) {
//                    if (preNum != poll[i]) {
//                        break;
//                    }
//                }
//                if (i == poll.length) {
//                    return res;
//                }
//                for (int j = 0; j < nums.length; j++) {
//                    addQueue(j, poll, queue);
//                }
//            }
//            res++;
//        }
//
//        return res;
//    }
//
//    private void addQueue(int i, int[] nums, Queue<int[]> queue) {
//        StringBuilder numsStr1 = new StringBuilder();
//        StringBuilder numsStr2 = new StringBuilder();
//        int[] nums1 = nums.clone();
//        int[] nums2 = nums.clone();
//        for (int j = 0; j < nums.length; j++) {
//            if (j == i) {
//                numsStr1.append(nums[j] - 1);
//                nums1[j] = nums[j] - 1;
//                numsStr2.append(nums[j] + 1);
//                nums2[j] = nums[j] + 1;
//            } else {
//                numsStr1.append(nums[j]);
//                numsStr2.append(nums[j]);
//            }
//            numsStr1.append("-");
//            numsStr2.append("-");
//        }
//        if (!memo.contains(numsStr1.toString())) {
//            queue.add(nums1);
//            memo.add(numsStr1.toString());
//        }
//        if (!memo.contains(numsStr2.toString())) {
//            queue.add(nums2);
//            memo.add(numsStr2.toString());
//        }
//    }
}
