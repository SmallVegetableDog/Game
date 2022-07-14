package 快排;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * <p>
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class Num347 {

    public int[] topKFrequent(int[] nums, int k) {
        doFindKthLargest(nums,0, nums.length-1, k);
        for(int)
    }


    private int doFindKthLargest(int[] nums, int i, int j, int k) {
        int position = quickSort(nums, i, j);
        swap(nums, i, position);
        if (k == position+1) {
            return nums[position];
        } else if (k > position) {
            return doFindKthLargest(nums, position + 1, j, k);
        } else {
            return doFindKthLargest(nums, i, position - 1, k);
        }
    }

    private int quickSort(int[] nums, int i, int j) {
        int num = nums[i];
        int begin = i + 1;
        int end = j;
        while (begin <= end) {
            while (begin <= end && nums[begin] >= num) {
                begin++;
            }
            while (begin <= end && nums[end] < num) {
                end--;
            }
            if (begin <= end) {
                swap(nums, begin, end);
            }
        }
        return begin - 1;
    }

    private void swap(int[] nums, int i, int position) {
        int temp = nums[i];
        nums[i] = nums[position];
        nums[position] = temp;
    }
}
