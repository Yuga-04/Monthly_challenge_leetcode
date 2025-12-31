# 📌 Day 31: 37. Sudoku Solver 🎯

**🔗 LeetCode Link:** [37. Sudoku Solver](https://leetcode.com/problems/sudoku-solver/)

---

## 🧩 Problem Description

<p>Write a program to solve a Sudoku puzzle by filling the empty cells.</p>

<p>A sudoku solution must satisfy <strong>all of the following rules</strong>:</p>

<ol>
	<li>Each of the digits <code>1-9</code> must occur exactly once in each row.</li>
	<li>Each of the digits <code>1-9</code> must occur exactly once in each column.</li>
	<li>Each of the digits <code>1-9</code> must occur exactly once in each of the 9 <code>3x3</code> sub-boxes of the grid.</li>
</ol>

<p>The <code>&#39;.&#39;</code> character indicates empty cells.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- Backtracking
- Matrix
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png" style="height:250px; width:250px" />
<pre>
<strong>Input:</strong> board = [[&quot;5&quot;,&quot;3&quot;,&quot;.&quot;,&quot;.&quot;,&quot;7&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;6&quot;,&quot;.&quot;,&quot;.&quot;,&quot;1&quot;,&quot;9&quot;,&quot;5&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;9&quot;,&quot;8&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;6&quot;,&quot;.&quot;],[&quot;8&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;6&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;3&quot;],[&quot;4&quot;,&quot;.&quot;,&quot;.&quot;,&quot;8&quot;,&quot;.&quot;,&quot;3&quot;,&quot;.&quot;,&quot;.&quot;,&quot;1&quot;],[&quot;7&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;2&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;6&quot;],[&quot;.&quot;,&quot;6&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;2&quot;,&quot;8&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;4&quot;,&quot;1&quot;,&quot;9&quot;,&quot;.&quot;,&quot;.&quot;,&quot;5&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;8&quot;,&quot;.&quot;,&quot;.&quot;,&quot;7&quot;,&quot;9&quot;]]
<strong>Output:</strong> [[&quot;5&quot;,&quot;3&quot;,&quot;4&quot;,&quot;6&quot;,&quot;7&quot;,&quot;8&quot;,&quot;9&quot;,&quot;1&quot;,&quot;2&quot;],[&quot;6&quot;,&quot;7&quot;,&quot;2&quot;,&quot;1&quot;,&quot;9&quot;,&quot;5&quot;,&quot;3&quot;,&quot;4&quot;,&quot;8&quot;],[&quot;1&quot;,&quot;9&quot;,&quot;8&quot;,&quot;3&quot;,&quot;4&quot;,&quot;2&quot;,&quot;5&quot;,&quot;6&quot;,&quot;7&quot;],[&quot;8&quot;,&quot;5&quot;,&quot;9&quot;,&quot;7&quot;,&quot;6&quot;,&quot;1&quot;,&quot;4&quot;,&quot;2&quot;,&quot;3&quot;],[&quot;4&quot;,&quot;2&quot;,&quot;6&quot;,&quot;8&quot;,&quot;5&quot;,&quot;3&quot;,&quot;7&quot;,&quot;9&quot;,&quot;1&quot;],[&quot;7&quot;,&quot;1&quot;,&quot;3&quot;,&quot;9&quot;,&quot;2&quot;,&quot;4&quot;,&quot;8&quot;,&quot;5&quot;,&quot;6&quot;],[&quot;9&quot;,&quot;6&quot;,&quot;1&quot;,&quot;5&quot;,&quot;3&quot;,&quot;7&quot;,&quot;2&quot;,&quot;8&quot;,&quot;4&quot;],[&quot;2&quot;,&quot;8&quot;,&quot;7&quot;,&quot;4&quot;,&quot;1&quot;,&quot;9&quot;,&quot;6&quot;,&quot;3&quot;,&quot;5&quot;],[&quot;3&quot;,&quot;4&quot;,&quot;5&quot;,&quot;2&quot;,&quot;8&quot;,&quot;6&quot;,&quot;1&quot;,&quot;7&quot;,&quot;9&quot;]]
<strong>Explanation:</strong>&nbsp;The input board is shown above and the only valid solution is shown below:

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png" style="height:250px; width:250px" />
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>board.length == 9</code></li>
	<li><code>board[i].length == 9</code></li>
	<li><code>board[i][j]</code> is a digit or <code>&#39;.&#39;</code>.</li>
	<li>It is <strong>guaranteed</strong> that the input board has only one solution.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) return true;
                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
        }
        int startRow = (row / 3) * 3, startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png" style="height:250px; width:250px" />
<pre>
<strong>Input:</strong> board = [[&quot;5&quot;,&quot;3&quot;,&quot;.&quot;,&quot;.&quot;,&quot;7&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;6&quot;,&quot;.&quot;,&quot;.&quot;,&quot;1&quot;,&quot;9&quot;,&quot;5&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;9&quot;,&quot;8&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;6&quot;,&quot;.&quot;],[&quot;8&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;6&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;3&quot;],[&quot;4&quot;,&quot;.&quot;,&quot;.&quot;,&quot;8&quot;,&quot;.&quot;,&quot;3&quot;,&quot;.&quot;,&quot;.&quot;,&quot;1&quot;],[&quot;7&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;2&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;6&quot;],[&quot;.&quot;,&quot;6&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;2&quot;,&quot;8&quot;,&quot;.&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;4&quot;,&quot;1&quot;,&quot;9&quot;,&quot;.&quot;,&quot;.&quot;,&quot;5&quot;],[&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;.&quot;,&quot;8&quot;,&quot;.&quot;,&quot;.&quot;,&quot;7&quot;,&quot;9&quot;]]
<strong>Output:</strong> [[&quot;5&quot;,&quot;3&quot;,&quot;4&quot;,&quot;6&quot;,&quot;7&quot;,&quot;8&quot;,&quot;9&quot;,&quot;1&quot;,&quot;2&quot;],[&quot;6&quot;,&quot;7&quot;,&quot;2&quot;,&quot;1&quot;,&quot;9&quot;,&quot;5&quot;,&quot;3&quot;,&quot;4&quot;,&quot;8&quot;],[&quot;1&quot;,&quot;9&quot;,&quot;8&quot;,&quot;3&quot;,&quot;4&quot;,&quot;2&quot;,&quot;5&quot;,&quot;6&quot;,&quot;7&quot;],[&quot;8&quot;,&quot;5&quot;,&quot;9&quot;,&quot;7&quot;,&quot;6&quot;,&quot;1&quot;,&quot;4&quot;,&quot;2&quot;,&quot;3&quot;],[&quot;4&quot;,&quot;2&quot;,&quot;6&quot;,&quot;8&quot;,&quot;5&quot;,&quot;3&quot;,&quot;7&quot;,&quot;9&quot;,&quot;1&quot;],[&quot;7&quot;,&quot;1&quot;,&quot;3&quot;,&quot;9&quot;,&quot;2&quot;,&quot;4&quot;,&quot;8&quot;,&quot;5&quot;,&quot;6&quot;],[&quot;9&quot;,&quot;6&quot;,&quot;1&quot;,&quot;5&quot;,&quot;3&quot;,&quot;7&quot;,&quot;2&quot;,&quot;8&quot;,&quot;4&quot;],[&quot;2&quot;,&quot;8&quot;,&quot;7&quot;,&quot;4&quot;,&quot;1&quot;,&quot;9&quot;,&quot;6&quot;,&quot;3&quot;,&quot;5&quot;],[&quot;3&quot;,&quot;4&quot;,&quot;5&quot;,&quot;2&quot;,&quot;8&quot;,&quot;6&quot;,&quot;1&quot;,&quot;7&quot;,&quot;9&quot;]]

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png" style="height:250px; width:250px" />
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>board.length == 9</code></li>
	<li><code>board[i].length == 9</code></li>
	<li><code>board[i][j]</code> is a digit or <code>&#39;.&#39;</code>.</li>
	<li>It is <strong>guaranteed</strong> that the input board has only one solution.</li>
</ul>


