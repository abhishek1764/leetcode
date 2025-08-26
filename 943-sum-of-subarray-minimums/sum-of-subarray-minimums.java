class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<int[]> stack = new Stack<>();

        // Compute left: strictly greater (count subarrays ending at i)
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek()[0] > arr[i]) {
                count += stack.pop()[1];
            }
            stack.push(new int[]{arr[i], count});
            left[i] = count;
        }

        stack.clear();

        // Compute right: greater OR equal (count subarrays starting at i)
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                count += stack.pop()[1];
            }
            stack.push(new int[]{arr[i], count});
            right[i] = count;
        }

        // Final sum
        long result = 0;
        for (int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * left[i] * right[i]) % MOD;
        }

        return (int) result;
    }
}