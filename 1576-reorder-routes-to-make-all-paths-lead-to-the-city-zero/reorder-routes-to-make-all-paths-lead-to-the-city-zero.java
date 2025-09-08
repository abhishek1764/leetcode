class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph with direction markers
        for (int[] conn : connections) {
            int u = conn[0], v = conn[1];
            graph.get(u).add(new int[]{v, 1}); // original edge u -> v
            graph.get(v).add(new int[]{u, 0}); // reverse edge v -> u (no reversal needed)
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 0;

        for (int[] neighbor : graph.get(node)) {
            int next = neighbor[0];
            int needsReverse = neighbor[1];

            if (!visited[next]) {
                count += needsReverse;
                count += dfs(next, graph, visited);
            }
        }
        return count;
    }
}