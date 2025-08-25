class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int writer = 2; // start from index 2, since first two are always allowed

        for (int reader = 2; reader < nums.length; reader++) {
            if (nums[reader] != nums[writer - 2]) {
                nums[writer] = nums[reader];
                writer++;
            }
        }
        return writer;
    }
}