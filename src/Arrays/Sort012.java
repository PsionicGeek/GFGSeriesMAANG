package Arrays;//https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1

//Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.

import java.io.*;
public class Sort012 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
    public static void sort012(int a[], int n)
    {
        // code here
        int zero=0,ones=0;
        for(int i=0;i<n;i++){
            if(a[i]==0)
                zero++;
            else if(a[i]==1){
                ones++;
            }

        }
        for(int i=0;i<n;i++){
            if(zero!=0){
                a[i]=0;
                zero--;
            }
            else if(ones!=0){
                a[i]=1;
                ones--;
            }
            else{
                a[i]=2;

            }
        }
    }
}
