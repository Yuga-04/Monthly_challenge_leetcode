import java.util.*;

public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        Map<String, Integer> dp = new HashMap<>();
        return helper(strs, 0, m, n, dp);
    }

    private int helper(String[] strs, int i, int zerosLeft, int onesLeft, Map<String, Integer> dp) {
        if (i >= strs.length) return 0;

        String key = i + "," + zerosLeft + "," + onesLeft;
        if (dp.containsKey(key)) return dp.get(key);

        String word = strs[i];
        int oneCount = countOnes(word);
        int zeroCount = countZeros(word);

        int picked = 0;
        if (oneCount <= onesLeft && zeroCount <= zerosLeft) {
            picked = 1 + helper(strs, i + 1, zerosLeft - zeroCount, onesLeft - oneCount, dp);
        }

        int notPicked = helper(strs, i + 1, zerosLeft, onesLeft, dp);
        int result = Math.max(picked, notPicked);
        dp.put(key, result);
        return result;
    }

    private int countOnes(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') count++;
        }
        return count;
    }

    private int countZeros(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') count++;
        }
        return count;
    }

} 
