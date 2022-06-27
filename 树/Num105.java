package 树;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 */
public class Num105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    private TreeNode doBuildTree(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin > preEnd || inBegin > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preBegin]);
        int mid = 0;
        for (int i = inBegin; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                mid = i;
                break;
            }
        }
        root.left = doBuildTree(preorder, preBegin + 1, preBegin + (mid - inBegin), inorder, inBegin, mid - 1);
        root.right = doBuildTree(preorder, preBegin + (mid - inBegin) + 1, preEnd, inorder, mid + 1, inEnd);
        return root;
    }
}
