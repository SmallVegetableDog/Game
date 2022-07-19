package 并查集unionFind;

public class Num1319 {

    public static void main(String[] args) {
        Num1319 num1319 = new Num1319();
        int[][] conn = {{1, 5}, {1, 7}, {1, 2}, {1, 4}, {3, 7}, {4, 7}, {3, 5}, {0, 6}, {0, 1}, {0, 4}, {2, 6}, {0, 3}, {0, 2}};
        System.out.println(num1319.makeConnected(12, conn));
    }

    int repeatUnionCount;

    public int makeConnected(int n, int[][] connections) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] conn : connections) {
            boolean repeatUnion = unionFind.union(conn[0], conn[1]);
            if (repeatUnion) {
                repeatUnionCount++;
            }
        }
        if (repeatUnionCount >= unionFind.count - 1) {
            return unionFind.count - 1;
        }
        return -1;
    }


    class UnionFind {
        int[] parent;

        int count;

        int[] size;

        UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public boolean union(int i, int j) {
            int parentI = find(i);
            int parentJ = find(j);
            if (parentI == parentJ) {
                return true;
            }
            if (size[parentI] > size[parentJ]) {
                parent[parentJ] = parentI;
                size[parentI] += size[parentJ];
            } else {
                parent[parentI] = parentJ;
                size[parentJ] += size[parentI];
            }
            count--;
            return false;
        }

        public int find(int i) {
            while (parent[i] != i) {
                i = parent[parent[i]];
            }
            return parent[i];
        }
    }
}
