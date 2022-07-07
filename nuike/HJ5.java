package nuike;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * <p>
 * 数据范围：保证结果在 1 \le n \le 2^{31}-1 \1≤n≤2
 * 31
 * −1
 * 输入描述：
 * 输入一个十六进制的数值字符串。
 * <p>
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 * <p>
 * 示例1
 * 输入：
 * 0xAA
 * 复制
 * 输出：
 * 170
 */
public class HJ5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next().substring(2);
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('A', 10);
            map.put('B', 11);
            map.put('C', 12);
            map.put('D', 13);
            map.put('E', 14);
            map.put('F', 15);
            int res = 0;
            for (int i = str.length() - 1, pos = 1; i >= 0; i--, pos = pos * 16) {
                int num;
                if (map.containsKey(str.charAt(i))) {
                    num = map.get(str.charAt(i));
                } else {
                    num = str.charAt(i) - '0';
                }
                res = res + num * pos;
            }
            System.out.println(res);
        }
    }
}
