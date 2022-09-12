package Arrays;//https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion/0
//Given an array arr of distinct elements of size N, the task is to rearrange the elements of the array in a zig-zag fashion
//so that the converted array should be in the below form:
//arr[0] < arr[1]  > arr[2] < arr[3] > arr[4] < . . . . arr[n-2] < arr[n-1] > arr[n].
//Example:
//
//Input:
//N = 7
//Arr[] = {4, 3, 7, 8, 6, 2, 1}
//Output: 3 7 4 8 2 6 1
//Explanation: 3 < 7 > 4 < 8 > 2 < 6 > 1


import java.io.*;
public class ZigZagFashion {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new ZigZagFashion().zigZag(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
    void zigZag(int arr[], int n) {
        // code here
        boolean flag=true;
        for(int i=0;i<=n-2;i++){
            if(flag){
                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }

            else{
                if(arr[i]<arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
            flag=!flag;
        }

    }
}
