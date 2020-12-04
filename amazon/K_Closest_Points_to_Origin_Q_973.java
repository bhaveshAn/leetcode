class K_Closest_Points_to_Origin_Q_973 {
    
    public static class Pair{
        
        int index;
        int dist;
        
        public Pair(int index, int dist){
            
            this.dist = dist;
            this.index = index;
        }
    }
    
    public static class SortPair implements Comparator<Pair>{
        
        public int compare(Pair a, Pair b) {
            return a.dist - b.dist;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        
        int n = points.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++){
            pairs[i] = new Pair(i, getDist(points[i]));
        }
        Arrays.sort(pairs, new SortPair());
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++){
            ans[i] = points[pairs[i].index];
        }
        return ans;
    }
    
    private static int getDist(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
