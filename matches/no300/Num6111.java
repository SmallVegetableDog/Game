package matches.no300;

import 双指针.ListNode;

/**
 * 6111. 螺旋矩阵 IV 显示英文描述
 * 通过的用户数67
 * 尝试过的用户数82
 * 用户总通过次数67
 * 用户总提交次数87
 * 题目难度Medium
 * 给你两个整数：m 和 n ，表示矩阵的维数。
 * <p>
 * 另给你一个整数链表的头节点 head 。
 * <p>
 * 请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。如果还存在剩余的空格，则用 -1 填充。
 * <p>
 * 返回生成的矩阵。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
 * 输出：[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
 * 解释：上图展示了链表中的整数在矩阵中是如何排布的。
 * 注意，矩阵中剩下的空格用 -1 填充。
 * 示例 2：
 * <p>
 * <p>
 * 输入：m = 1, n = 4, head = [0,1,2]
 * 输出：[[0,1,2,-1]]
 * 解释：上图展示了链表中的整数在矩阵中是如何从左到右排布的。
 * 注意，矩阵中剩下的空格用 -1 填充。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 链表中节点数目在范围 [1, m * n] 内
 * 0 <= Node.val <= 1000
 */
public class Num6111 {

    public static void main(String[] args) {
        Num6111 num6111 = new Num6111();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(8);
        ListNode node6 = new ListNode(1);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(4);
        ListNode node10 = new ListNode(2);
        ListNode node11 = new ListNode(5);
        ListNode node12 = new ListNode(5);
        ListNode node13 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        num6111.spiralMatrix(3, 5, node1);
    }


    ListNode head;

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        this.head = head;
        doSpirealMatrix(m - 1, n - 1, res, 0, 0);
        return res;
    }

    private void doSpirealMatrix(int m, int n, int[][] res, int i, int j) {
        int ii = i;
        int jj = j;
        if (m < 0 || n < 0) {
            return;
        }
        for (; j <= n; j++) {
            res[i][j] = getVal();
        }
        j--;
        if (i + 1 > m) {
            return;
        }
        for (i = i + 1; i <= m; i++) {
            res[i][j] = getVal();
        }
        i--;
        if (j - 1 < jj) {
            return;
        }
        for (j = j - 1; j >= jj; j--) {
            res[i][j] = getVal();
        }
        j++;
        if (i - 1 <= ii) {
            return;
        }
        for (i = i - 1; i > ii; i--) {
            res[i][j] = getVal();
        }
        doSpirealMatrix(m - 1, n - 1, res, ii + 1, jj + 1);
    }

    int getVal() {
        if (head == null) {
            return -1;
        }
        int val = head.val;
        head = head.next;
        return val;
    }
}
