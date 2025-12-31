import java.util.*;

class Solution {
    public String sortVowels(String s) {

        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }
        Collections.sort(vowels);

        StringBuilder result = new StringBuilder(s);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                result.setCharAt(i, vowels.get(j++));
            }
        }

        return result.toString();
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
} 
