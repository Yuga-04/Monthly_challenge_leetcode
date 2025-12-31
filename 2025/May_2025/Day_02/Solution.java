class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        String s = "L" + dominoes + "R";
        char[] arr = s.toCharArray();
        int prev = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '.') continue;
            if (arr[prev] == arr[i]) {
                for (int k = prev + 1; k < i; k++) arr[k] = arr[i];
            } else if (arr[prev] == 'R' && arr[i] == 'L') {
                int l = prev + 1, r = i - 1;
                while (l < r) {
                    arr[l++] = 'R';
                    arr[r--] = 'L';
                }
            }
            prev = i;
        }
        return new String(arr, 1, n);
    }
}