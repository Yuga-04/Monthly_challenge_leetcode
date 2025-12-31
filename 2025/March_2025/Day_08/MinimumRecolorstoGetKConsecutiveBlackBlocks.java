//Question : https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int wc=0,mino=k,bc=0;
        for(int i=0;i<blocks.length();i++){
             if(blocks.charAt(i)=='B'){
                    bc++;
                    if(bc==k){
                        return 0;
                    }
             }
             else{
                bc=0;
             }
        }
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='W'){
                wc++;
            }
        }
        mino=wc;
        for(int i=k;i<blocks.length();i++){
            if(blocks.charAt(i)=='W'){
            wc++;}
            if(blocks.charAt(i-k)=='W'){
                wc--;
            }
            mino=Math.min(mino,wc);
        }
        return mino;
    }
}
