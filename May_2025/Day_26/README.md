\\# 📌 Day 25: 1857. Largest Color Value in a Directed Graph 🎯

\\*\\*🔗 LeetCode Link:\\*\\* \\[1857. Largest Color Value in a Directed Grap\\](https://leetcode.com/problems/largest-color-value-in-a-directed-graph/)

\\---

\\## 🧩 Problem Description

\u003Cp>There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.
You are given a string colors where colors\\[i\\] is a lowercase English letter representing the color of the ith node in this graph (0-indexed). You are also given a 2D array edges where edges\\[j\\] = \\[aj, bj\\] indicates that there is a directed edge from node aj to node bj.
A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 \u003C= i \u003C k. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.
Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.\u003C/p>


\u003Cp>\u003Cstrong class=\"example\">

\\---

\\## 🧠 Topics

* Hash Table
* Dynamic Programming
* GraphTopological SortMemoization
* Counting
\\---

\\## 🧩 Examples

\\### ✨ Example 1

Example 1:\u003C/strong>\u003C/p>
\u003Cimg src=\"https://assets.leetcode.com/uploads/2021/04/21/leet1.png\" >
\u003Cpre>\u003Cstrong>Input:\u003C/strong> Input: colors = \"abaca\", edges = \\[\\[0,1\\],\\[0,2\\],\\[2,3\\],\\[3,4\\]\\]
\u003Cstrong>Output:\u003C/strong> 3
\u003Cstrong>Explanation:\u003C/strong>The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored \"a\" (red in the above image).
\u003C/pre>

\u003Cp>\u003Cstrong class=\"example\">

\\### ✨ Example 2

Example 2:\u003C/strong>\u003C/p>
\u003Cimg src=\"https://assets.leetcode.com/uploads/2021/04/21/leet2.png\" >
\u003Cpre>\u003Cstrong>Input:\u003C/strong> colors = \"a\", edges = \\[\\[0,0\\]\\]
\u003Cstrong>Output:\u003C/strong> -1
\u003Cstrong>Explanation:\u003C/strong>There is a cycle from 0 to 0.
\u003C/pre>

\u003Cp> \u003C/p>
\u003Cp>\u003Cstrong>Constraints:\u003C/strong>\u003C/p>

\u003Cul>
\t\u003Cli>\u003Ccode>n == colors.length\u003C/code>\u003C/li>
\t\u003Cli>\u003Ccode>  m == edges.length\u003C/code>\u003C/li>
\u003Cli>\u003Ccode>1 \u003C= n \u003C= 105 \u003C/code>\u003C/li>

\u003Cli>\u003Ccode>0 \u003C= m \u003C= 105\u003C/code>\u003C/li>
\t\u003Cli>\u003Ccode>colours\u003C/code>consists of lowercase English letters. \u003C/li>
\t\u003Cli>\u003Ccode> 0 \u003C= aj, bj \u003C n \u003C/code>\u003C/li>
\u003C/ul>

\\---

\\## ✅ Code (Java)

\\`\\`\\`java
class Solution {
    public int largestPathValue(String colors, int\\[\\]\\[\\] edges) {
        int n = colors.length();
        int\\[\\] indegree = new int\\[n\\];
        List\u003CList\u003CInteger>> graph = new ArrayList\u003C>();
        
        // Initialize graph
        for (int i = 0; i \u003C n; i++) {
            graph.add(new ArrayList\u003C>());
        }

        for (int\\[\\] edge : edges) {
            int from = edge\\[0\\], to = edge\\[1\\];
            graph.get(from).add(to);
            indegree\\[to\\]++;
        }
        Queue\u003CInteger> queue = new LinkedList\u003C>();
        for (int i = 0; i \u003C n; i++) {
            if (indegree\\[i\\] == 0) {
                queue.offer(i);
            }
        }
        int\\[\\]\\[\\] dp = new int\\[n\\]\\[26\\];
        int processed = 0;
        int maxColorValue = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            processed++;

            int colorIndex = colors.charAt(node) - 'a';
            dp\\[node\\]\\[colorIndex\\]++;
            maxColorValue = Math.max(maxColorValue, dp\\[node\\]\\[colorIndex\\]);

            for (int neighbor : graph.get(node)) {
                for (int c = 0; c \u003C 26; c++) {
                    dp\\[neighbor\\]\\[c\\] = Math.max(dp\\[neighbor\\]\\[c\\], dp\\[node\\]\\[c\\]);
                }

                indegree\\[neighbor\\]--;
                if (indegree\\[neighbor\\] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return processed == n ? maxColorValue : -1;
    }
}
\\`\\`\\`

\\---

\\## 🧪 Sample Test Case

Example 1:\u003C/strong>\u003C/p>
\u003Cimg src=\"https://assets.leetcode.com/uploads/2021/04/21/leet1.png\" >
\u003Cpre>\u003Cstrong>Input:\u003C/strong> Input: colors = \"abaca\", edges = \\[\\[0,1\\],\\[0,2\\],\\[2,3\\],\\[3,4\\]\\]
\u003Cstrong>Output:\u003C/strong> 3
\u003Cp>\u003Cstrong class=\"example\">

