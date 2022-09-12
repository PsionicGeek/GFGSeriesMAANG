package Arrays;//https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
//Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.

import java.io.*;
public class KadaneAlgorithm {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }


            //calling maxSubarraySum() function
            System.out.println(new KadaneAlgorithm().maxSubarraySum(arr, n));
        }
    }
    long maxSubarraySum(int arr[], int n){

        long maxSum=arr[0];
        long currMax=arr[0];
        for(int i=1;i<n;i++){
            currMax=Math.max(currMax+arr[i],arr[i]);
            maxSum=Math.max(maxSum,currMax);
        }
        return maxSum;

    }
}
