// Question : https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/description/


import java.util.*;

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int[] sortedQueries = queries.clone();
        Arrays.sort(sortedQueries);
        Map<Integer, Integer> queryResult = new HashMap<>();
        int[] answer = new int[queries.length];

        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Set<String> visited = new HashSet<>();

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited.add("0,0");

        int points = 0;

        for (int query : sortedQueries) {
            while (!minHeap.isEmpty() && minHeap.peek()[0] < query) {
                int[] cell = minHeap.poll();
                int val = cell[0], r = cell[1], c = cell[2];

                points++;

                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    String key = nr + "," + nc;

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited.contains(key)) {
                        visited.add(key);
                        minHeap.offer(new int[]{grid[nr][nc], nr, nc});
                    }
                }
            }
            queryResult.put(query, points);
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = queryResult.get(queries[i]);
        }

        return answer;
    }
}
