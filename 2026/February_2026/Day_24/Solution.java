class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return DFS(root, 0);
    }

    public int DFS(TreeNode rt, int x) {
        if (rt==null) return 0;
        x = x*2 + rt.val;
        if(rt.left==rt.right) return x;
        return DFS(rt.left, x) + DFS(rt.right, x);
    }
} 
