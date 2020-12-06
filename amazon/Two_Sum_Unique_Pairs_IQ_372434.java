// "static void main" must be defined in a public class.
public class Two_Sum_Unique_Pairs_IQ_372434 {
    
    private static int twoSumUniquePairs(int sum, int[] nums){
        
        int res = 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        for (int num : nums){
            if (set.contains(num)){
                if (!seen.contains(num)){
                    res++;
                    seen.add(num);
                } 
            } else{
                set.add(sum - num);
            }
        }
        
        return res;        
    }
    public static void main(String[] args) {
        System.out.println(twoSumUniquePairs(47, new int[]{1, 1, 2, 45, 46, 46}));
        System.out.println(twoSumUniquePairs(2, new int[]{1, 1}));
        System.out.println(twoSumUniquePairs(6, new int[]{1, 5, 1, 5}));
    }
}
