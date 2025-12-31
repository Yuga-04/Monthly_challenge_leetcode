class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;

        int n = word.length();
        int len = n - numFriends + 1;
        char maxChar = 'a';

        for (char ch : word.toCharArray()) {
            if (ch > maxChar) maxChar = ch;
        }

        String result = "";
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == maxChar) {
                if (i + len <= n) {
                    String sub = word.substring(i, i + len);
                    if (sub.compareTo(result) > 0) result = sub;
                } else {
                    String sub = word.substring(i);
                    if (sub.compareTo(result) > 0) result = sub;
                }
            }
        }

        return result;
    }
} 
