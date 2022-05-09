package dp.gambling;

/**
 * [2,100,500,100]
 * 甲乙每次只能从前后两边选择获取一个数字，先后手各自最大利润
 */
public class StoneGame {

    public static void main(String[] args) {
        StoneGame stoneGame = new StoneGame();
        stoneGame.gambling(new int[]{2,100,500,100});
    }

    int gambling(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] res = dp(nums, 0, nums.length - 1);
        System.out.println(res[0]+"--"+res[1]);
        return 0;
    }

    private int[] dp(int[] nums, int begin, int end) {
        int[] res = new int[2];
        if (end - begin == 1) {
            if (nums[begin] > nums[end]) {
                res[0] = nums[begin];
                res[1] = nums[end];
            } else {
                res[1] = nums[begin];
                res[0] = nums[end];
            }
            return res;
        }

        res[0] = Math.max(dp(nums, begin + 1, end)[1]+nums[begin], dp(nums, begin, end - 1)[1]+nums[end]);
        res[1] = Math.min(dp(nums, begin + 1, end)[0], dp(nums, begin, end - 1)[0]);
        return res;
    }
}
