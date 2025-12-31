//Question : https://leetcode.com/problems/partition-labels/description/

import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] freq = new int[26];
        int a = 'a';

        for (char c : s.toCharArray()) {
            freq[c - a]++;
        }

        List<Integer> output = new ArrayList<>();
        int prevEnd = 0;

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - a]--;

            if (isValid(prevEnd, i, s, freq)) {
                output.add(i - prevEnd + 1);
                prevEnd = i + 1;
            }
        }

        return output;
    }

    private boolean isValid(int start, int end, String s, int[] freq) {
        for (int i = start; i <= end; i++) {
            if (freq[s.charAt(i) - 'a'] != 0) return false;
        }
        return true;
    }
}
