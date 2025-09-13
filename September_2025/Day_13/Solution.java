import java.util.*;

class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int con = 0, vow = 0;
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            if ("aeiou".indexOf(ch) >= 0)
                vow = Math.max(vow, count);
            else
                con = Math.max(con, count);
        }
        return con + vow;
    }
} 
