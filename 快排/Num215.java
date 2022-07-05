package 快排;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 */
public class Num215 {

    public static void main(String[] args) {
        Num215 num215 = new Num215();
        System.out.println(num215.findKthLargest(new int[]{-1,2,0},2));
    }

    public int findKthLargest(int[] nums, int k) {
        return doFindKthLargest(nums, 0, nums.length - 1, k);
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
