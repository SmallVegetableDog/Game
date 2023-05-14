package 树;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 */
public class Num230 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4));
        treeNode.right = new TreeNode(6);
        System.out.println(new Num230().kthSmallest(treeNode, 7));
    }

    int k = 0;

    int val = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        doFindK(root);
        return val;
    }

    private void doFindK(TreeNode root) {
        if (root == null) {
            return;
        }
        if (k < 0) {
            return;
        }
        doFindK(root.left);

        int val = root.val;
        k--;
        if (k == 0) {
            this.val = val;
        }
        doFindK(root.right);
    }

}
