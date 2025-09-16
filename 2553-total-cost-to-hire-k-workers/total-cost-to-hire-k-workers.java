class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long total = 0;

        // Two min-heaps
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int l = 0, r = n - 1;

        // Pre-fill from both sides
        for (int i = 0; i < candidates && l <= r; i++) left.offer(costs[l++]);
        for (int i = 0; i < candidates && l <= r; i++) right.offer(costs[r--]);

        // Hire k workers
        for (int i = 0; i < k; i++) {
            // Decide from which heap to hire
            int leftMin = left.isEmpty() ? Integer.MAX_VALUE : left.peek();
            int rightMin = right.isEmpty() ? Integer.MAX_VALUE : right.peek();

            if (leftMin <= rightMin) {
                total += left.poll();
                if (l <= r) left.offer(costs[l++]);
            } else {
                total += right.poll();
                if (l <= r) right.offer(costs[r--]);
            }
        }

        return total;
    }
}