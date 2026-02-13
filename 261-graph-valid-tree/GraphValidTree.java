import java.util.*;

public class GraphValidTree {
    // TC-O(N.alpha(N)), where alpha is the Inverse Ackermann function.
    // In practical terms, this is constant time.
    // SC-O(N) to store the parent array
    // Graph Valid Tree is Graph without cycle and all vertices should be connected
    // Create parent disjoint and have components as n
    // for each edge, merge them and reduce component, return component
    // BFS, DFS both have TC-O(V+E) and SC-O(V)
    public boolean isValidTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            // If less than n-1, not connected
            // If greater than n-1, cycle
            return false;
        }
        int[] parent = new int[n];// store each num's root
        for (int i = 0; i < n; i++) {
            parent[i] = i;// set root as themselves
        }
        for (int[] edge : edges) {
            int rootA = findRoot(parent, edge[0]);
            int rootB = findRoot(parent, edge[1]);
            if (rootA == rootB) {// cycle
                return false;
            } else {// if not same root
                parent[rootA] = rootB;// merge them to same set
            }
        }
        return true;
    }

    private int findRoot(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = findRoot(parent, parent[node]);
        // if parent of 3 is 2, findRoot of 2 and set that root to 3 also
        // It's path compression, so that no need to traverse everytime to root
        return parent[node];
    }

    public static void main(String[] args) {
        GraphValidTree sol = new GraphValidTree();

        // LeetCode Case 1: Valid Tree
        // 0-1, 0-2, 0-3, 1-4
        int n1 = 5;
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        System.out.println("Test Case 1 (Expected true): " + sol.isValidTree(n1, edges1));

        // LeetCode Case 2: Invalid Tree (Contains Cycle)
        // 0-1, 1-2, 2-3, 1-3, 1-4
        int n2 = 5;
        int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
        System.out.println("Test Case 2 (Expected false): " + sol.isValidTree(n2, edges2));

        // Case 3: Disconnected
        // 0-1, 2-3 (Node 4 is isolated)
        int n3 = 5;
        int[][] edges3 = { { 0, 1 }, { 2, 3 } };
        System.out.println("Test Case 3 (Expected false): " + sol.isValidTree(n3, edges3));

        // Case 4: Single node (A tree with 1 node has 0 edges)
        int n4 = 1;
        int[][] edges4 = {};
        System.out.println("Test Case 4 (Expected true): " + sol.isValidTree(n4, edges4));
    }
}
