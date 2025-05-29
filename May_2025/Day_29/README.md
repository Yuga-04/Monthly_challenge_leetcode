# 📌 Day 29: 3373. Maximize the Number of Target Nodes After Connecting Trees II 🎯

**🔗 LeetCode Link:** [3373. Maximize the Number of Target Nodes After Connecting Trees II](https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/)

---

## 🧩 Problem Description

<p>There exist two <strong>undirected </strong>trees with <code>n</code> and <code>m</code> nodes, labeled from <code>[0, n - 1]</code> and <code>[0, m - 1]</code>, respectively.</p>

<p>You are given two 2D integer arrays <code>edges1</code> and <code>edges2</code> of lengths <code>n - 1</code> and <code>m - 1</code>, respectively, where <code>edges1[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that there is an edge between nodes <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code> in the first tree and <code>edges2[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> indicates that there is an edge between nodes <code>u<sub>i</sub></code> and <code>v<sub>i</sub></code> in the second tree.</p>

<p>Node <code>u</code> is <strong>target</strong> to node <code>v</code> if the number of edges on the path from <code>u</code> to <code>v</code> is even.&nbsp;<strong>Note</strong> that a node is <em>always</em> <strong>target</strong> to itself.</p>

<p>Return an array of <code>n</code> integers <code>answer</code>, where <code>answer[i]</code> is the <strong>maximum</strong> possible number of nodes that are <strong>target</strong> to node <code>i</code> of the first tree if you had to connect one node from the first tree to another node in the second tree.</p>

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
<p><strong>Input:</strong> <span class="example-io">edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[8,7,7,8,8]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>For <code>i = 0</code>, connect node 0 from the first tree to node 0 from the second tree.</li>
	<li>For <code>i = 1</code>, connect node 1 from the first tree to node 4 from the second tree.</li>
	<li>For <code>i = 2</code>, connect node 2 from the first tree to node 7 from the second tree.</li>
	<li>For <code>i = 3</code>, connect node 3 from the first tree to node 0 from the second tree.</li>
	<li>For <code>i = 4</code>, connect node 4 from the first tree to node 4 from the second tree.</li>
</ul>
<img alt="" src="https://assets.leetcode.com/uploads/2024/09/24/3982-1.png" style="width: 600px; height: 169px;" /></div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[3,6,6,6,6]</span></p>

<p><strong>Explanation:</strong></p>

<p>For every <code>i</code>, connect node <code>i</code> of the first tree with any node of the second tree.</p>
<img alt="" src="https://assets.leetcode.com/uploads/2024/09/24/3928-2.png" style="height: 281px; width: 500px;" /></div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n, m &lt;= 10<sup>5</sup></code></li>
	<li><code>edges1.length == n - 1</code></li>
	<li><code>edges2.length == m - 1</code></li>
	<li><code>edges1[i].length == edges2[i].length == 2</code></li>
	<li><code>edges1[i] = [a<sub>i</sub>, b<sub>i</sub>]</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
	<li><code>edges2[i] = [u<sub>i</sub>, v<sub>i</sub>]</code></li>
	<li><code>0 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt; m</code></li>
	<li>The input is generated such that <code>edges1</code> and <code>edges2</code> represent valid trees.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    int evenA, oddA, evenB, oddB;
    List<List<Integer>> buildList(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }
    void dfsColor(List<List<Integer>> adj, int u, int parent, int[] color, boolean isA) {
        if (color[u] == 0) {
            if (isA) evenA++;
            else evenB++;
        } else {
            if (isA) oddA++;
            else oddB++;
        }
        for (int v : adj.get(u)) if (v != parent) {
            color[v] = color[u] ^ 1;
            dfsColor(adj, v, u, color, isA);
        }
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        List<List<Integer>> adjA = buildList(edges1), adjB = buildList(edges2);
        int n = adjA.size(), m = adjB.size();
        int[] colorA = new int[n], colorB = new int[m];
        Arrays.fill(colorA, -1);
        Arrays.fill(colorB, -1);
        evenA = oddA = evenB = oddB = 0;
        colorA[0] = 0;
        dfsColor(adjA, 0, -1, colorA, true);
        colorB[0] = 0;
        dfsColor(adjB, 0, -1, colorB, false);
        int maxiB = Math.max(evenB, oddB);
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = (colorA[i] == 0 ? evenA : oddA) + maxiB;
        return res;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[8,7,7,8,8]</span></p>
<p><strong class="example">


