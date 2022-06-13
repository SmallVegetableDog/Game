package matches.no297;

/**
 * 5289. 公平分发饼干 显示英文描述
 * 通过的用户数1373
 * 尝试过的用户数1793
 * 用户总通过次数1452
 * 用户总提交次数2788
 * 题目难度Medium
 * 给你一个整数数组 cookies ，其中 cookies[i] 表示在第 i 个零食包中的饼干数量。另给你一个整数 k 表示等待分发零食包的孩子数量，所有 零食包都需要分发。在同一个零食包中的所有饼干都必须分发给同一个孩子，不能分开。
 * <p>
 * 分发的 不公平程度 定义为单个孩子在分发过程中能够获得饼干的最大总数。
 * <p>
 * 返回所有分发的最小不公平程度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：cookies = [8,15,10,20,8], k = 2
 * 输出：31
 * 解释：一种最优方案是 [8,15,8] 和 [10,20] 。
 * - 第 1 个孩子分到 [8,15,8] ，总计 8 + 15 + 8 = 31 块饼干。
 * - 第 2 个孩子分到 [10,20] ，总计 10 + 20 = 30 块饼干。
 * 分发的不公平程度为 max(31,30) = 31 。
 * 可以证明不存在不公平程度小于 31 的分发方案。
 * 示例 2：
 * <p>
 * 输入：cookies = [6,1,3,2,2,4,1,2], k = 3
 * 输出：7
 * 解释：一种最优方案是 [6,1]、[3,2,2] 和 [4,1,2] 。
 * - 第 1 个孩子分到 [6,1] ，总计 6 + 1 = 7 块饼干。
 * - 第 2 个孩子分到 [3,2,2] ，总计 3 + 2 + 2 = 7 块饼干。
 * - 第 3 个孩子分到 [4,1,2] ，总计 4 + 1 + 2 = 7 块饼干。
 * 分发的不公平程度为 max(7,7,7) = 7 。
 * 可以证明不存在不公平程度小于 7 的分发方案。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= cookies.length <= 8
 * 1 <= cookies[i] <= 105
 * 2 <= k <= cookies.length
 */
public class Num5289 {

    public static void main(String[] args) {
        Num5289 num5289 = new Num5289();
        int[] cookies = {8, 15, 10, 20, 8};
        int i = num5289.distributeCookies(cookies, 2);
        System.out.println(i);
    }

    int[] nums;

    int res = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        nums = new int[k];
        backTrack(cookies, 0, k);
        return res;
    }

    /**
     * @param cookies 零食
     * @param i       第i包零食
     * @param k       k个小朋友
     */
    private void backTrack(int[] cookies, int i, int k) {
        //零食已经分完了
        if (i == cookies.length) {
            int n = Integer.MIN_VALUE;
            for (int num : nums) {
                n = Math.max(n, num);
            }
            res = Math.min(n, res);
            return;
        }
        //将第i袋零食枚举分给k个小朋友
        for (int j = 0; j < k; j++) {
            nums[j] = nums[j] + cookies[i];
            backTrack(cookies, i + 1, k);
            nums[j] = nums[j] - cookies[i];
        }
    }
}
