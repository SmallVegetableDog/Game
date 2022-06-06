package matches.no289;

import java.util.HashMap;
import java.util.Objects;

/**
 * 2244. 完成所有任务需要的最少轮数 显示英文描述
 * 通过的用户数4785
 * 尝试过的用户数5235
 * 用户总通过次数4865
 * 用户总提交次数9447
 * 题目难度Medium
 * 给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。在每一轮中，你可以完成 2 个或者 3 个 相同难度级别 的任务。
 * <p>
 * 返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：tasks = [2,2,3,3,2,4,4,4,4,4]
 * 输出：4
 * 解释：要想完成所有任务，一个可能的计划是：
 * - 第一轮，完成难度级别为 2 的 3 个任务。
 * - 第二轮，完成难度级别为 3 的 2 个任务。
 * - 第三轮，完成难度级别为 4 的 3 个任务。
 * - 第四轮，完成难度级别为 4 的 2 个任务。
 * 可以证明，无法在少于 4 轮的情况下完成所有任务，所以答案为 4 。
 * 示例 2：
 * <p>
 * 输入：tasks = [2,3,3]
 * 输出：-1
 * 解释：难度级别为 2 的任务只有 1 个，但每一轮执行中，只能选择完成 2 个或者 3 个相同难度级别的任务。因此，无法完成所有任务，答案为 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tasks.length <= 105
 * 1 <= tasks[i] <= 109
 */
public class Num2244 {

    public static void main(String[] args) {
        Num2244 num2244 = new Num2244();
        num2244.minimumRounds(new int[]{69,65,62,64,70,68,69,67,60,65,69,62,65,65,61,66,68,61,65,63,60,66,68,66,67,65,63,65,70,69,70,62,68,70,60,68,65,61,64,65,63,62,62,62,67,62,62,61,66,69});
    }

    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> numToCount = new HashMap<>();
        for (int task : tasks) {
            Integer taskToCount = numToCount.get(task);
            if (Objects.isNull(taskToCount)) {
                numToCount.put(task, 1);
            } else {
                numToCount.put(task, taskToCount + 1);
            }
        }
        int sum = 0;

        for (int count : numToCount.values()) {
            if (count == 1) {
                return -1;
            }
            boolean div3 = count % 3 == 0;
            if (div3) {
                sum = sum + count / 3;
            } else {
                boolean div2 = (count - 2) % 3 == 0;
                if (div2) {
                    sum = sum + 1 + ((count - 2) / 3);
                } else {
                    sum = sum + 2 + ((count - 4) / 3);
                }
            }
        }
        return sum;
    }

    //1,3,2,1,2,2,2,1,2,3,1

}
