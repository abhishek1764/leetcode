class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  // Sort first
        int n = nums.length;

        // Initialize with first three numbers
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // Update if closer
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum < target) {
                    left++;  // need a larger sum
                } else if (sum > target) {
                    right--; // need a smaller sum
                } else {
                    return sum; // exact match
                }
            }
        }
        return closest;
    }
}