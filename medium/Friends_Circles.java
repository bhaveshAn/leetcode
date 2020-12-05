class Friends_Circles {
    public int findCircleNum(int[][] M) {
        
        int[] visited = new int[M.length];
        int res = 0;
        for (int i = 0; i < M.length; i++){
            if (visited[i] == 0) {
                dfs(M, i, visited);
                res++;
            }
        }
        return res;
    }
    
    private void dfs(int[][] M, int i, int[] visited){
        
        for (int j = 0; j < M.length; j++){
            if (M[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(M, j, visited);
            }
        }
    }
}
