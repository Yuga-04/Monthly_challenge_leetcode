//Question : https://leetcode.com/problems/solving-questions-with-brainpower/description/
class Solution {
    public long mostPoints(int[][] questions) {
        int n  =questions.length;
        long[] res = new long[n];
        res[n-1] = questions[n-1][0];
        for(int i = n-2;i>=0;i--){
            if(questions[i][1]+i+1>=n){
                res[i] = Math.max(questions[i][0],res[i+1]);
            }else{
                res[i] = Math.max(res[i+1],questions[i][0]+res[i+1+questions[i][1]]);
            }
        }
        return res[0];
    }
}
