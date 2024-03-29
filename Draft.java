import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Draft {

    public static void main(String[] args) {
        Draft draft = new Draft();
        List<Integer> anagrams = draft.findAnagrams("cbaebabacd", "abc");
        anagrams.forEach(System.out::println);
    }
    public List<Integer> findAnagrams(String s, String p) {

        char[] sToChars = s.toCharArray();
        char[] pToChars = p.toCharArray();
        int sLen = s.length();
        int pLen = p.length();
        Map<Character, Integer> charToNum = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (char ch : pToChars) {
            charToNum.put(ch, charToNum.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0, j = 0; j < sLen; ) {
            char ch = sToChars[j];
            if (!charToNum.containsKey(ch)) {
                j++;
                i = j;
                continue;
            }
            if (j - i == pLen-1) {
                HashMap<Character, Integer> map = new HashMap<>(charToNum);
                for (int ii = i, jj = j; ii <= jj; ii++) {
                    int preVal = map.put(sToChars[ii], map.get(sToChars[ii]) - 1);
                    if (preVal <= 0) {
                        i++;
                        j++;
                        break;
                    }
                    if (ii == jj) {
                        res.add(i);
                        j++;
                        i++;
                    }
                }
            }else {
                j++;
            }

        }
        return res;
    }

}
