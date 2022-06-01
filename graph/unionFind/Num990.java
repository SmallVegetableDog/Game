package graph.unionFind;

/**
 * 990. 等式方程的可满足性
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * <p>
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * 示例 2：
 * <p>
 * 输入：["b==a","a==b"]
 * 输出：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * 示例 3：
 * <p>
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] 和 equations[i][3] 是小写字母
 * equations[i][1] 要么是 '='，要么是 '!'
 * equations[i][2] 是 '='
 */
public class Num990 {

    public static void main(String[] args) {
        Num990 num990 = new Num990();
        System.out.println(num990.equationsPossible(new String[]{"a==b", "b!=a"}));

    }

    //节点x的父节点是parent[x]
    int[] parent;

    //size[x]表示以节点x作为根节点算，共有几个节点。用来保持树的平衡，加快搜寻速度
    int[] size;

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        size = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String equ : equations) {
            if (equ.charAt(1) == '=') {
                union(equ.charAt(0) - 'a', equ.charAt(3) - 'a');
            }
        }
        for (String equ : equations) {
            if (equ.charAt(1) == '!') {
                if (connected(equ.charAt(0) - 'a', equ.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        int pSize = size[rootP];
        int qSize = size[rootQ];
        //保持树的平衡，让较小的树连接到较大的树上
        if (pSize < qSize) {
            parent[rootP] = rootQ;
            size[rootQ] = size[rootQ] + pSize;
        } else {
            parent[rootQ] = rootP;
            size[rootP] = size[rootP] + qSize;
        }
    }

    /* 判断 p 和 q 是否连通 */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return true;
        }
        return false;
    }

    /*找到p节点的根节点*/
    private int find(int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }
}
