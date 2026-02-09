class Solution {
    List<Integer> nums;
    public TreeNode balanceBST(TreeNode root) {
        nums = new ArrayList<Integer>();
        getNumbers(root);
        TreeNode res = balanceTree(0,nums.size()-1);
        return res;
    }
    private void getNumbers(TreeNode node){
        if(node==null) return;
        getNumbers(node.left);
        nums.add(node.val);
        getNumbers(node.right);
    }
    private TreeNode balanceTree(int l, int r){
        if(l>r)return null;
        int middleIdx = l+ ((r-l)/2);
        TreeNode res = new TreeNode(nums.get(middleIdx));
        res.left = balanceTree(l,middleIdx-1);
        res.right = balanceTree(middleIdx+1,r);
        return res;
    }              
} 
