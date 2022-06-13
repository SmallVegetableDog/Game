package backTrack;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Num17 {

    private List<String> sequenceList;

    private Map<Integer, char[]> numToAlphabet;

    public List<String> letterCombinations(String digits) {
        if (Objects.isNull(digits) || digits.length() == 0) {
            return new ArrayList<>();
        }
        sequenceList = new ArrayList<>();
        numToAlphabet = new HashMap<>();
        numToAlphabet.put(2, new char[]{'a', 'b', 'c'});
        numToAlphabet.put(3, new char[]{'d', 'e', 'f'});
        numToAlphabet.put(4, new char[]{'g', 'h', 'i'});
        numToAlphabet.put(5, new char[]{'j', 'k', 'l'});
        numToAlphabet.put(6, new char[]{'m', 'n', 'o'});
        numToAlphabet.put(7, new char[]{'p', 'q', 'r', 's'});
        numToAlphabet.put(8, new char[]{'t', 'u', 'v'});
        numToAlphabet.put(9, new char[]{'w', 'x', 'y', 'z'});
        dfs(digits, 0, "");
        return sequenceList;
    }

    private void dfs(String number, int i, String seq) {
        if (i == number.length()) {
            sequenceList.add(seq);
            return;
        }
        int c = number.charAt(i) - '0';
        char[] chars = numToAlphabet.get(c);
        for (char ch : chars) {
            dfs(number, i + 1, seq + ch);
        }
    }
}
