package 树;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 */
public class Num236 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode.right = treeNode2;
        Num236 num236 = new Num236();
        num236.lowestCommonAncestor(treeNode, treeNode, treeNode2);
    }

    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        doIt(root, p, q);
        return res;
    }

    private int[] doIt(TreeNode root, TreeNode p, TreeNode q) {
        if (res != null) {
            return new int[]{0, 0};
        }
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = doIt(root.left, p, q);
        if (res != null) {
            return new int[]{0, 0};
        }
        int[] right = doIt(root.right, p, q);
        if (res != null) {
            return new int[]{0, 0};
        }
        int[] res = new int[2];
        res[0] = left[0];
        res[1] = left[1];
        if (right[0] == 1) {
            res[0] = 1;
        }
        if (right[1] == 1) {
            res[1] = 1;
        }
        if (root == p) {
            res[0] = 1;
        } else if (root == q) {
            res[1] = 1;
        }
        if (res[0] == 1 && res[1] == 1) {
            this.res = root;
        }
        return res;
    }
}
