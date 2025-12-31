class Solution {
    private int check(int target,int[] tops,int[] bottoms)
    {
        int rotateTop=0;
        int rotateBottom=0;

        int len=tops.length;
        for(int i=0;i<len;i++)
        {
            if(tops[i]!=target && bottoms[i]!=target)
               return -1;
            else if(tops[i]!=target)
              rotateTop++;
            else if(bottoms[i]!=target)
               rotateBottom++;
        }
        return rotateTop<rotateBottom ? rotateTop : rotateBottom;
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int no_rotations=-1;
        //1 <= tops[i], bottoms[i] <= 6
        for(int i=1;i<7;i++)
        {
            int n_r=check(i,tops,bottoms);
            if(n_r!=-1 && (no_rotations==-1 || n_r<no_rotations))
               no_rotations=n_r;
        }
        return no_rotations;
        
    }
}