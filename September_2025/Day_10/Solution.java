import java.util.*;

class Solution {
    public int minimumTeachings(int totalLanguages, int[][] userLanguages, int[][] friendships) {
        Set<Integer> usersToTeach = new HashSet<>();
        
        // Step 1: Find users who cannot communicate
        for (int[] friendship : friendships) {
            int u1 = friendship[0] - 1;
            int u2 = friendship[1] - 1;
            boolean canCommunicate = false;
            
            for (int lang1 : userLanguages[u1]) {
                for (int lang2 : userLanguages[u2]) {
                    if (lang1 == lang2) {
                        canCommunicate = true;
                        break;
                    }
                }
                if (canCommunicate) break;
            }
            
            if (!canCommunicate) {
                usersToTeach.add(u1);
                usersToTeach.add(u2);
            }
        }
        
        int minUsersToTeach = userLanguages.length + 1;
        
        // Step 2: Try each language
        for (int lang = 1; lang <= totalLanguages; lang++) {
            int count = 0;
            
            for (int user : usersToTeach) {
                boolean knows = false;
                for (int l : userLanguages[user]) {
                    if (l == lang) {
                        knows = true;
                        break;
                    }
                }
                if (!knows) count++;
            }
            
            minUsersToTeach = Math.min(minUsersToTeach, count);
        }
        
        return minUsersToTeach;
    }
} 
