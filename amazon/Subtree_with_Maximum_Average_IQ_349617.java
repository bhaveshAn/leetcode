public class Subtree_with_Maximum_Average_IQ_349617 {
    
    static class TreeNode {
        
        int val;
        List<TreeNode> children;
        
        public TreeNode(int val){
            this.val = val;
            this.children = new ArrayList<>();
        }
    }
    
    static TreeNode maxNode = null;
    static double maxAvg = Integer.MIN_VALUE;
    
    private static TreeNode getMaxNode(TreeNode root){
        helper(root);
        return maxNode;
    }
    
    private static double[] helper(TreeNode node){
        
        if (node == null) return new double[]{0,0};
        double currTotal = node.val;
        double count = 1;
        for (TreeNode n : node.children){
            double[] vals = helper(n);
            currTotal += vals[0];
            count += vals[1];
        }
        double avg = currTotal / count;
        if (count > 1 && avg > maxAvg){
            maxAvg = avg;
            maxNode = node;
        }
        return new double[]{currTotal, count};
    }
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(20);
        root.children.add(new TreeNode(12));
        root.children.add(new TreeNode(18));
        
        root.children.get(0).children.add(new TreeNode(11));
        root.children.get(0).children.add(new TreeNode(2));
        root.children.get(0).children.add(new TreeNode(3));
        
        root.children.get(1).children.add(new TreeNode(15));
        root.children.get(1).children.add(new TreeNode(8));
        
        System.out.println(getMaxNode(root).val);
    }
}
