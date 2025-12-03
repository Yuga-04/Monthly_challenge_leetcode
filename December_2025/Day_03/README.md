# 📌 Day 3: 3625. Count Number of Trapezoids II 🎯

**🔗 LeetCode Link:** [3625. Count Number of Trapezoids II](https://leetcode.com/problems/count-number-of-trapezoids-ii/)

---

## 🧩 Problem Description

<p data-end="189" data-start="146">You are given a 2D integer array <code>points</code> where <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code> represents the coordinates of the <code>i<sup>th</sup></code> point on the Cartesian plane.</p>

<p data-end="189" data-start="146">Return <em data-end="330" data-start="297">the number of unique </em><em>trapezoids</em> that can be formed by choosing any four distinct points from <code>points</code>.</p>

<p data-end="579" data-start="405">A<b> </b><strong>trapezoid</strong> is a convex quadrilateral with <strong data-end="496" data-start="475">at least one pair</strong> of parallel sides. Two lines are parallel if and only if they have the same slope.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- Math
- Geometry
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">points = [[-3,2],[3,0],[2,3],[3,2],[2,-3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-4.png" style="width: 250px; height: 250px;" /> <img alt="" src="https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-3.png" style="width: 250px; height: 250px;" /></p>

<p>There are two distinct ways to pick four points that form a trapezoid:</p>

<ul>
	<li>The points <code>[-3,2], [2,3], [3,2], [2,-3]</code> form one trapezoid.</li>
	<li>The points <code>[2,3], [3,2], [3,0], [2,-3]</code> form another trapezoid.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">points = [[0,0],[1,0],[0,1],[2,1]]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-5.png" style="width: 250px; height: 250px;" /></p>

<p>There is only one trapezoid which can be formed.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>4 &lt;= points.length &lt;= 500</code></li>
	<li><code>&ndash;1000 &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 1000</code></li>
	<li>All points are pairwise distinct.</li>
</ul>

---

## ✅ Code (Java)

```java
import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {
        HashMap<Integer, HashMap<Integer, Integer>> t = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> v = new HashMap<>();

        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }

                int g = gcd(dx, Math.abs(dy));
                int sx = dx / g;
                int sy = dy / g;

                int des = sx * points[i][1] - sy * points[i][0];

                int key1 = (sx << 12) | (sy + 2000);
                int key2 = (dx << 12) | (dy + 2000);

                t.computeIfAbsent(key1, k -> new HashMap<>()).merge(des, 1, Integer::sum);
                v.computeIfAbsent(key2, k -> new HashMap<>()).merge(des, 1, Integer::sum);
            }
        }

        return count(t) - count(v) / 2;
    }

    private int count(HashMap<Integer, HashMap<Integer, Integer>> map) {
        long ans = 0;

        for (HashMap<Integer, Integer> inner : map.values()) {
            long sum = 0;

            for (int val : inner.values()) sum += val;

            for (int val : inner.values()) {
                sum -= val;
                ans += (long) val * sum;
            }
        }

        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">points = [[-3,2],[3,0],[2,3],[3,2],[2,-3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-4.png" style="width: 250px; height: 250px;" /> <img alt="" src="https://assets.leetcode.com/uploads/2025/04/29/desmos-graph-3.png" style="width: 250px; height: 250px;" /></p>

<p>There are two distinct ways to pick four points that form a trapezoid:</p>

<ul>
	<li>The points <code>[-3,2], [2,3], [3,2], [2,-3]</code> form one trapezoid.</li>
	<li>The points <code>[2,3], [3,2], [3,0], [2,-3]</code> form another trapezoid.</li>
</ul>
</div>

<p><strong class="example">


