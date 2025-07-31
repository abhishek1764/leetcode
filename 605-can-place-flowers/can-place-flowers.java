class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
       int count=0;
       int len =flowerbed.length;
       for(int i=0;i<len;i++){
        if (flowerbed[i]==0){
            boolean leftempty=(i==0||flowerbed[i-1]==0);
            boolean rightempty=(i==len-1||flowerbed[i+1]==0);
            if(leftempty&&rightempty){
                flowerbed[i]=1;
                count++;
                if(count>=n)return true;

            }
          }
       }
       return count>=n;
    }
    public static void main (String[]args){
        Solution sol=new Solution();
        int[] flowerbed1={1,0,0,0,1};
        System.out.println(sol.canPlaceFlowers(flowerbed1,1));
        int[] flowerbed2={1,0,0,0,1};
        System.out.println(sol.canPlaceFlowers(flowerbed2,2));
    }
}

   