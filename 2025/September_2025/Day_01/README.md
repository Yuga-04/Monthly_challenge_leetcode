# 📌 Day 1: 1792. Maximum Average Pass Ratio 🎯

**🔗 LeetCode Link:** [1792. Maximum Average Pass Ratio](https://leetcode.com/problems/maximum-average-pass-ratio/)

---

## 🧩 Problem Description

<p>There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array <code>classes</code>, where <code>classes[i] = [pass<sub>i</sub>, total<sub>i</sub>]</code>. You know beforehand that in the <code>i<sup>th</sup></code> class, there are <code>total<sub>i</sub></code> total students, but only <code>pass<sub>i</sub></code> number of students will pass the exam.</p>

<p>You are also given an integer <code>extraStudents</code>. There are another <code>extraStudents</code> brilliant students that are <strong>guaranteed</strong> to pass the exam of any class they are assigned to. You want to assign each of the <code>extraStudents</code> students to a class in a way that <strong>maximizes</strong> the <strong>average</strong> pass ratio across <strong>all</strong> the classes.</p>

<p>The <strong>pass ratio</strong> of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The <strong>average pass ratio</strong> is the sum of pass ratios of all the classes divided by the number of the classes.</p>

<p>Return <em>the <strong>maximum</strong> possible average pass ratio after assigning the </em><code>extraStudents</code><em> students. </em>Answers within <code>10<sup>-5</sup></code> of the actual answer will be accepted.</p>

<p>&nbsp;</p>
<p><strong class="example">

---

## 🧠 Topics

- Array
- Greedy
- Heap (Priority Queue)
---

## 🧩 Examples

### ✨ Example 1

Example 1:</strong></p>

<pre>
<strong>Input:</strong> classes = [[1,2],[3,5],[2,2]], <code>extraStudents</code> = 2
<strong>Output:</strong> 0.78333
<strong>Explanation:</strong> You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
</pre>

<p><strong class="example">

### ✨ Example 2

Example 2:</strong></p>

<pre>
<strong>Input:</strong> classes = [[2,4],[3,9],[4,5],[2,10]], <code>extraStudents</code> = 4
<strong>Output:</strong> 0.53485
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= classes.length &lt;= 10<sup>5</sup></code></li>
	<li><code>classes[i].length == 2</code></li>
	<li><code>1 &lt;= pass<sub>i</sub> &lt;= total<sub>i</sub> &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= extraStudents &lt;= 10<sup>5</sup></code></li>
</ul>

---

## ✅ Code (Java)

```java

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                if (a[0] < b[0]) return 1;
                if (a[0] > b[0]) return -1;
                return 0;
            }
        });

        for (int i = 0; i < classes.length; i++) {
            double pass = classes[i][0];
            double total = classes[i][1];
            double inc = (pass + 1.0) / (total + 1.0) - pass / total;
            pq.offer(new double[]{inc, pass, total});
        }

        while (extraStudents > 0) {
            double[] top = pq.poll();
            double pass = top[1] + 1;
            double total = top[2] + 1;
            double inc = (pass + 1.0) / (total + 1.0) - pass / total;
            pq.offer(new double[]{inc, pass, total});
            extraStudents--;
        }

        double sum = 0.0;
        Object[] arr = pq.toArray();
        for (int i = 0; i < arr.length; i++) {
            double[] c = (double[]) arr[i];
            sum += c[1] / c[2];
        }

        return sum / classes.length;
    }
}
```

---

## 🧪 Sample Test Case


Example 1:</strong></p>

<pre>
<strong>Input:</strong> classes = [[1,2],[3,5],[2,2]], <code>extraStudents</code> = 2
<strong>Output:</strong> 0.78333
</pre>

<p><strong class="example">


