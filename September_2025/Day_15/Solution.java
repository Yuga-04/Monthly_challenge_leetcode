class Solution {
    public int canBeTypedWords(String text, String broken) {
        int mask = 0;
        for (int i = 0; i < broken.length(); i++) {
            mask |= 1 << (broken.charAt(i) - 97);
        }

        int count = 0;
        boolean brokenWord = false;
        for (int i = 0; i <= text.length(); i++) {
            if (i < text.length() && (mask & (1 << (text.charAt(i) - 97))) != 0) brokenWord = true;
            if (i == text.length() || text.charAt(i) == ' ') {
                if (!brokenWord) count++;
                brokenWord = false;
            }
        }
        return count;
    }
} 
