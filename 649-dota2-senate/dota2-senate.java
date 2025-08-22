class Solution {
    public String predictPartyVictory(String senate) {
         int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        
        // Step 1: Fill queues with indices
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }
        
        // Step 2: Process rounds
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();
            
            if (r < d) {
                // Radiant senator acts first, bans Dire
                radiant.add(r + n);
            } else {
                // Dire senator acts first, bans Radiant
                dire.add(d + n);
            }
        }
        
        // Step 3: Result
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}