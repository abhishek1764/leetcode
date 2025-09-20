class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int ans = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEat(piles, h, mid)) {
                ans = mid;
                right = mid - 1; // try smaller k
            } else {
                left = mid + 1; // need bigger k
            }
        }
        return ans;
    }

    private boolean canEat(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // ceiling division
            if (hours > h) return false;
        }
        return hours <= h;
    }
}
