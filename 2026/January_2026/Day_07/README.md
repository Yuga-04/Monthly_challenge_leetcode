# 📌 Day 7: 1339. Maximum Product of Splitted Binary Tree 🎯

**🔗 LeetCode Link:** [1339. Maximum Product of Splitted Binary Tree](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/)

---

## 🧩 Problem Description

<p>Given the <code>root</code> of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.</p>

<p>Return <em>the maximum product of the sums of the two subtrees</em>. Since the answer may be too large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p><strong>Note</strong> that you need to maximize the answer before taking the mod and not after taking it.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Tree
- Depth-First Search
- Binary Tree
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/01/21/sample_1_1699.png" style="width: 500px; height: 167px;" />
<pre>
<strong>Input:</strong> root = [1,2,3,4,5,6]
<strong>Output:</strong> 110
<strong>Explanation:</strong> Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/01/21/sample_2_1699.png" style="width: 500px; height: 211px;" />
<pre>
<strong>Input:</strong> root = [1,null,2,3,4,null,null,5,6]
<strong>Output:</strong> 90
<strong>Explanation:</strong> Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[2, 5 * 10<sup>4</sup>]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    static final int MOD = 1_000_000_007;
    long totalSum = 0;
    long maxProduct = 0;

    // First DFS: compute total tree sum
    long getTotalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val 
             + getTotalSum(root.left) 
             + getTotalSum(root.right);
    }

    // Second DFS (postorder): compute subtree sums
    long dfs(TreeNode root) {
        if (root == null) return 0;

        // Get sums of left and right subtrees
        long left = dfs(root.left);
        long right = dfs(root.right);

        // Current subtree sum
        long subSum = root.val + left + right;

        // Try splitting above this node
        long product = subSum * (totalSum - subSum);
        maxProduct = Math.max(maxProduct, product);

        return subSum;
    }

    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root); // O(n)
        dfs(root);                    // O(n)
        return (int)(maxProduct % MOD);
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/01/21/sample_1_1699.png" style="width: 500px; height: 167px;" />
<pre>
<strong>Input:</strong> root = [1,2,3,4,5,6]
<strong>Output:</strong> 110
<strong>Explanation:</strong> Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
</pre>

<p><strong class="example">


