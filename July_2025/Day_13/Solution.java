import java.util.*;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0, j = 0, ans = 0;
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {  // can pair
                ++ans;
                ++i;
            }
            ++j;   // trainer consumed
        }
        return ans;
    }
} 
