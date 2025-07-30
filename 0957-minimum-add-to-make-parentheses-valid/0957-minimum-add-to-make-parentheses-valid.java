class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, res = 0;
        for(char ch: s.toCharArray()){
            if(ch == '(')
                open++;
            else{
                open--;
                if(open<0){
                    open = 0;
                    res++;
                }
            }
        }
        return res + open;
    }
}