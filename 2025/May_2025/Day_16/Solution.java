class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] next = new int[n], dp = new int[n];
        Arrays.fill(next, n);

        Map<Long, List<Integer>> maskMap = new HashMap<>();
        int bestStart = 0;

        for (int i = n - 1; i >= 0; i--) {
            char[] word = words[i].toCharArray();
            int len = word.length;
            long fullMask = 0;
            long[] charMasks = new long[len];
            
            for (int j = 0; j < len; j++) {
                long shift = (word[j] - 'a' + 1L) << (5 * j);
                charMasks[j] = shift;
                fullMask |= shift;
            }

            int maxLen = 1;
            int nextIndex = n;

            for (int j = 0; j < len; j++) {
                long alteredMask = fullMask ^ charMasks[j];
                List<Integer> candidates = maskMap.get(alteredMask);
                if (candidates == null) continue;

                for (int idx : candidates) {
                    if (groups[i] != groups[idx] && dp[idx] + 1 > maxLen) {
                        maxLen = dp[idx] + 1;
                        nextIndex = idx;
                    }
                }
            }

            dp[i] = maxLen;
            next[i] = nextIndex;
            if (dp[i] > dp[bestStart]) bestStart = i;

            // Insert current word into map
            for (int j = 0; j < len; j++) {
                long alteredMask = fullMask ^ charMasks[j];
                maskMap.computeIfAbsent(alteredMask, k -> new ArrayList<>()).add(i);
            }
        }

        List<String> result = new ArrayList<>(dp[bestStart]);
        for (int i = bestStart; i < n; i = next[i]) {
            result.add(words[i]);
        }

        return result;
    }
}