package matches.no301;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * 6113. 无限集中的最小数字 显示英文描述
 * 通过的用户数2436
 * 尝试过的用户数2632
 * 用户总通过次数2445
 * 用户总提交次数3144
 * 题目难度Medium
 * 现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...] 。
 * <p>
 * 实现 SmallestInfiniteSet 类：
 * <p>
 * SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
 * int popSmallest() 移除 并返回该无限集中的最小整数。
 * void addBack(int num) 如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集中。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest", "popSmallest", "popSmallest"]
 * [[], [2], [], [], [], [1], [], [], []]
 * 输出
 * [null, null, 1, 2, 3, null, 1, 4, 5]
 * <p>
 * 解释
 * SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
 * smallestInfiniteSet.addBack(2);    // 2 已经在集合中，所以不做任何变更。
 * smallestInfiniteSet.popSmallest(); // 返回 1 ，因为 1 是最小的整数，并将其从集合中移除。
 * smallestInfiniteSet.popSmallest(); // 返回 2 ，并将其从集合中移除。
 * smallestInfiniteSet.popSmallest(); // 返回 3 ，并将其从集合中移除。
 * smallestInfiniteSet.addBack(1);    // 将 1 添加到该集合中。
 * smallestInfiniteSet.popSmallest(); // 返回 1 ，因为 1 在上一步中被添加到集合中，
 * // 且 1 是最小的整数，并将其从集合中移除。
 * smallestInfiniteSet.popSmallest(); // 返回 4 ，并将其从集合中移除。
 * smallestInfiniteSet.popSmallest(); // 返回 5 ，并将其从集合中移除。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 1000
 * 最多调用 popSmallest 和 addBack 方法 共计 1000 次
 */
class SmallestInfiniteSet {

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.popSmallest();
        smallestInfiniteSet.addBack(1);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(2);
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(187);
        smallestInfiniteSet.addBack(414);
        smallestInfiniteSet.addBack(3);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
    }

    Node minNode;

    HashSet<Integer> removeSet;

    public SmallestInfiniteSet() {
        minNode = new Node(1);
        removeSet = new HashSet<>();
    }

    public int popSmallest() {
        Integer min = minNode.val;
        if (minNode.next == null) {
            minNode = new Node(min + 1);
        } else {
            minNode = minNode.next;
        }
        removeSet.add(min);
        return min;
    }

    public void addBack(int num) {
        if (!removeSet.contains(num)) {
            return;
        }
        Node temp = minNode;
        while (temp != null) {
            if (temp.val < num) {
                temp = temp.next;
            } else {
                break;
            }
        }
        Node node = new Node(num);
        if (temp == minNode) {
            node.next = minNode;
            minNode.pre = node;
            minNode = node;
        } else {
            node.pre = temp.pre;
            node.next = temp;
            temp.pre.next = node;
            temp.pre = node;
        }
        removeSet.remove(num);
    }

    class Node {
        int val;

        Node pre;

        Node next;

        Node(int val) {
            this.val = val;
        }
    }

}
