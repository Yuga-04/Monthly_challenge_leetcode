# 📌 Day 27: 812. Largest Triangle Area 🎯

**🔗 LeetCode Link:** [812. Largest Triangle Area](https://leetcode.com/problems/largest-triangle-area/)

---

## 🧩 Problem Description

<p>Given an array of points on the <strong>X-Y</strong> plane <code>points</code> where <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>, return <em>the area of the largest triangle that can be formed by any three different points</em>. Answers within <code>10<sup>-5</sup></code> of the actual answer will be accepted.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Math
- Geometry
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/04/1027.png" style="height: 369px; width: 450px;" />
<pre>
<strong>Input:</strong> points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
<strong>Output:</strong> 2.00000
<strong>Explanation:</strong> The five points are shown in the above figure. The red triangle is the largest.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> points = [[1,0],[0,0],[0,1]]
<strong>Output:</strong> 0.50000
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= points.length &lt;= 50</code></li>
	<li><code>-50 &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 50</code></li>
	<li>All the given points are <strong>unique</strong>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double area = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    double temp = 0.5 * Math.abs(points[k][0] *(points[i][1]-points[j][1]) 
                                   + points[i][0] *(points[j][1]-points[k][1]) 
                                   + points[j][0] *(points[k][1]-points[i][1]));
                    area = Math.max(temp, area);
                }
            }
        }

        return area;
    }
}```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/04/1027.png" style="height: 369px; width: 450px;" />
<pre>
<strong>Input:</strong> points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
<strong>Output:</strong> 2.00000
<strong>Explanation:</strong> The five points are shown in the above figure. The red triangle is the largest.
</pre>

<p><strong class="example">


