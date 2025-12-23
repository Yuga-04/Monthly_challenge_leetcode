class Solution {
    public int nextMaxEvent(int l, int r, int end, int[] sufMax, int[][] events) {
        int max = 0;
        while(l<=r) {
            int m = l + (r-l)/2;
            if(events[m][0] > end) {
                max = sufMax[m];
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return max;
    }
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> Integer.compare(a[0],b[0]));
        int n = events.length;
        int[] sufMax = new int[n];
        sufMax[n-1] = events[n-1][2];
        for(int i=n-2;i>=0;i--)
            sufMax[i] = Math.max(sufMax[i+1], events[i][2]);
        int ans=0;
        for(int i=0;i<n;i++) {
            int sum = events[i][2];
            sum += nextMaxEvent(i+1, n-1, events[i][1], sufMax, events);
            ans = Math.max(ans,sum);
        }
        return ans;
    }
} 
