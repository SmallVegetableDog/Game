package draft;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300]
 */
public class Num394 {

    public static void main(String[] args) {
        Num394 num394 = new Num394();
        System.out.println(num394.decodeString("abc3[cd]xyz"));
    }

    String s;

    StringBuilder stringBuilder;

    int i = 0;

    public String decodeStringMaGua(String s) {
        this.s = s;
        stringBuilder = new StringBuilder();
        doDecodeString(0, 0);
        return stringBuilder.toString();
    }

    private String doDecodeString(int index, int num) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder subStr = new StringBuilder();
        for (i = index; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                stack.add(ch - '0');
            } else if (ch == '[') {
                int realNum = 0;
                int bit = 1;
                while (!stack.isEmpty()) {
                    realNum = stack.pop() * bit + realNum;
                    bit = bit * 10;
                }
                String res = doDecodeString(i + 1, realNum);
                if (num == 0) {
                    stringBuilder.append(res);
                } else {
                    subStr.append(res);
                }
            } else if (ch == ']') {
                String tempSubStr = subStr.toString();
                while (num-- > 1) {
                    subStr.append(tempSubStr);
                }
                return subStr.toString();
            } else {
                if (num == 0) {
                    stringBuilder.append(ch);
                } else {
                    subStr.append(ch);
                }
            }
        }
        return subStr.toString();
    }


    //官方递归解法
    String src;
    int ptr;

    public String decodeString(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    public String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            // String -> EPS
            return "";
        }

        char cur = src.charAt(ptr);
        int repTime = 1;
        String ret = "";

        if (Character.isDigit(cur)) {
            // String -> Digits [ String ] String
            // 解析 Digits
            repTime = getDigits();
            // 过滤左括号
            ++ptr;
            // 解析 String
            String str = getString();
            // 过滤右括号
            ++ptr;
            // 构造字符串
            while (repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            // String -> Char String
            // 解析 Char
            ret = String.valueOf(src.charAt(ptr++));
        }

        return ret + getString();
    }

    public int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';
        }
        return ret;
    }
}
