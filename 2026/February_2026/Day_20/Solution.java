class Solution {
    public String makeLargestSpecial(String s) {
        int count = 0, i = 0;
        List<String> res = new ArrayList<>();
        
        for (int j = 0; j < s.length(); j++) {
            // Track balance: +1 for '1', -1 for '0'
            if (s.charAt(j) == '1') count++;
            else count--;
            
            // Found a balanced chunk when count returns to 0
            if (count == 0) {
                // Recursively maximize inner part, wrap with 1...0
                res.add('1' + makeLargestSpecial(s.substring(i + 1, j)) + '0');
                i = j + 1; // Move to next potential chunk
            }
        }
        
        // Sort chunks in descending order for largest arrangement
        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }
}
