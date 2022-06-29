package 动态规划;

import java.util.List;
import java.util.Objects;

/**
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 */
public class Num139 {

    Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        return doWordBreak(s, wordDict);
    }

    //自底向上动态规划
    private boolean doWordBreak(String s, List<String> wordDict) {
        if (Objects.isNull(s) || s.length() == 0) {
            return true;
        }
        if (memo[s.length()-1] != null) {
            return memo[s.length()-1];
        }
        boolean res = false;
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                res = doWordBreak(s.substring(word.length()), wordDict);
                if (res) {
                    break;
                }
            }
        }
        memo[s.length()-1] = res;
        return res;
    }
}
