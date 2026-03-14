class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //Only Path Compression
        //TC-O(N.logN) and SC-O(N), logN for finding parent, in some cases, it will be N
        //Ip will be cycle, so edges length is nodes length, return which edge will form cycle
        // int n = edges.length;
        // int[] parent = new int[n + 1];
        // for (int i = 1; i <= n; i++) {
        //     parent[i] = i;
        // }
        // for (int[] edge : edges) {
        //     int rootA = find(edge[0], parent);//find
        //     int rootB = find(edge[1], parent);
        //     if (rootA == rootB) {
        //         return edge;
        //     }
        //     parent[rootA] = rootB;//union
        // }
        // return new int[0];

        //Rank and Path Compression
        //TC-O(N.alpha(N)) and SC-O(N), alpha(N) for rank & finding parent, very little value like O(1)
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;//rank/height will be 1
        }
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1], parent, rank)) {
                return edge;//if false, cycle detected and return edge
            }
        }
        return new int[0];
    }

    private boolean union(int nodeA, int nodeB, int[] parent, int[] rank) {
        int rootA = find(nodeA, parent);//find
        int rootB = find(nodeB, parent);
        if (rootA == rootB) {
            return false;
        }
        if (rank[rootA] > rank[rootB]) {//merge node which is small to bigger one to maintain rank
            parent[rootB] = rootA;
        } else if (rank[rootB] > rank[rootA]) {
            parent[rootA] = rootB;
        } else {//if both nodes same rank
            parent[rootA] = rootB;//union
            rank[rootB]++;//only here update rank, as first, rank will be same
        }
        return true;
    }

    private int find(int node, int[] parent) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node], parent);//path compression
    }
}