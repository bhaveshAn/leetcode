// "static void main" must be defined in a public class.
public class Amaon_Fresh_Promotion_IQ_932920 {
    
    public static enum Fruit{
        apple, banana, orange, anything;
    }
    
    private static int isWinner(List<List<Fruit>> codeList, List<Fruit> shoppingCart){
        
        int i = 0, j = 0;
        int m = codeList.size();
        int n = codeList.get(m - 1).size();
        for (Fruit fruit : shoppingCart){
            int currN = codeList.get(i).size();
            if (fruit.equals(codeList.get(i).get(j)) || Fruit.anything.equals(codeList.get(i).get(j))){
                    if (j == (n - 1) && i == (m - 1)){
                        return 1;
                    } else if (j == (currN - 1)){
                        i++;
                        j = 0;
                    } else {
                        j++;
                    }
                }
            else {
                i = 0;
                j = 0;
            }
        }
        return (i == m && j == n) ? 1: 0;
    }
    public static void main(String[] args) {
        
        List<List<Fruit>> codeList1 = new ArrayList<>();
        codeList1.add(Arrays.asList(Fruit.apple, Fruit.apple));
        codeList1.add(Arrays.asList(Fruit.banana, Fruit.anything, Fruit.banana));
        
        List<Fruit> shoppingCart1 = Arrays.asList(Fruit.orange, Fruit.apple, Fruit.apple, Fruit.banana, Fruit.orange, Fruit.banana);
        
        System.out.println(isWinner(codeList1, shoppingCart1));
        
        
        // Case 2
        
        List<List<Fruit>> codeList2 = new ArrayList<>();
        codeList2.add(Arrays.asList(Fruit.apple, Fruit.apple));
        codeList2.add(Arrays.asList(Fruit.banana, Fruit.anything, Fruit.banana));
        
        List<Fruit> shoppingCart2 = Arrays.asList(Fruit.banana, Fruit.orange, Fruit.banana, Fruit.apple, Fruit.apple, Fruit.banana);
        
        System.out.println(isWinner(codeList2, shoppingCart2));
    }
}
