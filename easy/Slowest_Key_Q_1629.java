class Slowest_Key_Q_1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        
        int max = Integer.MIN_VALUE;
        int start = 0;
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < releaseTimes.length; i++){
            if (releaseTimes[i] - start > max){
                max = releaseTimes[i] - start;
                chars = new ArrayList<>();
                chars.add(keysPressed.charAt(i));
            } else if ((releaseTimes[i] - start) ==  max){
                chars.add(keysPressed.charAt(i));
            }
            start = releaseTimes[i];
        }
        
        char min = chars.get(0);
        for (Character ch : chars){
            if (ch > min){
                min = ch;
            }
        }
        return min;
    }
}
