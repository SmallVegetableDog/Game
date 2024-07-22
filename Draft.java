import 树.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Draft {

    public static void main(String[] args) {

    }

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return -10001;
        }
        int sum1 = traverse(root.left);
        int sum2 = traverse(root.right);
        int max = this.max(sum1, sum2, root.val, sum1 + root.val, sum2 + root.val, sum1 + sum2 + root.val);
        maxSum = this.max(maxSum, max);
        return this.max(sum1 + root.val, sum2 + root.val, root.val);
    }

    int max(int... num) {
        if (num.length == 0) {
            return 0;
        }
        int max = num[0];
        for (int n : num) {
            max = Math.max(n, max);
        }
        return max;
    }

}
