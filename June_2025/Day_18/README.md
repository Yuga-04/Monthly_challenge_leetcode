# 📌 Day 18: 2966. Divide Array Into Arrays With Max Difference 🎯

**🔗 LeetCode Link:** [2966. Divide Array Into Arrays With Max Difference](https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/)

---

## 🧩 Problem Description

<p>You are given an integer array <code>nums</code> of size <code>n</code> where <code>n</code> is a multiple of 3 and a positive integer <code>k</code>.</p>

<p>Divide the array <code>nums</code> into <code>n / 3</code> arrays of size <strong>3</strong> satisfying the following condition:</p>

<ul>
	<li>The difference between <strong>any</strong> two elements in one array is <strong>less than or equal</strong> to <code>k</code>.</li>
</ul>

<p>Return a <strong>2D</strong> array containing the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return <strong>any</strong> of them.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Greedy
- Sorting
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,3,4,8,7,9,3,5,1], k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">[[1,1,3],[3,4,5],[7,8,9]]</span></p>

<p><strong>Explanation:</strong></p>

<p>The difference between any two elements in each array is less than or equal to 2.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,4,2,2,5,2], k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">[]</span></p>

<p><strong>Explanation:</strong></p>

<p>Different ways to divide <code>nums</code> into 2 arrays of size 3 are:</p>

<ul>
	<li>[[2,2,2],[2,4,5]] (and its permutations)</li>
	<li>[[2,2,4],[2,2,5]] (and its permutations)</li>
</ul>

<p>Because there are four 2s there will be an array with the elements 2 and 5 no matter how we divide it. since <code>5 - 2 = 3 &gt; k</code>, the condition is not satisfied and so there is no valid division.</p>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11], k = 14</span></p>

<p><strong>Output:</strong> <span class="example-io">[[2,2,12],[4,8,5],[5,9,7],[7,8,5],[5,9,10],[11,12,2]]</span></p>

<p><strong>Explanation:</strong></p>

<p>The difference between any two elements in each array is less than or equal to 14.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>n </code>is a multiple of 3</li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        int [][]grid=new int [n/3][3];
        
        // Sort the input array so we can group close values together
        Arrays.sort(nums);
        
        int v=0;

        // Fill the grid with consecutive triplets from the sorted array
        for(int i=0;i<n/3;i++){
            for(int j=0;j<3;j++){
                grid[i][j]=nums[v++];
            }
        }

        // Check each group to ensure max - min <= k
        for(int i=0;i<n/3;i++){
            int x=grid[i][0],y=grid[i][1],z=grid[i][2];
            if((z-x)>k){
                // If any group's range exceeds k, return empty result
                return new int[0][0];
            }
        }

        // All groups are valid
        return grid;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,3,4,8,7,9,3,5,1], k = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">[[1,1,3],[3,4,5],[7,8,9]]</span></p>

</div>

<p><strong class="example">


