# 📌 Day 26: 1857. Largest Color Value in a Directed Graph 🎯

**🔗 LeetCode Link:** [1857. Largest Color Value in a Directed Grap](https://leetcode.com/problems/largest-color-value-in-a-directed-graph/)

---

## 🧩 Problem Description

<p>There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.
You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.
A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.
Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.</p>


<p><strong class="example">

---

## 🧠 Topics

- Hash Table
- Dynamic Programming
- GraphTopological SortMemoization
- Counting
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img src="https://assets.leetcode.com/uploads/2021/04/21/leet1.png" >
<pre><strong>Input:</strong> Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
<strong>Output:</strong> 3
<strong>Explanation:</strong>The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" (red in the above image).
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<img src="https://assets.leetcode.com/uploads/2021/04/21/leet2.png" >
<pre><strong>Input:</strong> colors = "a", edges = [[0,0]]
<strong>Output:</strong> -1
<strong>Explanation:</strong>There is a cycle from 0 to 0.
</pre>

<p> </p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == colors.length</code></li>
	<li><code>  m == edges.length</code></li>
<li><code>1 <= n <= 105 </code></li>

<li><code>0 <= m <= 105</code></li>
	<li><code>colours</code>consists of lowercase English letters. </li>
	<li><code> 0 <= aj, bj < n </code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] indegree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        
        // Initialize graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph.get(from).add(to);
            indegree[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[][] dp = new int[n][26];
        int processed = 0;
        int maxColorValue = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            processed++;

            int colorIndex = colors.charAt(node) - 'a';
            dp[node][colorIndex]++;
            maxColorValue = Math.max(maxColorValue, dp[node][colorIndex]);

            for (int neighbor : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    dp[neighbor][c] = Math.max(dp[neighbor][c], dp[node][c]);
                }

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return processed == n ? maxColorValue : -1;
    }
}
```

---

## 🧪 Sample Test Case

Example 1:</strong></p>
<img src="https://assets.leetcode.com/uploads/2021/04/21/leet1.png" >
<pre><strong>Input:</strong> Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
<strong>Output:</strong> 3
<p><strong class="example">
