class Solution {
    public double findMaxAverage(int[] nums, int k) {
     int currsum =0;
     int maxsum = 0;
     for (int i=0; i<k; i++)
     {
      currsum +=nums[i];
     }
     maxsum = currsum;
     for (int i=k; i<nums.length; i++)
     {
        currsum= currsum+nums[i]-nums[i-k];

        if(currsum>maxsum)
        maxsum = currsum;  
     }
     return(double)maxsum/k;

    }
}