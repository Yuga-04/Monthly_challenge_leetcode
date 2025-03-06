//Question: https://leetcode.com/problems/find-missing-and-repeated-values/description/
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int miss=-1,repeat=-1;
        Set<Integer > elements = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(elements.contains(grid[i][j])){
                    repeat=grid[i][j];
                }
                elements.add(grid[i][j]);
            }
        }
        for(int m=1;m<=n*n;m++){
                if(elements.contains(m)){
                    continue;
                }
                else{
                    miss=m;
                }
        }
        return new int[] {repeat,miss};
    }
}
