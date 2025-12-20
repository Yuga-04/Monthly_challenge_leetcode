class Solution {
    public boolean isSortedColumn(int col, String[] strs) {
        for(int i=1;i<strs.length;i++) {
            if(strs[i].charAt(col) < strs[i-1].charAt(col))
                return false;
        }
        return true;
    }
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for(int i=0;i<strs[0].length();i++) {
            if(!isSortedColumn(i, strs)) {
                count++;
            }
        }
        return count;
    }
} 
