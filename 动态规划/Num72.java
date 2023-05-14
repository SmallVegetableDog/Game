package 动态规划;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num72 {

    int[][] dp;
    public static void main(String[] args) {
        Num72 num72 = new Num72();
        System.out.println(num72.minDistance("aba","bbb"));
    }


    /**
     * 递归解法 自顶向下解法
     * dp[i][j] <==> 字符串word1 [0,i] 替换成字符串word2 [0,j]所需要的操作数
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0) {
            return len2;
        }
        dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
//
//    /**
//     * dp table 自底向上解法
//     * dp[i][j] <==> 字符串word1 [0,i] 替换成字符串word2 [0,j]所需要的操作数
//     *
//     * @param word1
//     * @param word2
//     * @return
//     */
//    public int minDistance(String word1, String word2) {
//        int len1 = word1.length() + 1;
//        int len2 = word2.length() + 1;
//        int[][] dp = new int[len1][len2];
//        for (int i = 0; i < len1; i++) {
//            dp[i][0] = i;
//        }
//        for (int i = 0; i < len2; i++) {
//            dp[0][i] = i;
//        }
//        for (int i = 1; i < len1; i++) {
//            for (int j = 1; j < len2; j++) {
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    //增加
//                    int val1 = dp[i - 1][j] + 1;
//                    //删除
//                    int val2 = dp[i][j - 1] + 1;
//                    //替换
//                    int val3 = dp[i - 1][j - 1] + 1;
//                    dp[i][j] = Math.min(val1, Math.min(val2, val3));
//                }
//            }
//        }
//        return dp[len1-1][len2-1];
//    }


}
