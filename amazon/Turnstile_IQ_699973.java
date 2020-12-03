// "static void main" must be defined in a public class.
public class Turnstile_IQ_699973 {
    
    
    private static int[] getTimes(int[] times, int[] direction){
        
        int n = times.length;
        Map<Integer, List<Integer>> come = new HashMap<>();
        Map<Integer, List<Integer>> go = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            List<Integer> list = new ArrayList<>();
            if (direction[i] == 0){
                list = come.getOrDefault(times[i], new ArrayList<>());
                list.add(i);
                come.put(times[i], list);
            } else {
                list = go.getOrDefault(times[i], new ArrayList<>());
                list.add(i);
                go.put(times[i], list);
            }
            if (max < times[i]) max = times[i];
            if (min > times[i]) min = times[i];
        }
        int t = 1;
        int[] ans = new int[n];
        int i = min;
        while (come.keySet().size() != 0 || go.keySet().size() != 0){
            if (t == 1){
                if (go.keySet().size() != 0){
                    int j = min;
                    while (!go.containsKey(j) && j < i){
                        j += 1;
                    }
                    if (go.containsKey(j)){
                        int k = go.get(j).get(0);
                        ans[k] = i;
                        go.get(j).remove(0);
                        if (go.get(j).size() == 0) go.remove(j);
                    }
                } else if (come.keySet().size() != 0){
                    int j = min;
                    while (!come.containsKey(j) && j < i){
                        j += 1;
                    }
                    if (come.containsKey(j)){
                        int k = come.get(j).get(0);
                        ans[k] = i;
                        come.get(j).remove(0);
                        t = 0;
                        if (come.get(j).size() == 0) come.remove(j);
                    }
                }
            } else {
                if (come.keySet().size() != 0){
                    int j = min;
                    while (!come.containsKey(j) && j < i){
                        j += 1;
                    }
                    if (come.containsKey(j)){
                        int k = come.get(j).get(0);
                        ans[k] = i;
                        come.get(j).remove(0);
                        if (come.get(j).size() == 0) come.remove(j);
                    }
                } else if (go.keySet().size() != 0){
                    int j = min;
                    while (!go.containsKey(j) && j < i){
                        j += 1;
                    }
                    if (go.containsKey(j)){
                        int k = go.get(j).get(0);
                        ans[k] = i;
                        go.get(j).remove(0);
                        t = 1;
                        if (go.get(j).size() == 0) go.remove(j);
                    }
                }
            }
            i++;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] ans = getTimes(new int[]{0,0,1,5}, new int[]{0,1,1,0});
        for (int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
