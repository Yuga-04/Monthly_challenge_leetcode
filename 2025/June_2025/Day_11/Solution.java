class Solution {
    static class FenwickTree {
        int n;
        int[] tree;
        static final int INF = Integer.MAX_VALUE;

        FenwickTree(int n) {
            this.n = n;
            tree = new int[n + 1];
            Arrays.fill(tree, INF);
        }

        void update(int i, int val) {
            for (int pos = i + 1; pos <= n; pos += pos & -pos) {
                tree[pos] = Math.min(tree[pos], val);
            }
        }

        int query(int i) {
            int res = INF;
            for (int pos = i + 1; pos > 0; pos -= pos & -pos) {
                res = Math.min(res, tree[pos]);
            }
            return res;
        }
    }

    public static int maxDifference(String s, int k) {
        int n = s.length(), ans = Integer.MIN_VALUE;

        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                if (a == b) continue;

                int[] D = new int[n + 1];
                int[] pa = new int[n + 1];
                int[] pb = new int[n + 1];
                int[] countB = new int[n + 1];

                D[0] = 0;
                pa[0] = 0;
                pb[0] = 0;
                countB[0] = 0;

                for (int i = 1; i <= n; i++) {
                    int digit = s.charAt(i - 1) - '0';
                    D[i] = D[i - 1] + ((digit == a) ? 1 : 0) - ((digit == b) ? 1 : 0);
                    pa[i] = (pa[i - 1] + ((digit == a) ? 1 : 0)) & 1;
                    pb[i] = (pb[i - 1] + ((digit == b) ? 1 : 0)) & 1;
                    countB[i] = countB[i - 1] + ((digit == b) ? 1 : 0);
                }

                int size = n + 1;
                FenwickTree[][] trees = new FenwickTree[2][2];

                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        trees[i][j] = new FenwickTree(size);
                    }
                }

                for (int j = 0; j <= n; j++) {
                    if (j >= k) {
                        int idx = j - k;
                        trees[pa[idx]][pb[idx]].update(countB[idx], D[idx]);
                    }

                    if (j > 0) {
                        int needP = 1 - pa[j];
                        int needQ = pb[j];

                        if (countB[j] > 0) {
                            int bestVal = trees[needP][needQ].query(countB[j] - 1);
                            if (bestVal != FenwickTree.INF) {
                                ans = Math.max(ans, D[j] - bestVal);
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
} 
