class Solution {
    public int maxVowels(String s, int k) {
     String vowels="aeiou";
     int count=0;
     int maxcount=0;
     for (int i=0; i<k; i++){
     if( vowels.indexOf(s.charAt(i))!=-1)
     {
        count++;
     }
     }
     maxcount = count;
     for(int i=k; i<s.length(); i++)
     {
        if(vowels.indexOf(s.charAt(i-k))!=-1)
        {
            count--;

        }
         if(vowels.indexOf(s.charAt(i))!=-1)
        {
            count++;

        }
        maxcount = Math.max(maxcount , count);


     }
     return maxcount;
     
    }
}