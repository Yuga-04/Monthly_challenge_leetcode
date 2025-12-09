# 📌 Day 9: 3583. Count Special Triplets 🎯

**🔗 LeetCode Link:** [3583. Count Special Triplets](https://leetcode.com/problems/count-special-triplets/)

---

## 🧩 Problem Description

<p>You are given an integer array <code>nums</code>.</p>

<p>A <strong>special triplet</strong> is defined as a triplet of indices <code>(i, j, k)</code> such that:</p>

<ul>
	<li><code>0 &lt;= i &lt; j &lt; k &lt; n</code>, where <code>n = nums.length</code></li>
	<li><code>nums[i] == nums[j] * 2</code></li>
	<li><code>nums[k] == nums[j] * 2</code></li>
</ul>

<p>Return the total number of <strong>special triplets</strong> in the array.</p>

<p>Since the answer may be large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- Counting
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [6,3,6]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>The only special triplet is <code>(i, j, k) = (0, 1, 2)</code>, where:</p>

<ul>
	<li><code>nums[0] = 6</code>, <code>nums[1] = 3</code>, <code>nums[2] = 6</code></li>
	<li><code>nums[0] = nums[1] * 2 = 3 * 2 = 6</code></li>
	<li><code>nums[2] = nums[1] * 2 = 3 * 2 = 6</code></li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [0,1,0,0]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>The only special triplet is <code>(i, j, k) = (0, 2, 3)</code>, where:</p>

<ul>
	<li><code>nums[0] = 0</code>, <code>nums[2] = 0</code>, <code>nums[3] = 0</code></li>
	<li><code>nums[0] = nums[2] * 2 = 0 * 2 = 0</code></li>
	<li><code>nums[3] = nums[2] * 2 = 0 * 2 = 0</code></li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [8,4,2,8,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>There are exactly two special triplets:</p>

<ul>
	<li><code>(i, j, k) = (0, 1, 3)</code>

	<ul>
		<li><code>nums[0] = 8</code>, <code>nums[1] = 4</code>, <code>nums[3] = 8</code></li>
		<li><code>nums[0] = nums[1] * 2 = 4 * 2 = 8</code></li>
		<li><code>nums[3] = nums[1] * 2 = 4 * 2 = 8</code></li>
	</ul>
	</li>
	<li><code>(i, j, k) = (1, 2, 4)</code>
	<ul>
		<li><code>nums[1] = 4</code>, <code>nums[2] = 2</code>, <code>nums[4] = 4</code></li>
		<li><code>nums[1] = nums[2] * 2 = 2 * 2 = 4</code></li>
		<li><code>nums[4] = nums[2] * 2 = 2 * 2 = 4</code></li>
	</ul>
	</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= n == nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int specialTriplets(int[] nums) {
        long count = 0;
        int MOD = 1_000_000_007;
        
        // Since constraints say nums[i] <= 10^5, we can use arrays instead of HashMap for speed
        int[] leftFreq = new int[200001]; 
        int[] rightFreq = new int[200001];
        
        // Initialize rightFreq with all elements
        for (int num : nums) {
            rightFreq[num]++;
        }
        
        for (int num : nums) {
            // Remove current element from right (it's the center 'j' now)
            rightFreq[num]--;
            
            // Check for valid 'i' and 'k' values (target = num * 2)
            long target = (long)num * 2;
            if (target <= 200000) {
                long leftCount = leftFreq[(int)target];
                long rightCount = rightFreq[(int)target];
                
                count = (count + leftCount * rightCount) % MOD;
            }
            
            // Add current element to left (it will be on left for next iteration)
            leftFreq[num]++;
        }
        
        return (int) count;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [6,3,6]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>The only special triplet is <code>(i, j, k) = (0, 1, 2)</code>, where:</p>

<ul>
	<li><code>nums[0] = 6</code>, <code>nums[1] = 3</code>, <code>nums[2] = 6</code></li>
	<li><code>nums[0] = nums[1] * 2 = 3 * 2 = 6</code></li>
	<li><code>nums[2] = nums[1] * 2 = 3 * 2 = 6</code></li>
</ul>
</div>

<p><strong class="example">


