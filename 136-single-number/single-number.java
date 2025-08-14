class Solution {
    public int singleNumber(int[] nums) {
     int result = 0;
        for (int num : nums) {
            result ^= num; // cancel out pairs, leave the single one
        }
        return result;
    

    }
}