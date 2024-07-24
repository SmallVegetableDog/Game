import 树.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Draft {

    public static void main(String[] args) {

    }

    int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuildTree(preorder, inorder, 0, inorder.length - 1);

    }

    private TreeNode doBuildTree(int[] preorder, int[] inorder, int i, int j) {
        if (i > j) {
            return null;
        }
        int rootVal = preorder[preIdx++];
        int k = i;
        while (k <= j && rootVal != inorder[k++]) ;

        TreeNode root = new TreeNode(rootVal);
        root.left = doBuildTree(preorder, inorder, i, k - 1);
        root.right = doBuildTree(preorder, inorder, k + 1, j);
        return root;
    }

}
