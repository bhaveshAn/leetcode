// "static void main" must be defined in a public class.
public class Autoscale_Policy_IQ_376019 {
    
    private static int getInstances(int instances, int[] utilization){
        
        int i = 0, n = utilization.length;
        while (i < n){
            if (utilization[i] < 25 && instances > 1){
                instances = (int) Math.ceil(instances / 2);
                i += 10;
                continue;
            } else if (utilization[i] > 60 && (2 * instances < 2 * Math.pow(10, 8))){
                instances *= 2;
                i += 10;
                continue;
            }
            i++;
        }
        return instances;
    }
    
    public static void main(String[] args) {
        
        int instances = 1;
        System.out.println(getInstances(instances, new int[]{5, 10, 80}));
    }
}
