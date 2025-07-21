class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        int count = 1;
        res.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count < 3) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
} 
