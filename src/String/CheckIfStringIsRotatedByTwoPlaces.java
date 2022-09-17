//https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places-1587115620/1
//Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating another string 'a' by exactly 2 places.
//
//Example 1:
//
//Input:
//a = amazon
//b = azonam
//Output: 1
//Explanation: amazon can be rotated anti
//clockwise by two places, which will make
//it as azonam.

package String;
import java.util.*;
public class CheckIfStringIsRotatedByTwoPlaces {

    private static boolean isRotated(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String clock_rot = "";
        String anticlock_rot = "";
        int len = str2.length();

        // Initialize string as anti-clockwise rotation
        anticlock_rot = anticlock_rot +
                str2.substring(len - 2, len) +
                str2.substring(0, len - 2);

        // Initialize string as clock wise rotation
        clock_rot = clock_rot +
                str2.substring(2) +
                str2.substring(0, 2);

        // check if any of them is equal to string1
        return (str1.equals(clock_rot) ||
                str1.equals(anticlock_rot));
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        String s12 = sc.nextLine();
        for(int i=0; i<t; i++){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();



            boolean flag = isRotated(s1, s2);

            if(flag == true) System.out.println("1");
            else System.out.println("0");

        }
    }
}
