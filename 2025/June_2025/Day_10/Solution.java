import java.util.*;

class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count % 2 == 0) {
                minEven = Math.min(minEven, count);
            } else {
                maxOdd = Math.max(maxOdd, count);
            }
        }

        return maxOdd - minEven;
    }
} 
