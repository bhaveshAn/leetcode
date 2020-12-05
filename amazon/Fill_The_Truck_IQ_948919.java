// "static void main" must be defined in a public class.
public class Fill_The_Truck_IQ_948919 {
    
    private static int fillTheTruck(int truckSize, int[] boxes, int[] unitsPerBox){
        
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);
        for (int i = 0; i < boxes.length; i++){
             for (int j = 0; j < boxes[i]; j++){
                 queue.offer(unitsPerBox[i]);
             }
        }
        int res = 0;
        for (int i = 0; i < truckSize; i++){
            res += queue.poll();
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(fillTheTruck(3, new int[]{1,2,3}, new int[]{3,2,1}));
    }
}
