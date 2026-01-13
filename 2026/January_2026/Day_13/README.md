# 📌 Day 13: 3453. Separate Squares I 🎯

**🔗 LeetCode Link:** [3453. Separate Squares I](https://leetcode.com/problems/separate-squares-i/)

---

## 🧩 Problem Description

<p>You are given a 2D integer array <code>squares</code>. Each <code>squares[i] = [x<sub>i</sub>, y<sub>i</sub>, l<sub>i</sub>]</code> represents the coordinates of the bottom-left point and the side length of a square parallel to the x-axis.</p>

<p>Find the <strong>minimum</strong> y-coordinate value of a horizontal line such that the total area of the squares above the line <em>equals</em> the total area of the squares below the line.</p>

<p>Answers within <code>10<sup>-5</sup></code> of the actual answer will be accepted.</p>

<p><strong>Note</strong>: Squares <strong>may</strong> overlap. Overlapping areas should be counted <strong>multiple times</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Binary Search
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">squares = [[0,0,1],[2,2,1]]</span></p>

<p><strong>Output:</strong> <span class="example-io">1.00000</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2025/01/06/4062example1drawio.png" style="width: 378px; height: 352px;" /></p>

<p>Any horizontal line between <code>y = 1</code> and <code>y = 2</code> will have 1 square unit above it and 1 square unit below it. The lowest option is 1.</p>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">squares = [[0,0,2],[1,1,1]]</span></p>

<p><strong>Output:</strong> <span class="example-io">1.16667</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2025/01/15/4062example2drawio.png" style="width: 378px; height: 352px;" /></p>

<p>The areas are:</p>

<ul>
	<li>Below the line: <code>7/6 * 2 (Red) + 1/6 (Blue) = 15/6 = 2.5</code>.</li>
	<li>Above the line: <code>5/6 * 2 (Red) + 5/6 (Blue) = 15/6 = 2.5</code>.</li>
</ul>

<p>Since the areas above and below the line are equal, the output is <code>7/6 = 1.16667</code>.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= squares.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>squares[i] = [x<sub>i</sub>, y<sub>i</sub>, l<sub>i</sub>]</code></li>
	<li><code>squares[i].length == 3</code></li>
	<li><code>0 &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= l<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
	<li>The total area of all the squares will not exceed <code>10<sup>12</sup></code>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = 2e9; // Initialize with a large value
        double high = 0;

        // 1. Calculate Total Area and initial bounds
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            
            // Cast to double BEFORE multiplying to prevent Integer Overflow
            totalArea += l * l;
            
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double halfArea = totalArea / 2.0;

        // 2. Binary Search with fixed iterations
        
        for (int i = 0; i < 100; i++) {
            double mid = low + (high - low) / 2.0;
            
            if (calculateArea(squares, mid) >= halfArea) {
                high = mid; // Area is sufficient, try to lower the line
            } else {
                low = mid;  // Area is too small, need to raise the line
            }
        }
        
        return high;
    }

    // Helper function to calculate area below the line 'currentY'
    private double calculateArea(int[][] squares, double currentY) {
        double area = 0;
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            double top = y + l;

            if (y >= currentY) {
                // Case 1: Square is completely above the line
                continue;
            } else if (top <= currentY) {
                // Case 2: Square is completely below the line
                area += l * l;
            } else {
                // Case 3: Line cuts through the square
                // We take the width (l) * the height of the bottom portion (currentY - y)
                area += l * (currentY - y);
            }
        }
        return area;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">squares = [[0,0,1],[2,2,1]]</span></p>

<p><strong>Output:</strong> <span class="example-io">1.00000</span></p>

<p><strong>Explanation:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2025/01/06/4062example1drawio.png" style="width: 378px; height: 352px;" /></p>

<p>Any horizontal line between <code>y = 1</code> and <code>y = 2</code> will have 1 square unit above it and 1 square unit below it. The lowest option is 1.</p>
</div>

<p><strong class="example">


