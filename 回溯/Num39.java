package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都 互不相同
 * 1 <= target <= 500
 */
public class Num39 {

    public static void main(String[] args) {
        Num39 num39 = new Num39();
        System.out.println(num39.combinationSum(new int[]{2, 3, 1}, 7));
        System.out.println();
    }

    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>(150);
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new LinkedList<>());
        return result;
    }

    private void backTrack(int[] candidates, int target, int start, LinkedList<Integer> combination) {
        if (target == 0) {
            result.add(new LinkedList<>(combination));
            return;
        }
        if (target < 0) {
            return;
        }
        if (target - candidates[start] < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combination.addLast(candidates[i]);
            backTrack(candidates, target - candidates[i], i, combination);
            combination.removeLast();
        }
    }
}
