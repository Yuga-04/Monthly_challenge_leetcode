# 📌 Day 11: 3531. Count Covered Buildings 🎯

**🔗 LeetCode Link:** [3531. Count Covered Buildings](https://leetcode.com/problems/count-covered-buildings/)

---

## 🧩 Problem Description

<p>You are given a positive integer <code>n</code>, representing an <code>n x n</code> city. You are also given a 2D grid <code>buildings</code>, where <code>buildings[i] = [x, y]</code> denotes a <strong>unique</strong> building located at coordinates <code>[x, y]</code>.</p>

<p>A building is <strong>covered</strong> if there is at least one building in all <strong>four</strong> directions: left, right, above, and below.</p>

<p>Return the number of <strong>covered</strong> buildings.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Hash Table
- Sorting
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2025/03/04/telegram-cloud-photo-size-5-6212982906394101085-m.jpg" style="width: 200px; height: 204px;" /></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Only building <code>[2,2]</code> is covered as it has at least one building:

	<ul>
		<li>above (<code>[1,2]</code>)</li>
		<li>below (<code>[3,2]</code>)</li>
		<li>left (<code>[2,1]</code>)</li>
		<li>right (<code>[2,3]</code>)</li>
	</ul>
	</li>
	<li>Thus, the count of covered buildings is 1.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2025/03/04/telegram-cloud-photo-size-5-6212982906394101086-m.jpg" style="width: 200px; height: 204px;" /></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 3, buildings = [[1,1],[1,2],[2,1],[2,2]]</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>No building has at least one building in all four directions.</li>
</ul>
</div>

<p><strong class="example">

### ✨ Example 3

Example 3:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2025/03/16/telegram-cloud-photo-size-5-6248862251436067566-x.jpg" style="width: 202px; height: 205px;" /></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 5, buildings = [[1,3],[3,2],[3,3],[3,5],[5,3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Only building <code>[3,3]</code> is covered as it has at least one building:

	<ul>
		<li>above (<code>[1,3]</code>)</li>
		<li>below (<code>[5,3]</code>)</li>
		<li>left (<code>[3,2]</code>)</li>
		<li>right (<code>[3,5]</code>)</li>
	</ul>
	</li>
	<li>Thus, the count of covered buildings is 1.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= buildings.length &lt;= 10<sup>5</sup> </code></li>
	<li><code>buildings[i] = [x, y]</code></li>
	<li><code>1 &lt;= x, y &lt;= n</code></li>
	<li>All coordinates of <code>buildings</code> are <strong>unique</strong>.</li>
</ul>

---

## ✅ Code (Java)

```java
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer, TreeSet<Integer>> rowMap = new HashMap<>();
        HashMap<Integer, TreeSet<Integer>> colMap = new HashMap<>();
        for(int[] building : buildings) {
            int x=building[0],y=building[1];
            if(!rowMap.containsKey(x))
                rowMap.put(x, new TreeSet<>());
            rowMap.get(x).add(y);
            if(!colMap.containsKey(y))
                colMap.put(y, new TreeSet<>());
            colMap.get(y).add(x);
        }
        int ans=0;
        for(int[] building : buildings) {
            int x=building[0],y=building[1];
            TreeSet<Integer> row = colMap.get(y);
            TreeSet<Integer> col = rowMap.get(x);
            Integer top = col.higher(y);
            Integer down = col.lower(y);
            Integer left = row.lower(x);
            Integer right = row.higher(x);
            if(top!=null && down!=null && left!=null && right!=null)
                ans++;
        }
        return ans;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2025/03/04/telegram-cloud-photo-size-5-6212982906394101085-m.jpg" style="width: 200px; height: 204px;" /></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Only building <code>[2,2]</code> is covered as it has at least one building:

	<ul>
		<li>above (<code>[1,2]</code>)</li>
		<li>below (<code>[3,2]</code>)</li>
		<li>left (<code>[2,1]</code>)</li>
		<li>right (<code>[2,3]</code>)</li>
	</ul>
	</li>
	<li>Thus, the count of covered buildings is 1.</li>
</ul>
</div>

<p><strong class="example">


