// "static void main" must be defined in a public class.
public class Transaction_Logs_IQ_862600 {
    
    private static List<String> getUsers(int k, String[] transactions){
        
        Map<String, Integer> count = new HashMap<>();
        
        for (String line : transactions){
            String[] split = line.split(" ");
            if (split[0] == split[1]){
                count.put(split[0], count.getOrDefault(split[0], 0) + 1);
            } else {
                count.put(split[0], count.getOrDefault(split[0], 0) + 1);
                count.put(split[1], count.getOrDefault(split[1], 0) + 1);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for (String user : count.keySet()){
            if (count.get(user) >= k){
                ans.add(user);
            }
        }
        ans.sort((a, b) -> {
            return a.compareTo(b);
        });
        return ans;
    }
    public static void main(String[] args) {
        
        String[] transactions = new String[]{
            "345366 89921 45", "029323 38239 23", "38239 345366 15",
            "029323 38239 77", "345366 38239 23", "029323 345366 13",
            "38239 38239 23"};
        List<String> ans = getUsers(3, transactions);
        ans.forEach(x -> {
           System.out.print(x + " "); 
        });
    }
}
