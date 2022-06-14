package skill;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 31. 下一个排列
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * <p>
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class Num31 {

    public static void main(String[] args) {
        Num31 num31 = new Num31();
        num31.nextPermutation(new int[]{1, 3, 5, 4});
    }


    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        //i指针作为一个较小的数，j指针作为一个较大的数
        //从后往前扫描可以保证较大数和较小数交换后形成的新排列和原排列的差距最小
        //当满足i<j时，进行交换，并把i+1之后的数升序排列即为下一个排列
        for (int i = len - 2; i >= 0; i--) {
            for (int j = len - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    Arrays.sort(nums, i + 1, len);
                    return;
                }
            }
        }
        //处理3，2，1这种已经是最大排列的case
        for (int i = 0, j = len - 1; i < len / 2; i++, j--) {
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
