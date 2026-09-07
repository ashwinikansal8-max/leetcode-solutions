class Solution {
    public boolean match(char a,char b)
    {
        if( (a=='(' && b==')') || (a=='{' && b=='}') ||(a=='[' && b==']') )
        return true;
        else 
        return false ;
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[' ) st.push(ch);
            else if(ch==')' || ch=='}' || ch==']')
            {   
                if(st.empty() || match(st.peek(),ch)==false ) return false;
                else {
                    st.pop();
                }
            }
        }
        if(st.empty()) return true;
        else
        return false;
    }
}