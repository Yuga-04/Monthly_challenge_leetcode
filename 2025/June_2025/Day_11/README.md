# 📌 Day 11: 3445. Maximum Difference Between Even and Odd Frequency II 🎯

**🔗 LeetCode Link:** [3445. Maximum Difference Between Even and Odd Frequency II](https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-ii/)

---

## 🧩 Problem Description

<p>You are given a string <code>s</code> and an integer <code>k</code>. Your task is to find the <strong>maximum</strong> difference between the frequency of <strong>two</strong> characters, <code>freq[a] - freq[b]</code>, in a <span data-keyword="substring">substring</span> <code>subs</code> of <code>s</code>, such that:</p>

<ul>
	<li><code>subs</code> has a size of <strong>at least</strong> <code>k</code>.</li>
	<li>Character <code>a</code> has an <em>odd frequency</em> in <code>subs</code>.</li>
	<li>Character <code>b</code> has an <em>even frequency</em> in <code>subs</code>.</li>
</ul>

<p>Return the <strong>maximum</strong> difference.</p>

<p><strong>Note</strong> that <code>subs</code> can contain more than 2 <strong>distinct</strong> characters.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- String
- Sliding Window
- Enumeration
- Prefix Sum
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;12233&quot;, k = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>

<p><strong>Explanation:</strong></p>

<p>For the substring <code>&quot;12233&quot;</code>, the frequency of <code>&#39;1&#39;</code> is 1 and the frequency of <code>&#39;3&#39;</code> is 2. The difference is <code>1 - 2 = -1</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;1122211&quot;, k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>For the substring <code>&quot;11222&quot;</code>, the frequency of <code>&#39;2&#39;</code> is 3 and the frequency of <code>&#39;1&#39;</code> is 2. The difference is <code>3 - 2 = 1</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;110&quot;, k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= s.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>s</code> consists only of digits <code>&#39;0&#39;</code> to <code>&#39;4&#39;</code>.</li>
	<li>The input is generated that at least one substring has a character with an even frequency and a character with an odd frequency.</li>
	<li><code>1 &lt;= k &lt;= s.length</code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    static class FenwickTree {
        int n;
        int[] tree;
        static final int INF = Integer.MAX_VALUE;

        FenwickTree(int n) {
            this.n = n;
            tree = new int[n + 1];
            Arrays.fill(tree, INF);
        }

        void update(int i, int val) {
            for (int pos = i + 1; pos <= n; pos += pos & -pos) {
                tree[pos] = Math.min(tree[pos], val);
            }
        }

        int query(int i) {
            int res = INF;
            for (int pos = i + 1; pos > 0; pos -= pos & -pos) {
                res = Math.min(res, tree[pos]);
            }
            return res;
        }
    }

    public static int maxDifference(String s, int k) {
        int n = s.length(), ans = Integer.MIN_VALUE;

        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                if (a == b) continue;

                int[] D = new int[n + 1];
                int[] pa = new int[n + 1];
                int[] pb = new int[n + 1];
                int[] countB = new int[n + 1];

                D[0] = 0;
                pa[0] = 0;
                pb[0] = 0;
                countB[0] = 0;

                for (int i = 1; i <= n; i++) {
                    int digit = s.charAt(i - 1) - '0';
                    D[i] = D[i - 1] + ((digit == a) ? 1 : 0) - ((digit == b) ? 1 : 0);
                    pa[i] = (pa[i - 1] + ((digit == a) ? 1 : 0)) & 1;
                    pb[i] = (pb[i - 1] + ((digit == b) ? 1 : 0)) & 1;
                    countB[i] = countB[i - 1] + ((digit == b) ? 1 : 0);
                }

                int size = n + 1;
                FenwickTree[][] trees = new FenwickTree[2][2];

                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        trees[i][j] = new FenwickTree(size);
                    }
                }

                for (int j = 0; j <= n; j++) {
                    if (j >= k) {
                        int idx = j - k;
                        trees[pa[idx]][pb[idx]].update(countB[idx], D[idx]);
                    }

                    if (j > 0) {
                        int needP = 1 - pa[j];
                        int needQ = pb[j];

                        if (countB[j] > 0) {
                            int bestVal = trees[needP][needQ].query(countB[j] - 1);
                            if (bestVal != FenwickTree.INF) {
                                ans = Math.max(ans, D[j] - bestVal);
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;12233&quot;, k = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>

</div>

<p><strong class="example">


