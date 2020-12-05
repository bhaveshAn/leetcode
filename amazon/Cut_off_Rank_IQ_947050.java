// "static void main" must be defined in a public class.
public class Cut_off_Rank_IQ_947050 {
    
    private static int getNoOfPlayers(int cutOff, int[] scores){
        
        int[] freq = new int[100001];
        int max = Integer.MIN_VALUE;
        for (int score : scores){
            freq[score]++;
            if (max < score) max = score;
        }
        
        int i = max, res = 0, rank = 1;
        while (i >=0 && rank <= cutOff){
            if (freq[i] != 0){
                res += freq[i];
                rank += freq[i];
            }
            i--;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(getNoOfPlayers(3, new int[]{100, 50, 50, 25}));
    }
}
