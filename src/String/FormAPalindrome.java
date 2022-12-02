//https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1
//Form a palindrome
//Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
//For Example:
//ab: Number of insertions required is 1. bab or aba
//aa: Number of insertions required is 0. aa
//abcd: Number of insertions required is 3. dcbabcd
//Example 1:
//
//Input: str = "abcd"
//Output: 3
//Explanation: Inserted character in dcbabcd
//Example 2:
//
//Input: str = "aa"
//Output: 0
//Explanation:"aa" is already a palindrome.

package String;

import java.io.*;

public class FormAPalindrome {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str = read.readLine();


            System.out.println(countMin(str));
        }
    }

    static int countMin(String str) {
        return str.length() - longestPalin(str);
    }

    static int longestPalin(String str) {

        int[][] dp = new int[str.length()][str.length()];

        for (int gap = 0; gap < str.length(); gap++) {

            for (int i = 0, j = gap; j < str.length(); i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else {

                    if (gap == 1) {
                        dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 1;
                    } else {
                        if (str.charAt(i) == str.charAt(j)) {
                            dp[i][j] = 2 + dp[i + 1][j - 1];
                        } else {
                            dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                        }
                    }
                }

            }
        }
        return dp[0][str.length() - 1];

    }
}
