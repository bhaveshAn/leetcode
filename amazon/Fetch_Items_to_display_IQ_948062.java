// "static void main" must be defined in a public class.
public class Fetch_Items_to_display_IQ_948062 {
    
    private static List<Map.Entry<String, Pair<Integer, Integer>>> fetchItemsToDisplay(int numOfItems, HashMap<String, Pair<Integer, Integer>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber){
        
        List<Map.Entry<String, Pair<Integer, Integer>>> list = new ArrayList<Map.Entry<String, Pair<Integer, Integer>>>(items.entrySet());
        Collections.sort(list, new  Comparator<Map.Entry<String, Pair<Integer, Integer>>>() {
            
            public int compare(Map.Entry<String, Pair<Integer, Integer>> a, Map.Entry<String, Pair<Integer, Integer>> b){
                
            switch (sortOrder){
                case 0:
                    switch (sortParameter){
                        case 0:
                            return a.getKey().compareTo(b.getKey());
                        case 1:
                            return a.getValue().getKey().compareTo(b.getValue().getKey());
                        case 2:
                            return a.getValue().getValue().compareTo(b.getValue().getValue());
                    }
                case 1:
                    switch (sortParameter){
                        case 0:
                            return b.getKey().compareTo(a.getKey());
                        case 1:
                            return b.getValue().getKey().compareTo(a.getValue().getKey());
                        case 2:
                            return b.getValue().getValue().compareTo(a.getValue().getValue());
                    }
            }
                return 1;
            }
        });
        
        return list.size() >= (pageNumber + 1) * itemsPerPage ? list.subList(pageNumber * itemsPerPage, (pageNumber + 1) * itemsPerPage) :  list.subList(pageNumber * itemsPerPage, list.size());
    }
    
    public static void main(String[] args) {
        
        int numOfItems = 3;
        HashMap<String, Pair<Integer, Integer>> items = new HashMap<>();
        items.put("item1", new Pair<Integer, Integer>(10, 15));
        items.put("item2", new Pair<Integer, Integer>(3, 4));
        items.put("item3", new Pair<Integer, Integer>(17, 8));
        
        int sortParameter = 1;
        int sortOrder = 0;
        int itemsPerPage = 2;
        int pageNumber = 1;
                
        fetchItemsToDisplay(numOfItems, items, sortParameter, sortOrder, itemsPerPage, pageNumber).forEach(x -> {
            System.out.println(x.getKey());
        });
    }
}
