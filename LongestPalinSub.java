public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {

        /* 这道题开始脑子比较蒙, 上来就用暴力算法, 就是查找string的所有substring, 找出最大的. 后来发现怎么都做不出来, 
            而且是时间复杂度在n^3, 而且还到点了....各种挫败感, 于是猛然发现是到dp题, 就写了一下dp. test case过了80%. 
            后来看了一些solution, 完成完成的... 很不应该! */
        /* 这个是最开始写的暴力解法. */
        // Write your code here
        //     int beginIndex = 0;
        //     int maxLength = 0;
        //     for (int i = 0; i < s.length()-1; i++) {
        //         beginIndex = i;
        //         for (int j = i+1; j < s.length(); j++) {
        //             if (s.charAt(j) == s.charAt(beginIndex)) {
        //                 String temp = s.substring(beginIndex, j+1);
        //                 boolean isPanlindromeResult = isPanlindrome(s.substring(beginIndex, j+1));
        //                 if (isPanlindromeResult) {
        //                     int tempLength = s.substring(beginIndex, j+1).length();
        //                     // System.out.println(tempLength);
        //                     if (tempLength > maxLength) {
        //                         maxLength = tempLength;
        //                     }
        //                 }
        //             }
        //         }
                
        //     }
        //     return s.substring(beginIndex, maxLength);
        // }

        /*这个是后来写的dp解法. */
        
       if(s == null || s.length() <= 1)
            return s;
     
        int len = s.length();
        int maxLen = 1;
        boolean [][] dp = new boolean[len][len];
     
        String longest = null;
        for(int l = 0; l < s.length(); l++){
            for(int i = 0; i < len - l; i++){
                int j = i + l;
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
     
                    if(j - i + 1 > maxLen){
                       maxLen = j - i + 1; 
                       longest = s.substring(i, j + 1);
                    }
                }
            }
        }
     
        return longest;
    }
}