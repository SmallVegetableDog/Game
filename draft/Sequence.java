package draft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Sequence {

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        List<String> sequence1 = sequence.getSequence("23");
        System.out.println(sequence1);
    }

    private List<String> sequenceList;

    private Map<Integer, char[]> numToAlphabet;

    public List<String> getSequence(String number) {
        sequenceList = new ArrayList<>();
        numToAlphabet = new HashMap<>();
        numToAlphabet.put(2, new char[]{'a', 'b', 'c'});
        numToAlphabet.put(3, new char[]{'d', 'e', 'f'});
        dfs(number, 0, "");
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

























