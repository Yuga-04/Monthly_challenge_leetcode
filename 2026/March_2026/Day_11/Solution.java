class Solution {
    public int bitwiseComplement(int n) {
        int bits = 32 - Integer.numberOfLeadingZeros(n | 1);
        int mask = (1 << bits) - 1;
        return ~n & mask;
    }
} 
