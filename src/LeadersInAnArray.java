//https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
//Given an array A of positive integers. Your task is to find the leaders in the array. An element of array is leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader.

import java.io.*;
import java.util.*;

public class LeadersInAnArray {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases

        while(t-->0){

            //input size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //inserting elements in the array
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }



            StringBuffer str = new StringBuffer();
            ArrayList<Integer> res = new ArrayList<Integer>();

            //calling leaders() function
            res = new LeadersInAnArray().leaders(arr, n);

            //appending result to a String
            for(int i=0; i<res.size(); i++){
                str.append(res.get(i)+" ");
            }

            //printing the String
            System.out.println(str);
        }

    }
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> result=new ArrayList();
        int maxSoFar=arr[n-1];
        result.add(maxSoFar);
        for(int i=n-2;i>-1;i--){
            if(arr[i]>=maxSoFar){
                maxSoFar=arr[i];
                result.add(maxSoFar);
            }


        }
        Collections.reverse(result);
        return result;
    }
}
