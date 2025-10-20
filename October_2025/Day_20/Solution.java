class Solution {
    public int finalValueAfterOperations(String[] o) {
        int x = 0;
        int l = o.length;
        for(int i = 0;i<l;i++){
            if(o[i].charAt(0)=='+'||o[i].charAt(2)=='+') x++;
            else x--;
        }
        return x;
    }
} 
