class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];

        // Pair nums2 with nums1
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }

        // Sort by nums2 in descending order
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0, result = 0;

        for (int[] p : pairs) {
            int val2 = p[0], val1 = p[1];

            // Add nums1 value
            minHeap.add(val1);
            sum += val1;

            // Keep only k elements
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            // If we have k elements, calculate score
            if (minHeap.size() == k) {
                result = Math.max(result, sum * val2);
            }
        }

        return result;
    }
}
