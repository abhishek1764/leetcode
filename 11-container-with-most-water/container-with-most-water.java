class Solution {
    public int maxArea(int[] height) {
        int maxwater =0;//ans
        int lp=0;
        int rp= height.length-1;

        while(lp<rp)
        {
            int w =  rp-lp;
            int ht=Math.min(height[lp] ,height[rp]);
            int curwater = w * ht;
            maxwater=Math.max(maxwater,curwater);
         //height[lp] < height[rp] ? lp++ : rp--;ternary condition
         if(height[lp] < height[rp]) 
         {
            lp++;
         }
         else
         {
            rp--;
         }
        }
        return maxwater;
    }
}