// "static void main" must be defined in a public class.
public class Divisibility_of_Strings_IQ_680341 {
    
    private static int divisibility(String s, String t){
        
        int m = s.length();
        int n = t.length();
        if (m < n) return -1;
        if (s.equals(t)) return 0;
        int i = 0;
        int j = 0;
        StringBuilder ans = new StringBuilder();
        while (i < m && j < n && s.charAt(i) == t.charAt(j)){
            if (j == n - 1 && i != m - 1){
                j = 0;
            } else{
                j++;
            }
            i++;
        }
        if (i != m && j != n) return -1;
        return count(t);   
    }
    
    private static int count(String s){
        if (s.substring(0, s.length() / 2).equals(s.substring(s.length() / 2, s.length()))){
            return count(s.substring(0, s.length() / 2));
        }
        return s.length();
    }
    
    public static void main(String[] args) {
        
        System.out.println(divisibility("bcdbcdbcdbcd", "bcdbcd"));
    }
}
