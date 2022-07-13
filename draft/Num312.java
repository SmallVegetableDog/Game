package draft;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 312. 戳气球
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * <p>
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * <p>
 * 求所能获得硬币的最大数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [3,1,5,8]
 * 输出：167
 * 解释：
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * 示例 2：
 * <p>
 * 输入：nums = [1,5]
 * 输出：10
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 */
public class Num312 {

    public static void main(String[] args) {
        Num312 num312 = new Num312();
        System.out.println(num312.maxCoins(new int[]{3, 1, 5, 8}));
    }

    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[][] indexNums = new int[len][2];

        for (int i = 0; i < len; i++) {
            indexNums[i][0] = i;
            indexNums[i][1] = nums[i];
        }
        Arrays.sort(indexNums, Comparator.comparingInt(o -> o[1]));
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int index = indexNums[i][0];
            int num = nums[index];
            int numL = 1;
            int numR = 1;
            int j = index - 1;
            while (j >= 0 && nums[j] == -1) {
                j--;
            }
            if (j >= 0) {
                numL = nums[j];
            }
            j = index + 1;
            while (j <= len - 1 && nums[j] == -1) {
                j++;
            }
            if (j <= len - 1) {
                numR = nums[j];
            }
            sum = sum + (num * numL * numR);
            nums[index] = -1;
        }
        return sum;
    }
}
