class Trie {

    static class Node {
        boolean isWord = false;
        Node[] children = new Node[26];
    };

    Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String s){

        Node curr = root;
        for (char c : s.toCharArray()){
            if (curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new Node();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public List<String> search(String prefix){

        Node curr = root;
        List<String> result = new ArrayList<>();
        for (char c : prefix.toCharArray()){
            if (curr.children[c - 'a'] == null){
                return result;
            }
            curr = curr.children[c - 'a'];
        }
        dfs(curr, prefix, result);
        return result;
    }

    public void dfs(Node curr, String word, List<String> result){

        if (result.size() == 3) return;
        if (curr.isWord) result.add(word.toString());
        for (char c = 'a'; c <= 'z'; c++){
            if (curr.children[c - 'a'] != null){
                dfs(curr.children[c - 'a'], word + c, result);
            }
        }
    }
}


class Keyword_Suggestions_Q1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Trie trie = new Trie();
        for (String product : products){
            trie.insert(product);
        }
        String prefix = "";
        List<List<String>> ans = new ArrayList<>();
        for (char c : searchWord.toCharArray()){
            prefix += c;
            ans.add(trie.search(prefix));
        }
        return ans;
    }
}
