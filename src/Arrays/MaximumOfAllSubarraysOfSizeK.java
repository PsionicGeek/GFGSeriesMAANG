package Arrays;//https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
//Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.
//Example:-
//Input:
//N = 9, K = 3
//arr[] = 1 2 3 1 4 5 2 3 6
//Output:
//3 3 4 5 5 5 6
//Explanation:
//1st contiguous subarray = {1 2 3} Max = 3
//2nd contiguous subarray = {2 3 1} Max = 3
//3rd contiguous subarray = {3 1 4} Max = 4
//4th contiguous subarray = {1 4 5} Max = 5
//5th contiguous subarray = {4 5 2} Max = 5
//6th contiguous subarray = {5 2 3} Max = 5
//7th contiguous subarray = {2 3 6} Max = 6

import java.util.*;
public class MaximumOfAllSubarraysOfSizeK {
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        //taking total count of testcases
        int t = sc.nextInt();



        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();

            //taking size of subArrays
            int k = sc.nextInt();

            //Declaring and Intializing an array of size n
            int arr[] = new int[n];

            //adding all the elements to the array
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }

            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new MaximumOfAllSubarraysOfSizeK().max_of_subarrays(arr, n, k);

            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
    static ArrayList <Integer> max_of_subarrays(int nums[], int n, int k)
    {
        ArrayList<Integer> result=new ArrayList<>();
        if(nums.length==1||k==1){
            for(int i:nums){
                result.add(i);
            }
            return result;
        }

        int max1=nums[0];
        int in1=0;
        int in2=0;
        int max2=nums[1];
        for(int i=1;i<k;i++){
            if(nums[i]>=max1){
                in2=in1;
                max2=max1;
                in1=i;
                max1=nums[i];
            }
        }
        result.add(max1);
        int start=1;
        int end=k;
        while(end<nums.length){
            if(nums[end]>=max1){
                max2=max1;
                in2=in1;
                max1=nums[end];
                in1=end;
                end++;
                result.add(max1);

            }
            else{
                if(nums[end]>=max2){
                    max2=nums[end];
                    in2=end;
                }

                if(in1<=end-k||in2<=end-k){
                    max1=nums[end-k+1];

                    for(int i=end-k+1;i<=end;i++){
                        if(nums[i]>=max1){
                            in2=in1;
                            max2=max1;
                            in1=i;
                            max1=nums[i];
                        }
                    }
                }


                end++;
                result.add(max1);

            }
        }
        return result;
    }
}
