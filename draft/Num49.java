package draft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class Num49 {

    public static void main(String[] args) {
        Num49 num49 = new Num49();
        List<List<String>> lists = num49.groupAnagrams(new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"});
        System.out.println();
    }

        public List<List<String>> groupAnagrams (String[]strs){
            HashMap<Integer, List<String>> numToStrs = new HashMap<>();

            for (String str : strs) {
                int num = 0;
                for (char ch : str.toCharArray()) {
                    num = num + (ch - 'a' + 1) + 3000;
                }
                List<String> strList = numToStrs.getOrDefault(num, new ArrayList<>());
                strList.add(str);
                numToStrs.put(num, strList);
            }
            return new ArrayList<>(numToStrs.values());
        }
    }
