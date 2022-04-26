package bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：无法旋转到目标数字且不被锁定。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num752 {

    public static void main(String[] args) {
        Num752 num752 = new Num752();
        System.out.println(num752.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        //System.out.println(num752.openLock(new String[]{"8888"}, "0009"));

    }

    private Set<String> visited = new HashSet<>();

    private Set<String> q1 = new HashSet<>();
    private Set<String> q2 = new HashSet<>();

    private int count;

    private List<String> deadendList;

    public int openLock(String[] deadends, String target) {
        q1.add("0000");
        q2.add(target);
        deadendList = Arrays.asList(deadends);
        if (target.equals("0000")) {
            return 0;
        }
        if (deadendList.contains("0000")) {
            return -1;
        }
        return bfs() ? count + 1 : -1;
    }

    private boolean bfs() {
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String nums : q1) {
                if (q2.contains(nums)) {
                    return true;
                }
                char[] numsChar = nums.toCharArray();
                for (int j = 0; j < numsChar.length; j++) {
                    char c = numsChar[j];
                    if (c == '0') {
                        char[] clone = numsChar.clone();
                        clone[j] = '1';
                        if (addQueue(clone, temp))
                            return true;

                        char[] clone2 = numsChar.clone();
                        clone2[j] = '9';
                        if (addQueue(clone2, temp))
                            return true;
                    } else if (c == '9') {
                        char[] clone = numsChar.clone();
                        clone[j] = '0';
                        if (addQueue(clone, temp))
                            return true;

                        char[] clone2 = numsChar.clone();
                        clone2[j] = '8';
                        if (addQueue(clone2, temp))
                            return true;
                    } else {
                        char[] clone = numsChar.clone();
                        clone[j] = (char) (numsChar[j] + 1);
                        if (addQueue(clone, temp))
                            return true;

                        char[] clone2 = numsChar.clone();
                        clone2[j] = (char) (numsChar[j] - 1);
                        if (addQueue(clone2, temp))
                            return true;
                    }
                }
            }
            count++;
            q1 = q2;
            q2 = temp;
        }
        return false;
    }

    boolean addQueue(char[] nums, Set<String> temp) {
        String s = new String(nums);
        if (deadendList.contains(s)) {
            return false;
        }
        if (q2.contains(s)) {
            return true;
        }
        if (!visited.add(s)) {
            return false;
        }
        temp.add(s);
        return false;
    }
}
