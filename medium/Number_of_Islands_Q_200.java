class Number_of_Islands_Q_200 {
    
    int m, n;
    public int numIslands(char[][] grid) {
        
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '0') continue;
                if (visited[i][j] == true) continue;
                dfs(grid, i, j, visited);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, boolean[][] visited){
        
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j] == '0') return;
        if (visited[i][j] == true) return;
        visited[i][j] = true;
        dfs(grid, i, j+1, visited);
        dfs(grid, i, j-1, visited);
        dfs(grid, i-1, j, visited);
        dfs(grid, i+1, j, visited);
    }
}
