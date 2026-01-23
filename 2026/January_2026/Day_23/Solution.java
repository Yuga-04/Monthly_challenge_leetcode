class Solution {
    static class Node {
        long sum;
        int i;
        Node(long sum, int i) { this.sum = sum; this.i = i; }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) 
            return 0;

        long[] a = new long[n];
        for (int i = 0; i < n; i++) 
            a[i] = nums[i];

        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = i - 1;
            right[i] = (i + 1 < n) ? i + 1 : -1;
        }

        PriorityQueue<Node> heap = new PriorityQueue<>((p, q) -> {
            if (p.sum != q.sum) 
                return Long.compare(p.sum, q.sum);
            return Integer.compare(p.i, q.i);
        });

        for (int i = 0; i < n - 1; i++) 
            heap.add(new Node(a[i] + a[i + 1], i));

        int rest = 0;
        for (int i = 0; i < n - 1; i++) 
            if (a[i] > a[i + 1]) 
                rest++;

        int ans = 0;

        while (rest > 0) {
            Node cur = heap.poll();
            long v = cur.sum;
            int i = cur.i;

            int r = right[i];
            if (r == -1) 
                continue;
            if (left[r] != i) 
                continue;
            if (a[i] + a[r] != v) 
                continue; 

            int li = left[i];
            int rr = right[r];

            if (li != -1 && right[li] == i && a[li] > a[i]) 
                rest--;
            if (a[i] > a[r]) 
                rest--;
            if (rr != -1 && left[rr] == r && a[r] > a[rr]) 
                rest--;

            a[i] = v;

            right[i] = rr;
            if (rr != -1) 
                left[rr] = i;
            left[r] = -1;
            right[r] = -1;

            if (li != -1 && right[li] == i && a[li] > a[i]) 
                rest++;
            if (rr != -1 && left[rr] == i && a[i] > a[rr]) 
                rest++;

            if (li != -1 && right[li] == i) 
                heap.add(new Node(a[li] + a[i], li));
            if (rr != -1 && left[rr] == i) 
                heap.add(new Node(a[i] + a[rr], i));

            ans++;
        }

        return ans;
    }
} 
