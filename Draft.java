import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Draft {

    public static void main(String[] args) {
        Draft draft = new Draft();
        String result = draft.minWindow("ab", "b");
        System.out.println(result);
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        String result = "";
        int l = 0, r = 0, valid = 0;
        char[] sourceArray = s.toCharArray();
        Map<Character, Integer> windowMap = new HashMap<>();
        while (r < s.length()) {
            char c = sourceArray[r];
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            if (windowMap.get(c).equals(targetMap.get(c))) {
                valid++;
            }
            r++;
            while (valid == targetMap.size()) {
                if (result.length() == 0 || r - l < result.length()) {
                    result = s.substring(l, r);
                }
                if (windowMap.get(sourceArray[l]).equals(targetMap.get(sourceArray[l]))) {
                    valid--;
                }
                windowMap.put(sourceArray[l], windowMap.get(sourceArray[l]) - 1);
                l++;
            }
        }
        return result;
    }


}
