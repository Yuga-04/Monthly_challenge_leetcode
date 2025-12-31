//Question : https://leetcode.com/problems/count-total-number-of-colored-cells/description/
class Solution { 
    public long coloredCells(int n) { 
        return (long)n*n+(long)(n-1)*(n-1);
    }
}
