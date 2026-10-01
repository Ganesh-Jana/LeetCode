class Solution {
    public boolean isValid(String s) {
        char[] s1 = new char[s.length()];
        int top = -1;
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[') s1[++top] = ch;
            else{
                if(top == -1) return false;
                char open = s1[top--];
                if((ch == ')' && open != '(') || 
                (ch == '}' && open != '{') || 
                (ch == ']' && open != '[')
                ) return false;
            }
        }
        return top == -1;
    }
}