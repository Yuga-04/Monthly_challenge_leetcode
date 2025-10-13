class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<Map<Character, Integer>> freq = new ArrayList<>();
        for (String w : words) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : w.toCharArray())
                map.put(c, map.getOrDefault(c, 0) + 1);
            freq.add(map);
        }

        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for (int i = 1; i < n; i++) {
            if (!freq.get(i).equals(freq.get(i - 1)))
                ans.add(words[i]);
        }
        return ans;
    }
} 
