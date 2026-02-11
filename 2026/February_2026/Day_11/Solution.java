class Solution {
    static class Node {
        int mn, mx, lz;
    }
    int n;
    Node[] seg;

    void push(int node) {
        int val = seg[node].lz;
        if (val == 0) 
            return;
        int lc = node << 1, rc = lc | 1;
        seg[lc].mn += val; seg[lc].mx += val; seg[lc].lz += val;
        seg[rc].mn += val; seg[rc].mx += val; seg[rc].lz += val;

        seg[node].lz = 0;
    }

    void pull(int node) {
        int lc = node << 1, rc = lc | 1;
        seg[node].mn = Math.min(seg[lc].mn, seg[rc].mn);
        seg[node].mx = Math.max(seg[lc].mx, seg[rc].mx);
    }

    void update(int node, int segLeft, int segRight, int queryLeft, int queryRight, int addValue) {
        if (queryLeft > queryRight) 
            return;

        if (queryLeft == segLeft && queryRight == segRight) {
            seg[node].mn += addValue;
            seg[node].mx += addValue;
            seg[node].lz += addValue;
            return;
        }
        push(node);
        int mid = (segLeft + segRight) >> 1;
        update(node << 1, segLeft, mid, queryLeft, Math.min(queryRight, mid), addValue);
        update(node << 1 | 1, mid + 1, segRight, Math.max(queryLeft, mid + 1), queryRight, addValue);

        pull(node);
    }

    int findFirst(int node, int segLeft, int segRight, int limit) {
        if (segLeft > limit) 
            return -1;
        if (seg[node].mn > 0 || seg[node].mx < 0) 
            return -1;
        if (segLeft == segRight) 
            return segLeft;

        push(node);
        int mid = (segLeft + segRight) >> 1;

        int leftRes = findFirst(node << 1, segLeft, mid, limit);
        if (leftRes != -1) 
            return leftRes;

        if (mid < limit) 
            return findFirst(node << 1 | 1, mid + 1, segRight, limit);
        return -1;
    }

    public int longestBalanced(int[] nums) {
        n = nums.length;
        seg = new Node[4 * n + 5];
        for (int i = 0; i < seg.length; i++) seg[i] = new Node();
        int[] lastPos = new int[100005];
        Arrays.fill(lastPos, -1);
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int prev = lastPos[val];
            int diff = (val & 1) == 1 ? -1 : 1;

            update(1, 0, n - 1, prev + 1, i, diff);

            lastPos[val] = i;

            int start = findFirst(1, 0, n - 1, i);
            if (start != -1) {
                maxLen = Math.max(maxLen, i - start + 1);
            }
        }
        return maxLen;
    }
} 
