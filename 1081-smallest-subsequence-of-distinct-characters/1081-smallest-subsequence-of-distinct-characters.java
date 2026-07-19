class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        StringBuilder st = new StringBuilder();

        for(int i = 0; i<s.length(); i++){
            lastIndex[s.charAt(i) - 'a'] = i;
        } 
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(visited[ch - 'a']){
                continue;
            }
            while(!stack.isEmpty() 
                && stack.peek() > ch
                && lastIndex[stack.peek() - 'a'] > i
            ){
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
            visited[ch - 'a'] = true;
        }
        for(char c : stack){
            st.append(c);
        }
        return st.toString();
    }
}