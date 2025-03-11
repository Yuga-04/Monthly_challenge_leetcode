//Question : https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
class Solution {
    public int numberOfSubstrings(String s) {
     int n=s.length(),l=0,res=0;
     int c[]={0,0,0};
     res=0;
     for(int r=0;r<n;r++){
        c[s.charAt(r)-'a']++;
        while (c[0]>0 && c[1]>0 && c[2]>0){
            res+=n-r;
            c[s.charAt(l)-'a']--;
            l++;
        }   
     }   
        return res;
    }
}
