class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            int ch = c - 'a';
            freq[ch]--;
            stack.push(ch);

            while (!stack.isEmpty() && !hasSmaller(stack.peek(), freq)) {
                result.append((char) (stack.pop() + 'a'));
            }
        }

        return result.toString();
    }

    private boolean hasSmaller(int top, int[] freq) {
        for (int i = 0; i < top; i++) {
            if (freq[i] > 0) return true;
        }
        return false;
    }
} 
