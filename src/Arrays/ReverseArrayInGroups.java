package Arrays;//https://practice.geeksforgeeks.org/problems/reverse-array-in-groups0255/1
//Given an array arr[] of positive integers of size N.
// Reverse every sub-array group of size K.
//Note: If at any instance, there are no more subarrays of size greater than or equal to K, then reverse the last subarray (irrespective of its size).


import java.io.*;
import java.util.*;

public class ReverseArrayInGroups {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases

        //while testcases exist
        while(t-->0){

            String inputLine1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine1[0]);
            int k = Integer.parseInt(inputLine1[1]);

            ArrayList<Integer> arr = new ArrayList<>();
            String inputLine2[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr.add(Integer.parseInt(inputLine2[i]));
            }


            new ReverseArrayInGroups().reverseInGroups(arr, n, k);

            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr.get(i) + " ");
            }
            System.out.println(str);
        }
    }
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        int start=0;
        int end=k;
        int c=n/k;
        while(c>0){
            List<Integer> newArray=arr.subList(start,end);
            Collections.reverse(newArray);
            int i=0;
            while(i<k){
                arr.set(start+i,newArray.get(i));
                i++;
            }
            start+=k;
            end+=k;
            c--;
        }
        if(end>n){
            List<Integer> newArray=arr.subList(start,n);
            Collections.reverse(newArray);
            int i=0;
            while(i<newArray.size()){
                arr.set(start+i,newArray.get(i));
                i++;
            }
        }

    }
}
