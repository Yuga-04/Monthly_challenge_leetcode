class Solution {
    public int minimumDeletions(String word, int k) {
         Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        // Step 2: Collect frequencies and sort them
        List<Integer> frequencies = new ArrayList<>(freqMap.values());
        Collections.sort(frequencies);
        
        int minDeletions = Integer.MAX_VALUE;
        int n = frequencies.size();
        
        // Step 3: For each frequency, consider it as the base and calculate deletions
        for (int i = 0; i < n; i++) {
            int base = frequencies.get(i);
            int totalDeletions = 0;
            
            // For frequencies less than base, delete all occurrences (since we can't increase frequencies)
            for (int j = 0; j < i; j++) {
                totalDeletions += frequencies.get(j);
            }
            
            // For frequencies greater than base + k, reduce them to base + k
            for (int j = i; j < n; j++) {
                if (frequencies.get(j) > base + k) {
                    totalDeletions += frequencies.get(j) - (base + k);
                }
            }
            
            if (totalDeletions < minDeletions) {
                minDeletions = totalDeletions;
            }
        }
        
        return minDeletions;
        
    }
} 
