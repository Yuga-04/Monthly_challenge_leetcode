class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String w : wordlist) {
            String lower = toLower(w);
            String devowel = deVowel(lower);
            caseMap.putIfAbsent(lower, w);
            vowelMap.putIfAbsent(devowel, w);
        }
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                result[i] = q;
            } else {
                String lower = toLower(q);
                String devowel = deVowel(lower);
                if (caseMap.containsKey(lower)) result[i] = caseMap.get(lower);
                else if (vowelMap.containsKey(devowel)) result[i] = vowelMap.get(devowel);
                else result[i] = "";
            }
        }
        return result;
    }
    private String toLower(String s) {
        return s.toLowerCase();
    }
    private String deVowel(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (isVowel(ch[i])) ch[i] = '*';
        }
        return new String(ch);
    }
    private boolean isVowel(char c) {
        return "aeiou".indexOf(Character.toLowerCase(c)) >= 0;
    }
} 
