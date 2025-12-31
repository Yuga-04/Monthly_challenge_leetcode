class Solution {
    // Union-Find parent array for 26 lowercase letters
    public int[] parent;

    // Main method to return the lexicographically smallest equivalent string
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        parent = new int[26];

        // Initialize each character to be its own parent
        for (int i = 0; i < 26; ++i) {
            parent[i] = i;
        }

        // Build equivalence groups based on s1 and s2
        for (int i = 0; i < s1.length(); ++i) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            int pu = find(u);
            int pv = find(v);

            // Union by lexicographical order (keep smaller one as root)
            if (pu < pv) {
                parent[pv] = pu;
            } else {
                parent[pu] = pv;
            }
        }

        // Construct result using the smallest equivalent character for each
        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            char mapped = (char) (find(ch - 'a') + 'a');
            result.append(mapped);
        }
        return result.toString();
    }

    // Find operation with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }
} 
