package Arrays;//https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
//Given an array of integers. Find the Inversion Count in the array.
//
//Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum.
//Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

import java.io.*;
public class EquilibriumPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }



            //calling equilibriumPoint() function
            System.out.println(new EquilibriumPoint().equilibriumPoint(arr, n));
        }
    }
    public static int equilibriumPoint(long arr[], int n) {

        long sumTotal=0;
        long sumLeft=0;
        for(int i=0;i<n;i++){
            sumTotal+=arr[i];
        }
        for(int i=0;i<n;i++){
            sumTotal-=arr[i];
            if(sumLeft==sumTotal)
                return i+1;
            sumLeft+=arr[i];

        }
        return -1;
    }
}
