# 📌 Day 3: 3027. Find the Number of Ways to Place People II 🎯

**🔗 LeetCode Link:** [3027. Find the Number of Ways to Place People II](https://leetcode.com/problems/find-the-number-of-ways-to-place-people-ii/)

---

## 🧩 Problem Description

<p>You are given a 2D array <code>points</code> of size <code>n x 2</code> representing integer coordinates of some points on a 2D-plane, where <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>.</p>

<p>We define the <strong>right</strong> direction as positive x-axis (<strong>increasing x-coordinate</strong>) and the <strong>left</strong> direction as negative x-axis (<strong>decreasing x-coordinate</strong>). Similarly, we define the <strong>up</strong> direction as positive y-axis (<strong>increasing y-coordinate</strong>) and the <strong>down</strong> direction as negative y-axis (<strong>decreasing y-coordinate</strong>)</p>

<p>You have to place <code>n</code> people, including Alice and Bob, at these points such that there is <strong>exactly one</strong> person at every point. Alice wants to be alone with Bob, so Alice will build a rectangular fence with Alice&#39;s position as the <strong>upper left corner</strong> and Bob&#39;s position as the <strong>lower right corner</strong> of the fence (<strong>Note</strong> that the fence <strong>might not</strong> enclose any area, i.e. it can be a line). If any person other than Alice and Bob is either <strong>inside</strong> the fence or <strong>on</strong> the fence, Alice will be sad.</p>

<p>Return <em>the number of <strong>pairs of points</strong> where you can place Alice and Bob, such that Alice <strong>does not</strong> become sad on building the fence</em>.</p>

<p><strong>Note</strong> that Alice can only build a fence with Alice&#39;s position as the upper left corner, and Bob&#39;s position as the lower right corner. For example, Alice cannot build either of the fences in the picture below with four corners <code>(1, 1)</code>, <code>(1, 3)</code>, <code>(3, 1)</code>, and <code>(3, 3)</code>, because:</p>

<ul>
	<li>With Alice at <code>(3, 3)</code> and Bob at <code>(1, 1)</code>, Alice&#39;s position is not the upper left corner and Bob&#39;s position is not the lower right corner of the fence.</li>
	<li>With Alice at <code>(1, 3)</code> and Bob at <code>(1, 1)</code>, Bob&#39;s position is not the lower right corner of the fence.</li>
</ul>
![Image](https://assets.leetcode.com/uploads/2024/01/04/example0alicebob-1.png)
<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Math
- Geometry
- Sorting
- Enumeration
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2024/01/04/example1alicebob.png" style="width: 376px; height: 308px; padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem;" />
<pre>
<strong>Input:</strong> points = [[1,1],[2,2],[3,3]]
<strong>Output:</strong> 0
<strong>Explanation:</strong> There is no way to place Alice and Bob such that Alice can build a fence with Alice&#39;s position as the upper left corner and Bob&#39;s position as the lower right corner. Hence we return 0. 
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2024/02/04/example2alicebob.png" style="width: 1321px; height: 363px; padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem;" />
<pre>
<strong>Input:</strong> points = [[6,2],[4,4],[2,6]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are two ways to place Alice and Bob such that Alice will not be sad:
- Place Alice at (4, 4) and Bob at (6, 2).
- Place Alice at (2, 6) and Bob at (4, 4).
You cannot place Alice at (2, 6) and Bob at (6, 2) because the person at (4, 4) will be inside the fence.
</pre>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2024/02/04/example4alicebob.png" style="width: 1123px; height: 308px; padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem;" />
<pre>
<strong>Input:</strong> points = [[3,1],[1,3],[1,1]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are two ways to place Alice and Bob such that Alice will not be sad:
- Place Alice at (1, 1) and Bob at (3, 1).
- Place Alice at (1, 3) and Bob at (1, 1).
You cannot place Alice at (1, 3) and Bob at (3, 1) because the person at (1, 1) will be on the fence.
Note that it does not matter if the fence encloses any area, the first and second fences in the image are valid.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 1000</code></li>
	<li><code>points[i].length == 2</code></li>
	<li><code>-10<sup>9</sup> &lt;= points[i][0], points[i][1] &lt;= 10<sup>9</sup></code></li>
	<li>All <code>points[i]</code> are distinct.</li>
</ul>

---

## ✅ Code (Java)

```java
import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        // Step 1: Sort points by x ascending, then by y descending
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]); // y descending
            }
            return Integer.compare(a[0], b[0]); // x ascending
        });

        int pairCount = 0;
        int n = points.length;

        // Step 2: Iterate through all points as potential "upper-left" points
        for (int i = 0; i < n; i++) {
            int upperY = points[i][1];   
            int lowerYLimit = Integer.MIN_VALUE;

            // Step 3: Check subsequent points as potential "bottom-right" points
            for (int j = i + 1; j < n; j++) {
                int currentY = points[j][1];

                // Valid pair if currentY is below upperY and above previous lowerYLimit
                if (currentY <= upperY && currentY > lowerYLimit) {
                    pairCount++;
                    lowerYLimit = currentY;

                    // Once we reach the same y as upperY, no more valid points possible
                    if (currentY == upperY) break;
                }
            }
        }

        return pairCount;
    }
}

```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2024/01/04/example1alicebob.png" style="width: 376px; height: 308px; padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem;" />
<pre>
<strong>Input:</strong> points = [[1,1],[2,2],[3,3]]
<strong>Output:</strong> 0
</pre>

<p><strong class="example">


