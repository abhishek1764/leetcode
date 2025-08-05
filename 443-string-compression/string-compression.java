class Solution {
    public int compress(char[] chars) {
     int index = 0; 
        int i = 0;     

        while (i < chars.length) {
            char ch = chars[i]; 
            int count = 0;

           
            while (i < chars.length && chars[i] == ch) {
                count++;
                i++;
            }

           
            chars[index++] = ch;

           
            if (count > 1) {
                String str = Integer.toString(count);
                for (char digit : str.toCharArray()) {
                    chars[index++] = digit;
                }
            }
        }

        return index;    
    }
}