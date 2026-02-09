# 📌 Day 9: 1382. Balance a Binary Search Tree 🎯

**🔗 LeetCode Link:** [1382. Balance a Binary Search Tree](https://leetcode.com/problems/balance-a-binary-search-tree/)

---

## 🧩 Problem Description

<p>Given the <code>root</code> of a binary search tree, return <em>a <strong>balanced</strong> binary search tree with the same node values</em>. If there is more than one answer, return <strong>any of them</strong>.</p>

<p>A binary search tree is <strong>balanced</strong> if the depth of the two subtrees of every node never differs by more than <code>1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Divide and Conquer
- Greedy
- Tree
- Depth-First Search
- Binary Search Tree
- Binary Tree
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/10/balance1-tree.jpg" style="width: 500px; height: 319px;" />
<pre>
<strong>Input:</strong> root = [1,null,2,null,3,null,4,null,null]
<strong>Output:</strong> [2,1,3,null,null,null,4]
<b>Explanation:</b> This is not the only correct answer, [3,1,4,null,2] is also correct.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/10/balanced2-tree.jpg" style="width: 224px; height: 145px;" />
<pre>
<strong>Input:</strong> root = [2,1,3]
<strong>Output:</strong> [2,1,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    List<Integer> nums;
    public TreeNode balanceBST(TreeNode root) {
        nums = new ArrayList<Integer>();
        getNumbers(root);
        TreeNode res = balanceTree(0,nums.size()-1);
        return res;
    }
    private void getNumbers(TreeNode node){
        if(node==null) return;
        getNumbers(node.left);
        nums.add(node.val);
        getNumbers(node.right);
    }
    private TreeNode balanceTree(int l, int r){
        if(l>r)return null;
        int middleIdx = l+ ((r-l)/2);
        TreeNode res = new TreeNode(nums.get(middleIdx));
        res.left = balanceTree(l,middleIdx-1);
        res.right = balanceTree(middleIdx+1,r);
        return res;
    }              
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/08/10/balance1-tree.jpg" style="width: 500px; height: 319px;" />
<pre>
<strong>Input:</strong> root = [1,null,2,null,3,null,4,null,null]
<strong>Output:</strong> [2,1,3,null,null,null,4]
<b>Explanation:</b> This is not the only correct answer, [3,1,4,null,2] is also correct.
</pre>

<p><strong class="example">


