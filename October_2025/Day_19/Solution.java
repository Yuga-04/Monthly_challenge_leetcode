class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();

        // Precompute minimal addition steps for each digit
        int[] bestAdd = new int[10];
        for (int d = 0; d < 10; d++) {
            int minVal = d, minStep = 0;
            for (int step = 1; step < 10; step++) {
                int newVal = (d + a * step) % 10;
                if (newVal < minVal) {
                    minVal = newVal;
                    minStep = step;
                }
            }
            bestAdd[d] = minStep;
        }

        // Determine reachable rotation starts
        boolean[] visited = new boolean[n];
        int idx = 0;
        while (!visited[idx]) {
            visited[idx] = true;
            idx = (idx + b) % n;
        }

        String answer = s;

        // Try each reachable rotation
        for (int start = 0; start < n; start++) {
            if (!visited[start]) continue;
            String rotated = s.substring(start) + s.substring(0, start);

            int evenAdd = 0, oddAdd = 0;
            if (n == 1) {
                evenAdd = bestAdd[rotated.charAt(0) - '0'];
            } else {
                evenAdd = (b % 2 == 1) ? bestAdd[rotated.charAt(0) - '0'] : 0;
                oddAdd  = bestAdd[rotated.charAt(1) - '0'];
            }

            StringBuilder sb = new StringBuilder(rotated);
            for (int j = 0; j < n; j++) {
                int d = sb.charAt(j) - '0';
                int times = (j % 2 == 0) ? evenAdd : oddAdd;
                d = (d + times * a) % 10;
                sb.setCharAt(j, (char)('0' + d));
            }

            String candidate = sb.toString();
            if (candidate.compareTo(answer) < 0) answer = candidate;
        }

        return answer;
    }
} 
