# 📌 Day 22: 3647. Zero Array Transformation III 🎯

**🔗 LeetCode Link:** [3647. Zero Array Transformation III](https://leetcode.com/problems/zero-array-transformation-iii)

---

## 🧩 Problem Description

You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri].

Each queries[i] represents the following action on nums:


	Decrement the value at each index in the range [li, ri] in nums by at most 1.
	The amount by which the value is decremented can be chosen independently for each index.


A Zero Array is an array with all its elements equal to 0.

Return the maximum number of elements that can be removed from queries, such that nums can still be converted to a zero array using the remaining queries. If it is not possible to convert nums to a zero array, return -1.

&nbsp;

---

## 🧠 Topics

- Array
- Greedy
- Sorting
- Heap (Priority Queue)
- Prefix Sum
---

## 🧩 Examples

### ✨ Example 1

Example 1:


Input: nums = [2,0,2], queries = [[0,2],[0,2],[1,1]]

Output: 1

Explanation:

After removing queries[2], nums can still be converted to a zero array.


	Using queries[0], decrement nums[0] and nums[2] by 1 and nums[1] by 0.
	Using queries[1], decrement nums[0] and nums[2] by 1 and nums[1] by 0.

### ✨ Example 2

Example 2:


Input: nums = [1,1,1,1], queries = [[1,3],[0,2],[1,3],[1,2]]

Output: 2

Explanation:

We can remove queries[2] and queries[3].

### ✨ Example 3

Example 3:


Input: nums = [1,2,3,4], queries = [[0,3]]

Output: -1

Explanation:

nums cannot be converted to a zero array even after using all the queries.


&nbsp;
Constraints:


	1 <= nums.length <= 105
	0 <= nums[i] <= 105
	1 <= queries.length <= 105
	queries[i].length == 2
	0 <= li <= ri <= nums.length


---

## ✅ Code (Java)

```java

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

         int[] ends = new int[nums.length + 1];

         int operations = 0;

        int j = 0;
         for (int i = 0; i < nums.length; i++) {
            operations += ends[i];
            
            while (j < queries.length && queries[j][0] == i) {
                pq.offer(queries[j++][1]);
            }

            while (operations < nums[i] && !pq.isEmpty() && pq.peek() >= i) {
                operations++;
                ends[pq.poll() + 1]--;
            }

            if (operations < nums[i]) {
                return -1;
            }
         }

        return pq.size();
    }
}

 ```
## 🧪 Sample Test Case

Input: nums = [2,0,2], queries = [[0,2],[0,2],[1,1]] int operations = 0; 
Output: 1

