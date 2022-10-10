package matches.no312;

public class Num6189 {

    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        int tempCount = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        for (int num : nums) {
            if (num == max) {
                tempCount++;
            } else {
                if (tempCount > count) {
                    count = tempCount;
                }
                tempCount = 0;
            }
        }
        if (tempCount > count) {
            count = tempCount;
        }
        return count;
    }
}
