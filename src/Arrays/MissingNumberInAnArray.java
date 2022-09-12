package Arrays;//https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1
//Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.


import java.io.*;

public class MissingNumberInAnArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }

            System.out.println(MissingNumber(array, n));
        }
    }
    static  int MissingNumber(int array[], int n) {
        // Your Code Here
        int sumT=n*(n+1)/2;
        int sumA=0;
        for(int i=0;i<n-1;i++){
            sumA+=array[i];
        }
        return sumT-sumA;

    }

}
