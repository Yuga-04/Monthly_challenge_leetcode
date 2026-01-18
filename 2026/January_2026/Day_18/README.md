# 📌 Day 18: 1895. Largest Magic Square 🎯

**🔗 LeetCode Link:** [1895. Largest Magic Square](https://leetcode.com/problems/largest-magic-square/)

---

## 🧩 Problem Description

<p>A <code>k x k</code> <strong>magic square</strong> is a <code>k x k</code> grid filled with integers such that every row sum, every column sum, and both diagonal sums are <strong>all equal</strong>. The integers in the magic square <strong>do not have to be distinct</strong>. Every <code>1 x 1</code> grid is trivially a <strong>magic square</strong>.</p>

<p>Given an <code>m x n</code> integer <code>grid</code>, return <em>the <strong>size</strong> (i.e., the side length </em><code>k</code><em>) of the <strong>largest magic square</strong> that can be found within this grid</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Matrix
- Prefix Sum
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/05/29/magicsquare-grid.jpg" style="width: 413px; height: 335px;" />
<pre>
<strong>Input:</strong> grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The largest magic square has a size of 3.
Every row sum, column sum, and diagonal sum of this magic square is equal to 12.
- Row sums: 5+1+6 = 5+4+3 = 2+7+3 = 12
- Column sums: 5+5+2 = 1+4+7 = 6+3+3 = 12
- Diagonal sums: 5+4+3 = 6+4+2 = 12
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/05/29/magicsquare2-grid.jpg" style="width: 333px; height: 255px;" />
<pre>
<strong>Input:</strong> grid = [[5,1,3,1],[9,3,3,1],[1,3,3,8]]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 50</code></li>
	<li><code>1 &lt;= grid[i][j] &lt;= 10<sup>6</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int side = Math.min(m,n);

        while(side > 0){
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(i+side<=m && j+side<=n){
                        if(isValid(grid,m,n,i,j,side))return side;
                    }
                }
            }
            side--;
        }

        return 0;
    }

    private boolean isValid(int[][] grid, int m, int n, int i, int j, int side) {
        int sum = 0;

        // rows
        for (int x = i; x < i + side; x++) {
            int summ = 0;
            for (int y = j; y < j + side; y++) {
                summ += grid[x][y];
            }
            if (x == i) sum = summ;
            else if (sum != summ) return false;
        }

        // columns
        for (int x = j; x < j + side; x++) {
            int summ = 0;
            for (int y = i; y < i + side; y++) {
                summ += grid[y][x];
            }
            if (sum != summ) return false;
        }

        // main diagonal
        int summ = 0;
        for (int k = 0; k < side; k++) {
            summ += grid[i + k][j + k];
        }
        if (sum != summ) return false;

        // anti-diagonal
        summ = 0;
        for (int k = 0; k < side; k++) {
            summ += grid[i + k][j + side - 1 - k];
        }
        if (sum != summ) return false;

        return true;
    }

}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/05/29/magicsquare-grid.jpg" style="width: 413px; height: 335px;" />
<pre>
<strong>Input:</strong> grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The largest magic square has a size of 3.
Every row sum, column sum, and diagonal sum of this magic square is equal to 12.
- Row sums: 5+1+6 = 5+4+3 = 2+7+3 = 12
- Column sums: 5+5+2 = 1+4+7 = 6+3+3 = 12
- Diagonal sums: 5+4+3 = 6+4+2 = 12
</pre>

<p><strong class="example">


