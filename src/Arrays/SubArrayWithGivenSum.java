package Arrays;//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
//Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array which adds to a given number S.
//
//In case of multiple subarrays, return the subarray which comes first on moving from left to right.


import java.util.ArrayList;
import java.util.Scanner;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }


            ArrayList<Integer> res = new SubArrayWithGivenSum().subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {

        ArrayList<Integer> subSum=new ArrayList<>();
        if(s<=0){
            subSum.add(-1);
            return subSum;
        }
        int sum=0;
        int start=0;
        int end=0;
        for(int i=0;i<n;i++){

            sum+=arr[i];
            end++;
            if(sum>s){
                while(sum>s){
                    int t=arr[start];
                    sum-=t;
                    start++;}
            }
            if(sum==s){
                subSum.add(start+1);
                subSum.add(end);
                return subSum;
            }

        }
        subSum.add(-1);
        return subSum;
    }
}