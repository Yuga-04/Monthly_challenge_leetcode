class Solution {
    static public int maxOperations(String s) {
        int cnt=0, n=s.length(), cnt1=(s.charAt(0)-'0');
        for(int i=1; i<n; i++){
            final int x=s.charAt(i)-'0';
            cnt1+=x;
            cnt+=(x==0 && s.charAt(i-1)-'0'==1)?cnt1:0;
        }
        return cnt;
    }
} 
