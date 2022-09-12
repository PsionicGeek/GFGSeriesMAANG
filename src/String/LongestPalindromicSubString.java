//https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
//Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index).
//
//Example 1:
//
//Input:
//S = "aaaabbaa"
//Output: aabbaa
//Explanation: The longest Palindromic
//substring is "aabbaa".

package String;
import java.io.*;
public class LongestPalindromicSubString {
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();


            System.out.println(longestPalin(S));
        }
    }
    static String longestPalin(String s){
        // code here
        boolean[][] dp=new boolean[s.length()][s.length()];
        String result="";
        for(int gap=0;gap<s.length();gap++){
            int count=0;
            for(int i=0, j=gap;j<s.length();i++,j++){
                if(gap==0){
                    dp[i][j]=true;
                }
                else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (gap == 1) {
                        dp[i][j] = b;
                    } else {
                        dp[i][j] = b && dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j]&&count==0){
                    result=s.substring(i,j+1);
                    count=1;
                }
            }
        }
        return result;

    }
}
