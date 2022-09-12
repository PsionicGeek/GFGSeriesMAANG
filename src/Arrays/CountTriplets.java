package Arrays;//https://practice.geeksforgeeks.org/problems/count-the-triplets4615/1
//Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountTriplets {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");

            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }


            System.out.println(new CountTriplets().countTriplet(arr, n));
        }
    }
    int countTriplet(int arr[], int n) {
        int count = 0;
        Arrays.sort(arr);
        for(int i=n-1;i>=2;i--){
            int start=0;
            int end=i-1;
            while(start<end){

                int ts=arr[start]+arr[end];
                if(ts<arr[i]){
                    start++;
                }
                else if(ts>arr[i]){
                    end--;

                }
                else{
                    count++;
                    start++;
                    end--;
                }
            }

        }
        return count;
    }
}


