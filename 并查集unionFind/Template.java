package 并查集unionFind;

/**
 * 并查集算法模板
 */
public class Template {

    public static void main(String[] args) {
        Template template = new Template(10);
        template.union(1, 2);
        template.union(1, 3);
        template.union(2, 5);
        System.out.println(template.connected(2, 3));
        System.out.println(template.connected(1, 5));
        System.out.println(template.connected(2, 6));
        System.out.println(template.count());
    }

    //记录连通分量
    int count;

    //节点x的父节点是parent[x]
    int[] parent;

    //size[x]表示以节点x作为根节点算，共有几个节点。用来保持树的平衡，加快搜寻速度
    int[] size;

    public Template(int num) {
        count = num;
        parent = new int[num + 1];
        size = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /* 将 p 和 q 连接 */
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
        //两个分量合并成一个，总连通分量减一
        count--;
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

    /* 返回图中有多少个连通分量 */
    public int count() {
        return count;
    }
}
