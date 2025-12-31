class Solution {
    Map<String, List<Character>> map = new HashMap<>();
    Map<String, Boolean> memo = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        return solve(bottom);
    }

    private boolean solve(String bottom) {
        if (bottom.length() == 1) return true;
        if (memo.containsKey(bottom)) return memo.get(bottom);

        // Try to generate a valid next row and solve recursively
        boolean result = generateNextRow(bottom, 0, new StringBuilder());
        memo.put(bottom, result);
        return result;
    }

    // Helper to generate next row candidates (DFS within the level)
    private boolean generateNextRow(String bottom, int idx, StringBuilder currentNext) {
        if (idx == bottom.length() - 1) {
            // Full next row built, proceed to next level
            return solve(currentNext.toString());
        }

        String key = bottom.substring(idx, idx + 2);
        if (!map.containsKey(key)) return false;

        for (char val : map.get(key)) {
            currentNext.append(val);
            if (generateNextRow(bottom, idx + 1, currentNext)) return true;
            currentNext.deleteCharAt(currentNext.length() - 1); // backtrack
        }
        
        return false;
    }
    
} 
