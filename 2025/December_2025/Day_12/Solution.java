class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Collections.sort(events, new Comparator<List<String>>(){
            @Override
            public int compare(List<String> a, List<String> b) {
                int timeA = Integer.valueOf(a.get(1));
                int timeB = Integer.valueOf(b.get(1));
                if(timeA != timeB)
                    return Integer.compare(timeA,timeB);
                else {
                    if(a.get(0).equals("OFFLINE"))
                        return -1;
                    else
                        return 1;
                }
            }
        });
        int[] mentions = new int[numberOfUsers];
        int[] online_time = new int[numberOfUsers];
        Arrays.fill(online_time,-1);
        int all=0;
        for(int i=0;i<events.size();i++) {
            List<String> event = events.get(i);
            if(event.get(0).equals("MESSAGE")) {
                int timestamp = Integer.valueOf(event.get(1));
                String mentions_string = event.get(2);
                if(mentions_string.equals("ALL"))
                    all++;
                else if(mentions_string.equals("HERE")) {
                    for(int j=0;j<numberOfUsers;j++) {
                        if(online_time[j]<= timestamp)
                            mentions[j]++;
                    }
                } else {
                    String[] ids = mentions_string.split(" ");
                    for(String id : ids) {
                        int ID = Integer.valueOf(id.substring(2));
                        mentions[ID]++;
                    }
                }

            } else {
                int timestamp = Integer.valueOf(event.get(1));
                int id = Integer.valueOf(event.get(2));
                online_time[id] = timestamp + 60;
            }
        }
        for(int i=0;i<numberOfUsers;i++)
            mentions[i]+=all;
        return mentions;
    }
} 
