import java.util.*;

class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        Map<String, Integer> strToId = new HashMap<>();
        int idCounter = 0;

        for (String s : original) if (!strToId.containsKey(s)) strToId.put(s, idCounter++);
        for (String s : changed) if (!strToId.containsKey(s)) strToId.put(s, idCounter++);

        long INF = 1_000_000_000_000_000L;
        long[][] dist = new long[idCounter][idCounter];
        for (int i = 0; i < idCounter; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = strToId.get(original[i]);
            int v = strToId.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], (long) cost[i]);
        }

        // Floyd-Warshall
        for (int k = 0; k < idCounter; k++) {
            for (int i = 0; i < idCounter; i++) {
                for (int j = 0; j < idCounter; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        Set<Integer> uniqueLens = new HashSet<>();
        for (String s : original) uniqueLens.add(s.length());
        Integer[] lens = uniqueLens.toArray(new Integer[0]);

        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue;

            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            for (int len : lens) {
                if (i + len <= n) {
                    String subS = source.substring(i, i + len);
                    String subT = target.substring(i, i + len);

                    if (subS.equals(subT)) {
                        dp[i + len] = Math.min(dp[i + len], dp[i]);
                    } else if (strToId.containsKey(subS) && strToId.containsKey(subT)) {
                        int u = strToId.get(subS);
                        int v = strToId.get(subT);
                        if (dist[u][v] < INF) {
                            dp[i + len] = Math.min(dp[i + len], dp[i] + dist[u][v]);
                        }
                    }
                }
            }
        }

        return dp[n] >= INF ? -1 : dp[n];
    }
} 
