// "static void main" must be defined in a public class.
public class Find_The_Highest_Profit_IQ_868302 {
    
    private static int getMaxProfit(int numSuppliers, int[] inventory, int order){
        
        int maxInventory = 0;
        for (int i : inventory){
            maxInventory = Math.max(maxInventory, i);
        }
        
        int[] inventoryArr = new int[maxInventory + 1];
        for (int i : inventory){
            inventoryArr[i]++;
        }
        int profit = 0;
        for (int i = maxInventory; i > 0 && order > 0; i--){
            
            profit += order > inventoryArr[i] ? inventoryArr[i] * i : order * i;
            inventoryArr[i-1] += inventoryArr[i];
            order -= inventoryArr[i];
        }
        return profit;
    }
    
    public static void main(String[] args) {
        
        System.out.println(getMaxProfit(2, new int[]{3, 5}, 6));
    }
}
