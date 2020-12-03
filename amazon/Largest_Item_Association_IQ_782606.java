// "static void main" must be defined in a public class.
// Largest Item Association
public class Largest_Item_Association_IQ_782606 {
    
    
    private static List<String> getLargestAssociation(List<List<String>> itemAssociation){
        
        Map<String, List<String>> graph = new HashMap<>();
        List<List<String>> merged = new ArrayList<>();
        
        for (List<String> items : itemAssociation){
            List<String> vals = graph.getOrDefault(items.get(0), new ArrayList<>());
            vals.add(items.get(1));
            graph.put(items.get(0), vals);
            vals = graph.getOrDefault(items.get(1), new ArrayList<>());
            vals.add(items.get(0));
            graph.put(items.get(1), vals);
        }
        
        Set<String> visited = new HashSet<>();
        for (String key : graph.keySet()){
            List<String> list = new ArrayList<>();
            dfs(key, list, graph, visited);
            if(!list.isEmpty()) {
                Collections.sort(list);
                merged.add(list);
            }
        }
        
        Collections.sort(merged, (List<String> l1, List<String> l2) -> {
            if(l1.size() == l2.size()) {
                    for(int i=0; i<l1.size(); i++) {
                        if(l1.get(i).equals(l2.get(i))) continue;
                        return l1.get(i).compareTo(l2.get(i));
                    }
                }
                return l2.size() - l1.size();
        });
        return merged.get(0);
    }
    
    private static void dfs(String key, List<String> list, Map<String, List<String>> graph, Set<String> visited){
        
        if (visited.contains(key)) return;
        visited.add(key);
        list.add(key);
        for (String neighbour : graph.get(key)){
            dfs(neighbour, list, graph, visited);
        }
    }
    
    public static void main(String[] args) {
        
        List<List<String>> itemAssociation = new ArrayList<>();
        itemAssociation.add(Arrays.asList("item1", "item2"));
        itemAssociation.add(Arrays.asList("item3", "item4"));
        itemAssociation.add(Arrays.asList("item4", "item5"));
        getLargestAssociation(itemAssociation).forEach(x -> {
           System.out.print(x + " "); 
        });
    }
}
