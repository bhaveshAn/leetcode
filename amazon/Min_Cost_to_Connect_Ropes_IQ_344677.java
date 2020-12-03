// "static void main" must be defined in a public class.
public class Min_Cost_to_Connect_Ropes_IQ_344677 {
    
    
    private static int minCost(List<Integer> list){
        
        int minCost = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(list);
        while (queue.size() > 1){
            int sum = queue.poll() + queue.poll();
            queue.offer(sum);
            minCost += sum;
        }
        return minCost;
    }
    public static void main(String[] args) {
        
        System.out.println(minCost(Arrays.asList(8, 4, 6, 12)));
        
    }
}
