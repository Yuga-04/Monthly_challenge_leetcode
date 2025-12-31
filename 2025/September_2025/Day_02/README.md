# 📌 Day 2: 3025. Find the Number of Ways to Place People I 🎯

**🔗 LeetCode Link:** [3025. Find the Number of Ways to Place People I](https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i/)

---

## 🧩 Problem Description

<p>You are given a 2D array <code>points</code> of size <code>n x 2</code> representing integer coordinates of some points on a 2D plane, where <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>.</p>

<p>Count the number of pairs of points <code>(A, B)</code>, where</p>

<ul>
	<li><code>A</code> is on the <strong>upper left</strong> side of <code>B</code>, and</li>
	<li>there are no other points in the rectangle (or line) they make (<strong>including the border</strong>).</li>
</ul>

<p>Return the count.</p>

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

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">points = [[1,1],[2,2],[3,3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2024/01/04/example1alicebob.png" style="width: 427px; height: 350px;" /></p>

<p>There is no way to choose <code>A</code> and <code>B</code> so <code>A</code> is on the upper left side of <code>B</code>.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">points = [[6,2],[4,4],[2,6]]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p><img height="365" src="https://assets.leetcode.com/uploads/2024/06/25/t2.jpg" width="1321" /></p>

<ul>
	<li>The left one is the pair <code>(points[1], points[0])</code>, where <code>points[1]</code> is on the upper left side of <code>points[0]</code> and the rectangle is empty.</li>
	<li>The middle one is the pair <code>(points[2], points[1])</code>, same as the left one it is a valid pair.</li>
	<li>The right one is the pair <code>(points[2], points[0])</code>, where <code>points[2]</code> is on the upper left side of <code>points[0]</code>, but <code>points[1]</code> is inside the rectangle so it&#39;s not a valid pair.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">points = [[3,1],[1,3],[1,1]]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2024/06/25/t3.jpg" style="width: 1269px; height: 350px;" /></p>

<ul>
	<li>The left one is the pair <code>(points[2], points[0])</code>, where <code>points[2]</code> is on the upper left side of <code>points[0]</code> and there are no other points on the line they form. Note that it is a valid state when the two points form a line.</li>
	<li>The middle one is the pair <code>(points[1], points[2])</code>, it is a valid pair same as the left one.</li>
	<li>The right one is the pair <code>(points[1], points[0])</code>, it is not a valid pair as <code>points[2]</code> is on the border of the rectangle.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 50</code></li>
	<li><code>points[i].length == 2</code></li>
	<li><code>0 &lt;= points[i][0], points[i][1] &lt;= 50</code></li>
	<li>All <code>points[i]</code> are distinct.</li>
</ul>

---

## ✅ Code (Java)

```java
import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        // Sort by x ascending, y descending
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        int n = points.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int top = points[i][1];
            int bot = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                int y = points[j][1];
                if (bot < y && y <= top) {
                    result++;
                    bot = y;
                    if (bot == top) break;
                }
            }
        }

        return result;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">points = [[1,1],[2,2],[3,3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><img src="https://assets.leetcode.com/uploads/2024/01/04/example1alicebob.png" style="width: 427px; height: 350px;" /></p>

<p>There is no way to choose <code>A</code> and <code>B</code> so <code>A</code> is on the upper left side of <code>B</code>.</p>
</div>

<p><strong class="example">


