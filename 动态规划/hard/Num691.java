package 动态规划.hard;

/**
 * 我们有 n 种不同的贴纸。每个贴纸上都有一个小写的英文单词。
 * <p>
 * 您想要拼写出给定的字符串 target ，方法是从收集的贴纸中切割单个字母并重新排列它们。如果你愿意，你可以多次使用每个贴纸，每个贴纸的数量是无限的。
 * <p>
 * 返回你需要拼出 target 的最小贴纸数量。如果任务不可能，则返回 -1 。
 * <p>
 * 注意：在所有的测试用例中，所有的单词都是从 1000 个最常见的美国英语单词中随机选择的，并且 target 被选择为两个随机单词的连接。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： stickers = ["with","example","science"], target = "thehat"
 * 输出：3
 * 解释：
 * 我们可以使用 2 个 "with" 贴纸，和 1 个 "example" 贴纸。
 * 把贴纸上的字母剪下来并重新排列后，就可以形成目标 “thehat“ 了。
 * 此外，这是形成目标字符串所需的最小贴纸数量。
 * 示例 2:
 * <p>
 * 输入：stickers = ["notice","possible"], target = "basicbasic"
 * 输出：-1
 * 解释：我们不能通过剪切给定贴纸的字母来形成目标“basicbasic”。
 *  
 * <p>
 * 提示:
 * <p>
 * n == stickers.length
 * 1 <= n <= 50
 * 1 <= stickers[i].length <= 10
 * 1 <= target <= 15
 * stickers[i] 和 target 由小写英文单词组成
 * <p>
 * 链接：https://leetcode.cn/problems/stickers-to-spell-word
 */
public class Num691 {

    public static void main(String[] args) {
        Num691 num691 = new Num691();
        String[] strings = {"with", "example", "science"};
        System.out.println(num691.minStickers(strings, "thehat"));
    }

    int[] memo;

    public int minStickers(String[] stickers, String target) {
        memo = new int[1 << target.length()];
        return dp(stickers, target.toCharArray(), 0);
    }

    /**
     * 设目标串target长度为n，建立一个长度为n的数组nums默认值为0，当第i位被stickers成功置换则把第i位置为1，所以当数组nums的值都填充为1时求得结果
     * 数组nums的值就是状态，选择就是根据stickers进行遍历选取最小值
     * 由于target长度为15以内，所以可以转化为一个long型的整数status来代替nums数组（status的状态数量为2的15次方-1），即base case为(1 << len) - 1 == status
     * 但其实在力扣上使用int类型即可通过用例
     *
     * @param stickers
     * @param target
     * @param status
     * @return
     */
    private int dp(String[] stickers, char[] target, int status) {
        int len = target.length;
        if ((1 << len) - 1 == status) {
            return 0;
        }
        if (memo[status] != 0) {
            return memo[status];
        }
        int res = 16;
        for (String sticker : stickers) {
            //将sticker的每个字符存入数组，数组下标为字符-‘a’。值为字符数量
            int[] num = new int[26];
            for (char s : sticker.toCharArray()) {
                num[s - 'a']++;
            }
            int newStatus = status;
            for (int i = 0; i < target.length; i++) {
                char tar = target[i];
                //newStatus的第i位没有被置为1
                boolean bitStatus = ((1 << i) & newStatus) == 0;
                //sticker字符串中含有tar字符 && newStatus的第i位没有被置为1
                if (num[tar - 'a'] > 0 && bitStatus) {
                    newStatus = newStatus | (1 << i);
                    num[tar - 'a']--;
                }
            }
            if (newStatus != status) {
                //状态转换
                int dp = dp(stickers, target, newStatus);
                if (dp != -1) {
                    res = Math.min(res, dp + 1);
                }
            }
        }
        memo[status] = res;
        return res == 16 ? -1 : res;
    }
}
