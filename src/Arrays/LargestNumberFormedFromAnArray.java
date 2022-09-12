package Arrays;//https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1
//Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.
// The result is going to be very large, hence return the result in the form of a string.
//
//Example:
//Input:
//N = 5
//Arr[] = {3, 30, 34, 5, 9}
//Output: 9534330
//Explanation: Given numbers are {3, 30, 34,
//5, 9}, the arrangement 9534330 gives the
//largest value.



import java.util.*;
import java.io.*;

public class LargestNumberFormedFromAnArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new LargestNumberFormedFromAnArray().printLargest(arr);
            System.out.println(ans);
        }
    }

    String printLargest(String[] arr) {

        Arrays.sort(arr, (a, b) -> {
            String one = a + b;
            String two = b + a;

            int i = 0;
            while (i < one.length()) {
                if (one.charAt(i) > two.charAt(i))
                    return 1;
                else if (one.charAt(i) < two.charAt(i))
                    return -1;
                ++i;
            }

            return 0;
        });
        String result = "";
        for (String s : arr) {
            result = s + result;
        }
        return result;
    }
}
