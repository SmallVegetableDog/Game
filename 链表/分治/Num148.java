package 链表.分治;

import 双指针.ListNode;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 */
public class Num148 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Num148 num148 = new Num148();
        ListNode listNode = num148.sortList(node1);
        System.out.println();
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        return doSortList(head);
    }

    private ListNode doSortList(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode front = node, end = node.next;
        while (end.next != null) {
            end = end.next;
            front = front.next;
            if (end.next == null) {
                break;
            }
            end = end.next;
        }
        ListNode node1 = doSortList(front.next);
        front.next = null;
        ListNode node2 = doSortList(node);
        ListNode head = null, p = null;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                p.next = node2;
                node2 = null;
            } else if (node2 == null) {
                p.next = node1;
                node1 = null;
            } else if (node1.val <= node2.val) {
                if (p == null) {
                    p = node1;
                    head = node1;
                } else {
                    p.next = node1;
                    p = p.next;
                }
                node1 = node1.next;
            } else {
                if (p == null) {
                    p = node2;
                    head = node2;
                } else {
                    p.next = node2;
                    p = p.next;
                }
                node2 = node2.next;
            }
        }
        return head;
    }
}
