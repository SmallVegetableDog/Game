package dp.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 电子游戏“辐射4”中，任务 “通向自由” 要求玩家到达名为 “Freedom Trail Ring” 的金属表盘，并使用表盘拼写特定关键词才能开门。
 * <p>
 * 给定一个字符串 ring ，表示刻在外环上的编码；给定另一个字符串 key ，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 * <p>
 * 最初，ring 的第一个字符与 12:00 方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 * <p>
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 * <p>
 * 您可以将 ring 顺时针或逆时针旋转 一个位置 ，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ring = "godding", key = "gd"
 * 输出: 4
 * 解释:
 * 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
 * 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 * 当然, 我们还需要1步进行拼写。
 * 因此最终的输出是 4。
 * 示例 2:
 * <p>
 * 输入: ring = "godding", key = "godding"
 * 输出: 13
 * <p>
 * 提示：
 * <p>
 * 1 <= ring.length, key.length <= 100
 * ring 和 key 只包含小写英文字母
 * 保证 字符串 key 一定可以由字符串  ring 旋转拼出
 * <p>
 * 链接：https://leetcode.cn/problems/freedom-trail
 */
public class Num514 {

    public static void main(String[] args) {
        Num514 num514 = new Num514();
        System.out.println(num514.findRotateSteps("godding", "gd"));
        //System.out.println(num514.findRotateSteps("god", "gd"));
    }

    private Map<Character, List<Integer>> chatToIndex;

    private int[][] memo;

    public int findRotateSteps(String ring, String key) {
        chatToIndex = new HashMap<>();
        memo = new int[ring.length()][key.length()];
        char[] chars = ring.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            List<Integer> indexs = chatToIndex.get(chars[i]);
            if (Objects.isNull(indexs)) {
                indexs = new LinkedList<>();
                chatToIndex.put(chars[i], indexs);
            }
            indexs.add(i);
        }
        return dp(chars, 0, key.toCharArray(), 0);
    }

    /**
     * @param ring 表盘ring
     * @param i    表盘chars的索引
     * @param key  目标串
     * @param j    目标串的索引
     * @return
     */
    private int dp(char[] ring, int i, char[] key, int j) {
        if (j == key.length) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        List<Integer> indexs = chatToIndex.get(key[j]);
        int res = Integer.MAX_VALUE;
        for (int index : indexs) {
            int juli = Math.min(Math.abs(i - index), Math.abs(i + ring.length - index));
            res = Math.min(dp(ring, index, key, j + 1) + juli + 1, res);
        }
        memo[i][j] = res;
        return res;
    }
}
