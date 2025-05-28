# 📌 Day 28: 3372. Maximize the Number of Target Nodes After Connecting Trees I 🎯

**🔗 LeetCode Link:** [3372. Maximize the Number of Target Nodes After Connecting Trees I](https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/)

---

## 🧩 Problem Description

<p>There exist two <strong>undirected </strong>trees with <code>n</code> and <code>m</code> nodes, with <strong>distinct</strong> labels in ranges <code>[0, n - 1]</code> and <code>[0, m - 1]</code>, respectively.</p>

<p>You are given two 2D integer arrays <code>edges1</code> and <code>edges2</code> of lengths <code>n - 1</code> and <code>m - 1</code>, respectively, where <code>edges1[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that there is an edge between nodes <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code> in the first tree and <code>edges2[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> indicates that there is an edge between nodes <code>u<sub>i</sub></code> and <code>v<sub>i</sub></code> in the second tree. You are also given an integer <code>k</code>.</p>

<p>Node <code>u</code> is <strong>target</strong> to node <code>v</code> if the number of edges on the path from <code>u</code> to <code>v</code> is less than or equal to <code>k</code>. <strong>Note</strong> that a node is <em>always</em> <strong>target</strong> to itself.</p>

<p>Return an array of <code>n</code> integers <code>answer</code>, where <code>answer[i]</code> is the <strong>maximum</strong> possible number of nodes <strong>target</strong> to node <code>i</code> of the first tree if you have to connect one node from the first tree to another node in the second tree.</p>

<p><strong>Note</strong> that queries are independent from each other. That is, for every query you will remove the added edge before proceeding to the next query.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Tree
- Depth-First Search
- Breadth-First Search
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]], k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">[9,7,9,8,8]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>For <code>i = 0</code>, connect node 0 from the first tree to node 0 from the second tree.</li>
	<li>For <code>i = 1</code>, connect node 1 from the first tree to node 0 from the second tree.</li>
	<li>For <code>i = 2</code>, connect node 2 from the first tree to node 4 from the second tree.</li>
	<li>For <code>i = 3</code>, connect node 3 from the first tree to node 4 from the second tree.</li>
	<li>For <code>i = 4</code>, connect node 4 from the first tree to node 4 from the second tree.</li>
</ul>
<img alt="" src="https://assets.leetcode.com/uploads/2024/09/24/3982-1.png" style="width: 600px; height: 169px;" /></div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]], k = 1</span></p>

<p><strong>Output:</strong> <span class="example-io">[6,3,3,3,3]</span></p>

<p><strong>Explanation:</strong></p>

<p>For every <code>i</code>, connect node <code>i</code> of the first tree with any node of the second tree.</p>
<img alt="" src="https://assets.leetcode.com/uploads/2024/09/24/3928-2.png" style="height: 281px; width: 500px;" /></div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n, m &lt;= 1000</code></li>
	<li><code>edges1.length == n - 1</code></li>
	<li><code>edges2.length == m - 1</code></li>
	<li><code>edges1[i].length == edges2[i].length == 2</code></li>
	<li><code>edges1[i] = [a<sub>i</sub>, b<sub>i</sub>]</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
	<li><code>edges2[i] = [u<sub>i</sub>, v<sub>i</sub>]</code></li>
	<li><code>0 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt; m</code></li>
	<li>The input is generated such that <code>edges1</code> and <code>edges2</code> represent valid trees.</li>
	<li><code>0 &lt;= k &lt;= 1000</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<Integer>[] g1 = buildGraph(edges1, n);
        List<Integer>[] g2 = buildGraph(edges2, m);
        if (k == 0) {
            int[] ans = new int[n];
            Arrays.fill(ans, 1);
            return ans;
        }
        int[] cnt1 = bfsCount(g1, k);
        int[] cnt2 = bfsCount(g2, k - 1);
        int best2 = 0;
        for (int x : cnt2) best2 = Math.max(best2, x);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = cnt1[i] + best2;
        }
        return ans;
    }

    private List<Integer>[] buildGraph(int[][] edges, int sz) {
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new List[sz];
        for (int i = 0; i < sz; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        return g;
    }

    private int[] bfsCount(List<Integer>[] g, int K) {
        int N = g.length;
        int[] result = new int[N], visited = new int[N];
        int stamp = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int start = 0; start < N; start++, stamp++) {
            if (K < 0) {
                result[start] = 1;
                continue;
            }
            queue.clear();
            queue.add(start);
            visited[start] = stamp;
            int level = 0, count = 1;
            while (!queue.isEmpty() && level < K) {
                int sz = queue.size();
                for (int i = 0; i < sz; i++) {
                    int u = queue.poll();
                    for (int v : g[u]) {
                        if (visited[v] != stamp) {
                            visited[v] = stamp;
                            queue.add(v);
                            count++;
                        }
                    }
                }
                level++;
            }
            result[start] = count;
        }
        return result;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]], k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">[9,7,9,8,8]</span></p>

<p><strong>Explanation:</strong></p>
<p><strong class="example">


