// "static void main" must be defined in a public class.
public class Items_in_Containers_IQ_865660 {
    
    private static int[] numberOfItems(String s, int[] startIndices, int[] endIndices){
        
        if (startIndices.length != endIndices.length) return new int[0];
        int m = startIndices.length;
        int[] ans = new int[m];
        int j = 0;
        for (int i = 0 ; i < m; i++){
            int curr = 0, max = 0;
            boolean start = false;
            boolean end = false;
            for (char ch : s.substring(startIndices[i] - 1, endIndices[i]).toCharArray()){
                if (ch == '|' && max < curr) max = curr;
                else if (ch == '*') curr += 1;
            }
            ans[j] = max;
            j++;
        }
        return ans;
        
    }
    public static void main(String[] args) {
        int[] ans = numberOfItems("|**|*|*", new int[]{1, 1}, new int[]{5, 6});
        for (int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
