//https://practice.geeksforgeeks.org/problems/remove-duplicates3034/1
//Given a string without spaces, the task is to remove duplicates from it.
//
//Note: The original order of characters must be kept the same.
//
//Example 1:
//
//Input: S = "zvvo"
//Output: "zvo"
//Explanation: Only keep the first
//occurrence
//Expected Time Complexity: O(|s|)
//Expected Auxiliary Space: O(constant)

package String;
import java.io.*;
public class RemoveDuplicates {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();


            String result = new RemoveDuplicates().removeDups(s);

            System.out.println(result);
        }
    }

      String removeDups(String str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (res.indexOf(str.charAt(i)) == -1) {
                res += str.charAt(i);
            }
        }
        return res;
    }
}
