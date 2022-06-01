package matches.no291;

import java.util.HashMap;
import java.util.Map;

/**
 * 2260. 必须拿起的最小连续卡牌数 显示英文描述
 * 通过的用户数4375
 * 尝试过的用户数4896
 * 用户总通过次数4442
 * 用户总提交次数9727
 * 题目难度Medium
 * 给你一个整数数组 cards ，其中 cards[i] 表示第 i 张卡牌的 值 。如果两张卡牌的值相同，则认为这一对卡牌 匹配 。
 * <p>
 * 返回你必须拿起的最小连续卡牌数，以使在拿起的卡牌中有一对匹配的卡牌。如果无法得到一对匹配的卡牌，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：cards = [3,4,2,3,4,7]
 * 输出：4
 * 解释：拿起卡牌 [3,4,2,3] 将会包含一对值为 3 的匹配卡牌。注意，拿起 [4,2,3,4] 也是最优方案。
 * 示例 2：
 * <p>
 * 输入：cards = [1,0,5,3]
 * 输出：-1
 * 解释：无法找出含一对匹配卡牌的一组连续卡牌。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= cards.length <= 105
 * 0 <= cards[i] <= 106
 */
public class Num2260 {

    public static void main(String[] args) {

    }

    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> memo = new HashMap();
        int val = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            int card = cards[i];
            Integer idx = memo.get(card);
            if (idx != null) {
                int interval = i - idx + 1;
                if (interval < val) {
                    val = interval;
                }
            }
            memo.put(card, i);
        }
        return val == Integer.MAX_VALUE ? -1 : val;
    }
}
