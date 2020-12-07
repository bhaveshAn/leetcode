class Most_Common_Word_Q_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        Set<String> bannedSet = new HashSet<>();
        for (String b : banned){
            bannedSet.add(b.toLowerCase());
        }
        Map<String, Integer> count = new HashMap<>();
        int max = Integer.MIN_VALUE;
        paragraph = paragraph.replace("!", "").replace("?", "").replace("'", "").replace(",", "").replace(";", "").replace(".", "");
        String ans = "";
        for (String s : paragraph.split(" ")){
            if (!bannedSet.contains(s.toLowerCase())){
                count.put(s.toLowerCase(), count.getOrDefault(s.toLowerCase(), 0) + 1);
                if (max < count.get(s.toLowerCase())) {
                    max = count.get(s.toLowerCase());
                    ans = s.toLowerCase();
                }
            }
        }
        return ans;
    }
}
