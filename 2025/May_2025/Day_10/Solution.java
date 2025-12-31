class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m = nums2.length;
        long nsum=0; int nzeroes=0;
        long msum=0; int mzeroes=0;
        for(int i=0; i<n; i++){
            nsum+=nums1[i];
            if(nums1[i]==0){
                nzeroes++;
            }
        }
        for(int i=0; i<m; i++){
            msum+=nums2[i];
            if(nums2[i]==0){
                mzeroes++;
            }
        }
        return ((nzeroes==0 && nsum-mzeroes<msum)||(mzeroes==0 && msum-nzeroes<nsum)) ? -1 : Math.max(nzeroes+nsum, mzeroes+msum);
    }
}