// "static void main" must be defined in a public class.
public class Top_K_Frequently_Mentioned_Keywords_IQ_542597 {
    
    private static List<String> getTopKFrequent(int k, String[] keywords, String[] reviews){
        
        Map<String, Integer> count = new HashMap<>();
        for (String key : keywords){
            count.put(key, 0);
        }
        
        for (String review : reviews){
            String[] splits = review.split(" ");
            Set<String> keys = new HashSet<>();
            for (String s : splits){
                if (count.containsKey(s) && !keys.contains(s)){
                    keys.add(s);
                    count.put(s, count.get(s) + 1);
                }
            }
        }
        List<String> ans = new ArrayList<>(count.keySet());
        Collections.sort(ans, (a, b)-> (count.get(a)).equals(count.get(b))?a.compareTo(b):count.get(b)-count.get(a));
        return ans.subList(0, k);
    }
    public static void main(String[] args) {
        
        List<String> ans = getTopKFrequent(2, new String[]{"anacell", "cetracular", "betacellular"}, new String[]{"Anacell provides the best services in the city",
  "betacellular has awesome services",
  "Best services provided by anacell, everyone should use anacell"});
        ans.forEach(x -> {
           System.out.print(x + " "); 
        });
    }
}
