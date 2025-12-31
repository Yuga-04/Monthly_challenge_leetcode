# 📌 Day 16: 3562. Maximum Profit from Trading Stocks with Discounts 🎯

**🔗 LeetCode Link:** [3562. Maximum Profit from Trading Stocks with Discounts](https://leetcode.com/problems/maximum-profit-from-trading-stocks-with-discounts/)

---

## 🧩 Problem Description

<p>You are given an integer <code>n</code>, representing the number of employees in a company. Each employee is assigned a unique ID from 1 to <code>n</code>, and employee 1 is the CEO. You are given two <strong>1-based </strong>integer arrays, <code>present</code> and <code>future</code>, each of length <code>n</code>, where:</p>

<ul>
	<li><code>present[i]</code> represents the <strong>current</strong> price at which the <code>i<sup>th</sup></code> employee can buy a stock today.</li>
	<li><code>future[i]</code> represents the <strong>expected</strong> price at which the <code>i<sup>th</sup></code> employee can sell the stock tomorrow.</li>
</ul>

<p>The company&#39;s hierarchy is represented by a 2D integer array <code>hierarchy</code>, where <code>hierarchy[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> means that employee <code>u<sub>i</sub></code> is the direct boss of employee <code>v<sub>i</sub></code>.</p>

<p>Additionally, you have an integer <code>budget</code> representing the total funds available for investment.</p>

<p>However, the company has a discount policy: if an employee&#39;s direct boss purchases their own stock, then the employee can buy their stock at <strong>half</strong> the original price (<code>floor(present[v] / 2)</code>).</p>

<p>Return the <strong>maximum</strong> profit that can be achieved without exceeding the given budget.</p>

<p><strong>Note:</strong></p>

<ul>
	<li>You may buy each stock at most <strong>once</strong>.</li>
	<li>You <strong>cannot</strong> use any profit earned from future stock prices to fund additional investments and must buy only from <code>budget</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Dynamic Programming
- Tree
- Depth-First Search
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 2, present = [1,2], future = [4,3], hierarchy = [[1,2]], budget = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2025/04/09/screenshot-2025-04-10-at-053641.png" style="width: 200px; height: 80px;" /></p>

<ul>
	<li>Employee 1 buys the stock at price 1 and earns a profit of <code>4 - 1 = 3</code>.</li>
	<li>Since Employee 1 is the direct boss of Employee 2, Employee 2 gets a discounted price of <code>floor(2 / 2) = 1</code>.</li>
	<li>Employee 2 buys the stock at price 1 and earns a profit of <code>3 - 1 = 2</code>.</li>
	<li>The total buying cost is <code>1 + 1 = 2 &lt;= budget</code>. Thus, the maximum total profit achieved is <code>3 + 2 = 5</code>.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 2, present = [3,4], future = [5,8], hierarchy = [[1,2]], budget = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2025/04/09/screenshot-2025-04-10-at-053641.png" style="width: 200px; height: 80px;" /></p>

<ul>
	<li>Employee 2 buys the stock at price 4 and earns a profit of <code>8 - 4 = 4</code>.</li>
	<li>Since both employees cannot buy together, the maximum profit is 4.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 3, present = [4,6,8], future = [7,9,11], hierarchy = [[1,2],[1,3]], budget = 10</span></p>

<p><strong>Output:</strong> 10</p>

<p><strong>Explanation:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2025/04/09/image.png" style="width: 180px; height: 153px;" /></p>

<ul>
	<li>Employee 1 buys the stock at price 4 and earns a profit of <code>7 - 4 = 3</code>.</li>
	<li>Employee 3 would get a discounted price of <code>floor(8 / 2) = 4</code> and earns a profit of <code>11 - 4 = 7</code>.</li>
	<li>Employee 1 and Employee 3 buy their stocks at a total cost of <code>4 + 4 = 8 &lt;= budget</code>. Thus, the maximum total profit achieved is <code>3 + 7 = 10</code>.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 4

Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 3, present = [5,2,3], future = [8,5,6], hierarchy = [[1,2],[2,3]], budget = 7</span></p>

<p><strong>Output:</strong> <span class="example-io">12</span></p>

<p><strong>Explanation:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2025/04/09/screenshot-2025-04-10-at-054114.png" style="width: 300px; height: 85px;" /></p>

<ul>
	<li>Employee 1 buys the stock at price 5 and earns a profit of <code>8 - 5 = 3</code>.</li>
	<li>Employee 2 would get a discounted price of <code>floor(2 / 2) = 1</code> and earns a profit of <code>5 - 1 = 4</code>.</li>
	<li>Employee 3 would get a discounted price of <code>floor(3 / 2) = 1</code> and earns a profit of <code>6 - 1 = 5</code>.</li>
	<li>The total cost becomes <code>5 + 1 + 1 = 7&nbsp;&lt;= budget</code>. Thus, the maximum total profit achieved is <code>3 + 4 + 5 = 12</code>.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 160</code></li>
	<li><code>present.length, future.length == n</code></li>
	<li><code>1 &lt;= present[i], future[i] &lt;= 50</code></li>
	<li><code>hierarchy.length == n - 1</code></li>
	<li><code>hierarchy[i] == [u<sub>i</sub>, v<sub>i</sub>]</code></li>
	<li><code>1 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt;= n</code></li>
	<li><code>u<sub>i</sub> != v<sub>i</sub></code></li>
	<li><code>1 &lt;= budget &lt;= 160</code></li>
	<li>There are no duplicate edges.</li>
	<li>Employee 1 is the direct or indirect boss of every employee.</li>
	<li>The input graph <code>hierarchy </code>is <strong>guaranteed</strong> to have no cycles.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        // Build tree
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] edge : hierarchy) {
            tree[edge[0] - 1].add(edge[1] - 1);
        }

        int[][][] dp = new int[n][2][budget + 1];  // [node][parentBought][budget]
        dfs(0, present, future, tree, dp, budget);

        // Answer is the max profit in dp[0][0][b] for any b <= budget
        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[0][0][b]);
        }
        return ans;
    }

    private void dfs(int u, int[] present, int[] future, List<Integer>[] tree,
                            int[][][] dp, int budget) {
        // Base case: no children, init to 0
        for (int b = 0; b <= budget; b++) dp[u][0][b] = dp[u][1][b] = 0;

        // For each child, process recursively
        List<int[][]> childDPs = new ArrayList<>();
        for (int v : tree[u]) {
            dfs(v, present, future, tree, dp, budget);
            childDPs.add(new int[][]{dp[v][0], dp[v][1]});
        }

        // For parentNotBought and parentBought
        for (int parentBought = 0; parentBought <= 1; parentBought++) {
            int price = parentBought == 1 ? present[u] / 2 : present[u];
            int profit = future[u] - price;

            // Create DP array to fill for this u
            int[] curr = new int[budget + 1];

            // Option 1: don't buy u
            int[] base = new int[budget + 1];
            base[0] = 0;
            for (int[][] child : childDPs) {
                int[] next = new int[budget + 1];
                for (int b1 = 0; b1 <= budget; b1++) {
                    for (int b2 = 0; b1 + b2 <= budget; b2++) {
                        next[b1 + b2] = Math.max(next[b1 + b2], base[b1] + child[0][b2]);
                    }
                }
                base = next;
            }

            for (int b = 0; b <= budget; b++) {
                curr[b] = Math.max(curr[b], base[b]); // not buying u
            }

            // Option 2: buy u
            if (price <= budget) {
                int[] baseBuy = new int[budget + 1];
                baseBuy[0] = 0;
                for (int[][] child : childDPs) {
                    int[] next = new int[budget + 1];
                    for (int b1 = 0; b1 <= budget; b1++) {
                        for (int b2 = 0; b1 + b2 <= budget; b2++) {
                            next[b1 + b2] = Math.max(next[b1 + b2], baseBuy[b1] + child[1][b2]);
                        }
                    }
                    baseBuy = next;
                }

                for (int b = price; b <= budget; b++) {
                    curr[b] = Math.max(curr[b], baseBuy[b - price] + profit);
                }
            }

            dp[u][parentBought] = curr;
        }
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 2, present = [1,2], future = [4,3], hierarchy = [[1,2]], budget = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">5</span></p>

<p><strong>Explanation:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2025/04/09/screenshot-2025-04-10-at-053641.png" style="width: 200px; height: 80px;" /></p>

<ul>
	<li>Employee 1 buys the stock at price 1 and earns a profit of <code>4 - 1 = 3</code>.</li>
	<li>Since Employee 1 is the direct boss of Employee 2, Employee 2 gets a discounted price of <code>floor(2 / 2) = 1</code>.</li>
	<li>Employee 2 buys the stock at price 1 and earns a profit of <code>3 - 1 = 2</code>.</li>
	<li>The total buying cost is <code>1 + 1 = 2 &lt;= budget</code>. Thus, the maximum total profit achieved is <code>3 + 2 = 5</code>.</li>
</ul>
</div>

<p><strong class="example">


