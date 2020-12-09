class Break_a_Palindrome_Q_1328 {
    public String breakPalindrome(String palindrome) {
        
        char[] chrs = palindrome.toCharArray();
        int n = palindrome.length();
        
        for (int i = 0 ; i < n / 2; i++){
            if (chrs[i] != 'a'){
                chrs[i] = 'a';
                return new String(chrs);
            }
        }
        chrs[n - 1] = 'b';
        return n < 2 ? "" : new String(chrs);
    }
}
