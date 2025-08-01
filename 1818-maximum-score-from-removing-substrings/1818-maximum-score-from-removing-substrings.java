class Solution {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        String top, bot;
        int top_score, bot_score;

        if(y>x){
            top = "ba";
            top_score = y;
            bot = "ab";
            bot_score = x;
        }
        else{
            top=  "ab";
            top_score = x;
            bot = "ba";
            bot_score = y;
        }

        StringBuilder stack = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(ch == top.charAt(1) && stack.length() > 0 && stack.charAt(stack.length() - 1) == top.charAt(0)){
                res += top_score;
                stack.setLength(stack.length() - 1);
            }
            else
                stack.append(ch);
        }
        StringBuilder newStack = new StringBuilder();
        for(char ch: stack.toString().toCharArray()){
            if(ch == bot.charAt(1) && newStack.length() > 0 && newStack.charAt(newStack.length() - 1) == bot.charAt(0)){
                res += bot_score;
                newStack.setLength(newStack.length() - 1);
            }
            else
                newStack.append(ch);
        }
        return res;
    }
}