public class Distance_Between_Nodes_in_BST_IQ_376375 {
    
    private static class TreeNode {
        int val;
        TreeNode left, right;
        
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        
        TreeNode root = buildTree(new int[]{2,1,3}, 1, 3);
        TreeNode lca = lca(root, 1, 3);
        System.out.println(getDistance(lca, 1) + getDistance(lca, 3));
    }
    
    private static TreeNode buildTree(int[] arr, int n1, int n2){
        
        boolean found1 = false, found2 = false;
        TreeNode root = null;
        for (int val : arr){
            if (val == n1) found1 = true;
            if (val == n2) found2 = true;
            TreeNode node = new TreeNode(val);
            if (root == null){
                root = node;
                continue;
            }
            addNode(root, node);
        }
        if (!found1 || !found2) return null;
        return root;
    }
    private static void addNode(TreeNode root, TreeNode node){
        
        TreeNode curr = root;
        while (true){
            if (node.val < curr.val){
                if (curr.left == null){
                    curr.left = node;
                    return;
                } else{
                    curr = curr.left;
                }
            } else {
                if (curr.right == null){
                    curr.right = node;
                    return;
                } else{
                    curr = curr.right;
                }
            }
        }
    }
    
    private static TreeNode lca(TreeNode root, int n1, int n2){
        
        TreeNode curr = root;
        while (true){
            if (n1 < curr.val && n2 < curr.val){
               curr = curr.left;
            } else if (n1 > curr.val && n2 > curr.val){
               curr = curr.right;
            } else {
                return curr;
            }
        }
    }
    
    private static int getDistance(TreeNode node, int n){
        
        if (node.val == n) return 0;
        TreeNode curr = node.left;
        if (node.val < n) curr = node.right;
        return 1 + getDistance(curr, n);
    }
}
