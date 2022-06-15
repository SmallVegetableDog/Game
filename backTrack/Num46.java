package backTrack;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class Num46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> arrayList = new ArrayList();
        backTrack(nums, arrayList, 0, new LinkedHashSet());
        return arrayList;
    }

    private void backTrack(int[] nums, List<List<Integer>> arrayList, int index, Set<Integer> res) {
        if (index == nums.length) {
            arrayList.add(new ArrayList<>(res));
        }

        for (int i = 0; i < nums.length; i++) {
            if (res.contains(nums[i])) {
                continue;
            }
            res.add(nums[i]);
            backTrack(nums, arrayList, index + 1, res);
            res.remove(nums[i]);
        }
    }
}
