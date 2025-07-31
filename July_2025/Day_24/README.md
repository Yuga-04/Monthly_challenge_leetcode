# 📌 Day 24: 2322. Minimum Score After Removals on a Tree 🎯

**🔗 LeetCode Link:** [2322. Minimum Score After Removals on a Tree](https://leetcode.com/problems/minimum-score-after-removals-on-a-tree/)

---

## 🧩 Problem Description

<p>There is an undirected connected tree with <code>n</code> nodes labeled from <code>0</code> to <code>n - 1</code> and <code>n - 1</code> edges.</p>

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> of length <code>n</code> where <code>nums[i]</code> represents the value of the <code>i<sup>th</sup></code> node. You are also given a 2D integer array <code>edges</code> of length <code>n - 1</code> where <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that there is an edge between nodes <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code> in the tree.</p>

<p>Remove two <strong>distinct</strong> edges of the tree to form three connected components. For a pair of removed edges, the following steps are defined:</p>

<ol>
	<li>Get the XOR of all the values of the nodes for <strong>each</strong> of the three components respectively.</li>
	<li>The <strong>difference</strong> between the <strong>largest</strong> XOR value and the <strong>smallest</strong> XOR value is the <strong>score</strong> of the pair.</li>
</ol>

<ul>
	<li>For example, say the three components have the node values: <code>[4,5,7]</code>, <code>[1,9]</code>, and <code>[3,3,3]</code>. The three XOR values are <code>4 ^ 5 ^ 7 = <u><strong>6</strong></u></code>, <code>1 ^ 9 = <u><strong>8</strong></u></code>, and <code>3 ^ 3 ^ 3 = <u><strong>3</strong></u></code>. The largest XOR value is <code>8</code> and the smallest XOR value is <code>3</code>. The score is then <code>8 - 3 = 5</code>.</li>
</ul>

<p>Return <em>the <strong>minimum</strong> score of any possible pair of edge removals on the given tree</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Bit Manipulation
- Tree
- Depth-First Search
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/05/03/ex1drawio.png" style="width: 193px; height: 190px;" />
<pre>
<strong>Input:</strong> nums = [1,5,5,4,11], edges = [[0,1],[1,2],[1,3],[3,4]]
<strong>Output:</strong> 9
<strong>Explanation:</strong> The diagram above shows a way to make a pair of removals.
- The 1<sup>st</sup> component has nodes [1,3,4] with values [5,4,11]. Its XOR value is 5 ^ 4 ^ 11 = 10.
- The 2<sup>nd</sup> component has node [0] with value [1]. Its XOR value is 1 = 1.
- The 3<sup>rd</sup> component has node [2] with value [5]. Its XOR value is 5 = 5.
The score is the difference between the largest and smallest XOR value which is 10 - 1 = 9.
It can be shown that no other pair of removals will obtain a smaller score than 9.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/05/03/ex2drawio.png" style="width: 287px; height: 150px;" />
<pre>
<strong>Input:</strong> nums = [5,5,2,4,4,2], edges = [[0,1],[1,2],[5,2],[4,3],[1,3]]
<strong>Output:</strong> 0
<strong>Explanation:</strong> The diagram above shows a way to make a pair of removals.
- The 1<sup>st</sup> component has nodes [3,4] with values [4,4]. Its XOR value is 4 ^ 4 = 0.
- The 2<sup>nd</sup> component has nodes [1,0] with values [5,5]. Its XOR value is 5 ^ 5 = 0.
- The 3<sup>rd</sup> component has nodes [2,5] with values [2,2]. Its XOR value is 2 ^ 2 = 0.
The score is the difference between the largest and smallest XOR value which is 0 - 0 = 0.
We cannot obtain a smaller score than 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>3 &lt;= n &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>8</sup></code></li>
	<li><code>edges.length == n - 1</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li>
	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
	<li><code>edges</code> represents a valid tree.</li>
</ul>

---

## ✅ Code (Java)

```java
import java.util.*;

class Solution {
    private int[] subtreeXor;
    private Set<Integer>[] descendants;
    private List<Integer>[] graph;

    private void dfs(int node, int parent, int[] nums) {
        subtreeXor[node] = nums[node];
        descendants[node].add(node);

        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                dfs(neighbor, node, nums);
                subtreeXor[node] ^= subtreeXor[neighbor];
                descendants[node].addAll(descendants[neighbor]);
            }
        }
    }

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        subtreeXor = new int[n];
        descendants = new HashSet[n];
        for (int i = 0; i < n; i++) {
            descendants[i] = new HashSet<>();
        }

        dfs(0, -1, nums);

        int totalXor = subtreeXor[0];
        int minScore = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xorI = subtreeXor[i];
                int xorJ = subtreeXor[j];
                int val1, val2, val3;

                if (descendants[i].contains(j)) {
                    val1 = xorJ;
                    val2 = xorI ^ xorJ;
                    val3 = totalXor ^ xorI;
                } else if (descendants[j].contains(i)) {
                    val1 = xorI;
                    val2 = xorJ ^ xorI;
                    val3 = totalXor ^ xorJ;
                } else {
                    val1 = xorI;
                    val2 = xorJ;
                    val3 = totalXor ^ xorI ^ xorJ;
                }
                
                int maxVal = Math.max(val1, Math.max(val2, val3));
                int minVal = Math.min(val1, Math.min(val2, val3));
                minScore = Math.min(minScore, maxVal - minVal);
            }
        }

        return minScore;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/05/03/ex1drawio.png" style="width: 193px; height: 190px;" />
<pre>
<strong>Input:</strong> nums = [1,5,5,4,11], edges = [[0,1],[1,2],[1,3],[3,4]]
<strong>Output:</strong> 9
</pre>

<p><strong class="example">


