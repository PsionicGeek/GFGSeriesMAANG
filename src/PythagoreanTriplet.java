
/*
https://practice.geeksforgeeks.org/problems/pythagorean-triplet3018/1
Given an array arr of N integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a^2 + b^2 = c^2, otherwise false.
Example:-
Input:
N = 5
Arr[] = {3, 2, 4, 6, 5}
Output: Yes
Explanation: a=3, b=4, and c=5 forms a
pythagorean triplet.

 */
import java.io.*;
import java.util.Arrays;

public class PythagoreanTriplet {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new PythagoreanTriplet().checkTriplet(arr, n);
            System.out.println(ans ? "Yes" : "No");
        }
    }
    boolean checkTriplet(int[] arr, int n) {
        Arrays.sort(arr);
        for(int i=n-1;i>=2;i--){
            int start=0;
            int end=i-1;
            while(start<end){

                int ts=(int)Math.pow(arr[start],2)+(int)Math.pow(arr[end],2);
                int ti=(int)Math.pow(arr[i],2);
                if(ts<ti){
                    start++;
                }
                else if(ts>ti){
                    end--;

                }
                else{
                    return true;
                }
            }

        }
        return false;
    }
}
