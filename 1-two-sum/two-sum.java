class Solution{
     public int[] twoSum(int[] numbers, int target) {
     HashMap<Integer ,Integer> map= new HashMap<>();
     for(int i=0; i<numbers.length; i++)
     {
        int rem = target-numbers[i];
        if(map.containsKey(rem)){
            return new int[] {i,map.get(rem)};
        }
        map.put(numbers[i] ,i);//put(key value)

     }
     return null;

     }
}






// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         int left=0;
//         int right=numbers.length-1;
//         int n1 = 0;
//         int n2 = 0;
//         int aux[] = Arrays.copyOf(numbers ,numbers.length);
//         Arrays.sort(numbers);
//         while(left<right){
//         int sum = numbers[left] +numbers[right];
         
//             if(sum == target){
//             n1 =numbers[left];
//             n2 = numbers[right];
//                 break;

//             }
//             else if
//                 (sum>target)
//                 {
//                     right--;
//                 }
//             else if(sum<target)
//             {
//                 left++;
//             }
//         }
//         int index1=-1;
//         int index2 =-1;
//         for(int i=0; i<aux.length; i++){
//         if(index1==-1 && aux[i] == n1){
//             index1=i;

//         }
//        else if(index2==-1 && aux[i]==n2){
//         index2=i;
//         }
//         }
//         return new int[]{index1 ,index2};
//     }
    
// }
