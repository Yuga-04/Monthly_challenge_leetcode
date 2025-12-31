class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans=0;
        Arrays.sort(happiness);
        for(int i=0;i<k;i++){
            if((happiness[happiness.length-1-i]-i)>=0){
                ans+=(happiness[happiness.length-1-i]-i);
            }
            else{
                ans+=0;
            }
        }
        return ans;
    }
} 
