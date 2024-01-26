package com.arjun.leetcode._151_reverse_word;

class Solution {
    public String reverseWords(String s) {
        String[] tokens = s.split(" ");

        StringBuilder returnString = new StringBuilder();
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (!token.equals("")) {
                returnString.append(token).append(" ");
            }
        }
        returnString.delete(returnString.lastIndexOf(" "), returnString.length());
        return returnString.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().reverseWords("            hello world  ");
        System.out.println(s);

        s = new Solution().reverseWords("the sky is blue");
        System.out.println(s);

        s = new Solution().reverseWords("a good   example");
        System.out.println(s);
    }
}