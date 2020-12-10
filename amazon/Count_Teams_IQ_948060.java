// "static void main" must be defined in a public class.
public class Count_Teams_IQ_948060 {
    
    private static int countTeams(int num, int[] skills, int minAssociates, int minLevel, int maxLevel){
        
        int count = 0;
        for (int skill : skills){
            if (skill >= minLevel && skill <= maxLevel){
                count++;
            }
        }
        int[] factorial = new int[count + 1];
        factorial[0] = 1;
        for (int i = 1; i < factorial.length; i++){
            factorial[i] = factorial[i-1] * i;
        }
        int total = 0;
        for (int i = minAssociates; i <= count; i++) {
            total += factorial[count] / factorial[i] * factorial[count - i];
            }
        return total;
    }
    
    public static void main(String[] args) {
        
        System.out.println(countTeams(6, new int[]{12, 4, 6, 13, 5, 10}, 3, 4, 10));
    }
}
