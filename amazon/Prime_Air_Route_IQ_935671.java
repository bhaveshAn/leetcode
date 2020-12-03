public class Prime_Air_Route_IQ_935671 {
    
    private static List<List<Integer>> getOptimizedUtilize(int maxTravelDist, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList){
        
        int diff = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        
        for (List<Integer> forward : forwardRouteList){
            for (List<Integer> backward : returnRouteList){
                int sum = forward.get(1) + backward.get(1);
                if (sum > maxTravelDist) continue;
                if (diff == (maxTravelDist - sum)){
                    ans.add(Arrays.asList(forward.get(0), backward.get(0)));
                } else if (diff > (maxTravelDist - sum)){
                    diff = maxTravelDist - sum;
                    ans = new ArrayList<>();
                    ans.add(Arrays.asList(forward.get(0), backward.get(0)));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
        List<List<Integer>> forwardRouteListTC1 = new ArrayList<>();
        forwardRouteListTC1.add(Arrays.asList(1, 2000));
        forwardRouteListTC1.add(Arrays.asList(2, 4000));
        forwardRouteListTC1.add(Arrays.asList(3, 6000));
        
        List<List<Integer>> returnRouteListTC1 = new ArrayList<>();
        returnRouteListTC1.add(Arrays.asList(1, 2000));
        
        List<List<Integer>> ans = getOptimizedUtilize(7000, forwardRouteListTC1, returnRouteListTC1);
        ans.forEach(x -> {
            System.out.println(x.get(0) + " " + x.get(1));
        });
    }
}
