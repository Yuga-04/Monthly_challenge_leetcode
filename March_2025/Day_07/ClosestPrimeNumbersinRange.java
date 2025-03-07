//Question : https://leetcode.com/problems/closest-prime-numbers-in-range/description/

class Solution {
    public int[] closestPrimes(int left, int right) {
        List<Integer> pri=new ArrayList<>();
        for(int i=left;i<=right;i++){
            int n=checkp(i);
            if(n!=0){
                pri.add(n);
            }
        }
        int []r=new int[]{-1,-1};
        int min=right;
        for(int i=pri.size()-1;i>0;i--){
            int mini=pri.get(i)-pri.get(i-1);
            if(mini<=min){
                min=mini;
                r[0]=pri.get(i-1);
                r[1]=pri.get(i);
            }
        }
        return r;
    }
    public int checkp(int m){
        if(m<2){
            return 0;
        }
        for(int i=2;i*i<=m;i++){
            if(m%i==0){
                return 0;
            }
        }
        return m;
    }
}
