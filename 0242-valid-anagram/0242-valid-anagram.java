class Solution {
    public boolean isAnagram(String s, String t) {
        String s1 = s.replaceAll("\\s","");
        String s2 = t.replaceAll("\\s","");
        if(s1.length() != s2.length())
            return false;
        else{
            char[] arrayS1 = s1.toCharArray();
            char[] arrayS2 = s2.toCharArray();
            Arrays.sort(arrayS1);
            Arrays.sort(arrayS2);
            return Arrays.equals(arrayS1, arrayS2);
        }
    }
}