// "static void main" must be defined in a public class.
public class Min_Amplitude_&_Ways_to_Split_String_IQ_553399 {
    
    private static int minAmplitude(int[] nums){
        
        Arrays.sort(nums);
        int n = nums.length;
        if (n <= 3) return 0;
        int ans = nums[n-1] - nums[0];
        for (int i = 0, j = n - 4; j < n; j++, i++){
            ans = Math.min(ans, nums[j] - nums[i]);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        
        System.out.println(minAmplitude(new int[]{-1, 3, -1, 8, 5, 4}));
    }
}
