class ZigZag_Conversion_Q_6 {
    public String convert(String s, int numRows) {
        
        if (numRows == 1) return s;
        StringBuilder ans = new StringBuilder();
        List<StringBuilder> rows = new ArrayList<>();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;
        
        for (int i = 0; i < numRows; i++){
            for (int j = 0; i+j < n; j += cycleLen){
                ans.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ans.append(s.charAt(j + cycleLen - i));
                
            }
        }
        return ans.toString();
    }
}
