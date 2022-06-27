package 树;

/**
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 */
public class Num114 {

    public void flatten(TreeNode root) {
        doFlatten(root);
    }

    //TreeNode[该子树的根节点，该子树的最后节点]
    private TreeNode[] doFlatten(TreeNode root) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        TreeNode[] left = doFlatten(root.left);
        TreeNode[] right = doFlatten(root.right);
        if (left[1] != null) {
            left[1].right = right[0];
            root.right = left[0];
            root.left = null;
        } else {
            root.right = right[0];
        }
        TreeNode last = null;
        if (right[1] != null) {
            last = right[1];
        } else if (left[1] != null) {
            last = left[1];
        } else {
            last = root;
        }
        return new TreeNode[]{root, last};
    }
}
