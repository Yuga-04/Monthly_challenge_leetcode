// Question : https://leetcode.com/problems/alternating-groups-ii/description/
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int clp=1,res=0,n=colors.length;
        for(int i=1;i<n+k-1;i++){
            if(colors[i%n]!=colors[(i-1+n)%n]){
                clp++;
            }else{
                clp=1;
            }
            if(clp>=k){
                res++;
            }
        }
        return res;
    }
}
