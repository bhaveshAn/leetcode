public class Unique_Device_Names_IQ_945483 {
    
    private static String[] getNames(int n, String[] devices){
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            String device = devices[i];
            if (map.containsKey(devices[i])){
                devices[i] = devices[i] + map.get(devices[i]);
            }
            map.put(device, map.getOrDefault(device, 0) + 1);
        }
        return devices;        
    }
    public static void main(String[] args) {
        
        String[] ans = getNames(6, new String[]{"switch", "tv", "switch", "tv","switch", "tv"});
        for (String a : ans){
            System.out.print(a + ", ");
        }
    }
}
