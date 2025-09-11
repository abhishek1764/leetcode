class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        if (m == 0) return -1;
        int n = grid[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        
        // Initialize queue with all rotten oranges and count fresh
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }
        
        if (fresh == 0) return 0; // no fresh oranges to rot
        
        int minutes = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!q.isEmpty()) {
            int sz = q.size();
            boolean rottedThisMinute = false;
            
            for (int k = 0; k < sz; k++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                
                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;      // now rotten
                        fresh--;
                        q.add(new int[]{nr, nc});
                        rottedThisMinute = true;
                    }
                }
            }
            
            if (rottedThisMinute) minutes++;
        }
        
        return (fresh == 0) ? minutes : -1;
    }
}