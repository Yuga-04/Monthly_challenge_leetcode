class Solution {
    private static final String VOWELS = "aeiouAEIOU";

    public boolean isValid(String word) {
        if (word.length() < 3) return false;

        int v = 0, c = 0;
        for (char ch : word.toCharArray()) {
            if (Character.isDigit(ch)) continue;

            if (Character.isLetter(ch)) {
                if (VOWELS.indexOf(ch) >= 0) ++v;
                else ++c;
            } else {
                return false;                 // invalid symbol
            }
        }
        return v > 0 && c > 0;
    }
} 
