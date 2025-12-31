class Pair{
    int node,dist;
    public Pair(int node,int dist)
    {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    private int[] shortestPaths(int[] edges,int src)
    {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src,0));
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int node = curr.node, d = curr.dist;
            if(edges[node] != -1 && dist[edges[node]] > d + 1)
            {
                dist[edges[node]] = d + 1 ;
                q.offer(new Pair(edges[node],dist[edges[node]]));
            }
        }
        return dist;
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] Spath1 = shortestPaths(edges,node1);
        int[] Spath2 = shortestPaths(edges,node2);
        int ansNode = -1;
        int preMax = Integer.MAX_VALUE;
        for(int i=0;i<edges.length;i++)
        {
            int pMax = Math.max(Spath1[i],Spath2[i]);
            if(Spath1[i] != Integer.MAX_VALUE && Spath2[i] != Integer.MAX_VALUE && pMax < preMax)
            {
                preMax = pMax;
                ansNode = i;
            }
        }
        return ansNode;
    }
} 
