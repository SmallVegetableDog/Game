package 差分数组;

/**
 * 假设你有一个长度为 n 的数组，初始情况下所有的数宇均为 0，你将会被给出 k个更新的操作。
 * 其中，每个操作会被表示为一个三元组：[startindex, endindex, inc]，你需要将子数
 * 组 A[startindex...endIndex]（包括 startlndex 和endlndex）增加inc。
 * 请你返回 k 次操作后的数组。
 * 示例：
 * 输入：length =5, updates = [[1,3,2], [2,4,3],[0,2,-2]]
 * 输出：[-2,0,3,5,3]
 * 解释：
 * 初始状态：
 * [0,0,0,0,0]
 * 进行了操作 [1,3,2] 后的状态：
 * [0,2,2,2,0]
 * 进行了操作 [2,4,3] 后的状态：
 * [0,2,5,5,3]
 * 进行了操作 [0,2,-2] 后的状态：
 * [-2,0,3,5,3]
 */
public class Num370 {

    public static void main(String[] args) {
        Num370 num370 = new Num370();
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        int[] modifiedArray = num370.getModifiedArray(5, updates);
    }

    int[] getModifiedArray(int length, int[][] updates) {
        // nums 初始化为全 0
        int[] nums = new int[length];
        // 构造差分解法
        Difference df = new Difference(nums);

        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            df.increment(i, j, val);
            int[] result = df.result();
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        return df.result();
    }

    class Difference {
        int[] diff;

        Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] = diff[i] + val;
            if (j + 1 < diff.length) {
                diff[j + 1] = diff[j + 1] - val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
