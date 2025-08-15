class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
       
       for(int n:nums1 )
        set1.add(n);

       for(int n:nums2)
       set2.add(n);

       Set<Integer> diff1 = new HashSet<>(set1);
       Set<Integer> diff2 = new HashSet<>(set2);

       diff1.removeAll(set2);
       diff2.removeAll(set1);

      List<List<Integer>> ls = new ArrayList<>();
       ls.add(new ArrayList(diff1));
       ls.add(new ArrayList(diff2));

       return ls;
    }
}