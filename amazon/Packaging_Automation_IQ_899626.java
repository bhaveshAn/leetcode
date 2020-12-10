// "static void main" must be defined in a public class.
public class Packaging_Automation_IQ_899626 {
    
    private static int lastPakaging(int numGroups, int[] arr){
        
        int i = 1;
        arr[0] = 1;
        while (i < numGroups){
            if (arr[i] > arr[i-1] + 1){
                arr[i] = arr[i-1] + 1;
            }
            i++;
        }
        return arr[numGroups-1];
    }
    
    public static void main(String[] args) {
        
        System.out.println(lastPakaging(4, new int[]{1,3,2,2}));
        System.out.println(lastPakaging(4, new int[]{3,2,3,5}));
        System.out.println(lastPakaging(4, new int[]{1,1,1,5}));
    }
}
