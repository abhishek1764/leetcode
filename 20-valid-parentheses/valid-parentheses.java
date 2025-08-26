class Solution {
    boolean isMatched(char opening, char closing){
            return (opening =='(' && closing == ')') ||
                   (opening =='[' && closing == ']') ||
            (opening =='{' && closing == '}'); 
    }
    public boolean isValid(String s) {
    Stack<Character>stack = new Stack<>();
     for(char bracket : s.toCharArray()){
        if(bracket == '(' || bracket == '[' || bracket == '{'){
            stack.push(bracket);

        }
        else if(!stack.isEmpty() && isMatched(stack.peek() ,bracket)){
            stack.pop();

        }
        else{
            return false;
        }
     }
     return stack.isEmpty();
    }
}