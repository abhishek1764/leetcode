class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        int result = 0;
        
        Map<String , Integer>rowcount = new HashMap<>();

        for(int i=0; i<n;i++)
        {
            String rowkey = Arrays.toString(grid[i]);
            rowcount.put(rowkey,rowcount.getOrDefault(rowkey , 0)+1);
        }

        for (int j=0; j<n; j++)
        {
         int []col = new int [n];
         for(int i=0; i<n; i++)
         {
          col[i]=grid[i][j];
         }
         String colkey = Arrays.toString(col);
         result += rowcount.getOrDefault(colkey , 0);

        }
        return result;
    }
}