public class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int sr = entrance[0], sc = entrance[1];

        // Directions: right, down, left, up
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        // Queue for BFS: store row, col
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        // Mark entrance visited so we don't count it as an exit or revisit it
        maze[sr][sc] = '+';

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            // process all nodes at current distance
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];

                
                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];

                    // skip out of bounds or walls/visited
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if (maze[nr][nc] == '+') continue;

                
                    if (nr == 0 || nr == m - 1 || nc == 0 || nc == n - 1) {
                        return steps + 1; // next step reaches the exit
                    }

                    maze[nr][nc] = '+';
                    q.offer(new int[]{nr, nc});
                }
            }
            steps++;
        }

        return -1;
    }
}