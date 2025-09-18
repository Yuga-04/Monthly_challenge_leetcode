class TaskManager {
    class Pair{
        int t,p;
        Pair(int t,int p){
            this.t=t;
            this.p=p;
        }
    }
    private TreeMap<Pair,Integer> map;
    private Map<Integer,Integer> map2;
    public TaskManager(List<List<Integer>> tasks) {
        map=new TreeMap<>((e1,e2)->{
            if(e1.p!=e2.p) return e2.p-e1.p;
            else return e2.t-e1.t;
        });
        map2=new HashMap<>();
        for(List<Integer> task:tasks) {
            map.put(new Pair(task.get(1),task.get(2)),task.get(0));
            map2.put(task.get(1),task.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        map.put(new Pair(taskId,priority),userId);
        map2.put(taskId,priority);
    }
    
    public void edit(int taskId, int newPriority) {
        Pair p=new Pair(taskId,map2.get(taskId));
        int u=map.get(p);
        map.remove(p);
        map.put(new Pair(taskId,newPriority),u);
        map2.put(taskId,newPriority);
    }
    
    public void rmv(int taskId) {
        map.remove(new Pair(taskId,map2.get(taskId)));
        map2.remove(taskId);
    }
    
    public int execTop() {
        if(map.isEmpty()) return -1;
        Pair p=map.firstKey();
        int ans=map.get(map.firstKey());
        map.remove(map.firstKey());
        map2.remove(p.t);
        return ans;
    }
} 
