class Solution {
    public int maxDiff(int num) {
        String str = Integer.toString(num);
        StringBuilder maxStr = new StringBuilder(str);
        StringBuilder minStr = new StringBuilder(str);

        // Get max number by replacing first non-'9' digit
        char maxDigit = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '9') {
                maxDigit = str.charAt(i);
                break;
            }
        }

        if (maxDigit != ' ') {
            for (int i = 0; i < maxStr.length(); i++) {
                if (maxStr.charAt(i) == maxDigit) {
                    maxStr.setCharAt(i, '9');
                }
            }
        }

        // Get min number
        char minDigit = str.charAt(0);
        char replace = '1';

        if (minDigit == '1') {
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) != '0' && str.charAt(i) != '1') {
                    minDigit = str.charAt(i);
                    replace = '0';
                    break;
                }
            }
        }

        for (int i = 0; i < minStr.length(); i++) {
            if (minStr.charAt(i) == minDigit) {
                minStr.setCharAt(i, replace);
            }
        }

        int maxVal = Integer.parseInt(maxStr.toString());
        int minVal = Integer.parseInt(minStr.toString());

        return maxVal - minVal;
    }
} 
