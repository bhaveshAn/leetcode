// "static void main" must be defined in a public class.
public class Five_Star_Sellers_IQ_933383 {
    
    private static int getFiveStarSellers(int threshold, int[][] productRatings){
        
        int n = productRatings.length;
        double min = n * threshold / 100.0;
        double curr = 0.00;
        for(int i = 0; i < n; i++) {
            double a = productRatings[i][0];
            double b = productRatings[i][1];
            double rate = a / b;
            curr += rate;
        }
        int maxIndex = 0, res = 0;
        double maxDiff = Double.MIN_VALUE;
        while (curr < min){
            maxDiff = Double.MIN_VALUE;
            for (int i = 0; i <  n; i++){
                double a = productRatings[i][0];
                double b = productRatings[i][1];
                double diff = a / b;
                if (diff == 1) continue;
                a = productRatings[i][0] + 1;
                b = productRatings[i][1] + 1;
                diff = a / b - diff;
                if (diff > maxDiff){
                    maxDiff = diff;
                    maxIndex = i;
                }
            }
            curr += maxDiff;
            productRatings[maxIndex][0] = productRatings[maxIndex][0] + 1;
            productRatings[maxIndex][1] = productRatings[maxIndex][1] + 1;
            res += 1;
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(getFiveStarSellers(77, new int[][]{new int[]{4,4}, new int[]{1,2}, new int[]{3, 6}}));
    }
}
