//https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1
//Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on.
//Note: Modify the original array itself.

import java.io.*;
public class RearrangeArrayAlternatively {
    public static void main (String[] args)throws IOException
    {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //testcases
        int t = Integer.parseInt(read.readLine());

        while(t-- >0)
        {
            //size of array
            int n = Integer.parseInt(read.readLine());
            long[] arr= new long[n];

            String str[] = read.readLine().trim().split(" ");

            //adding elements to the array
            for(int i=0;i<n;i++)
                arr[i] = Long.parseLong(str[i]);

            // StringBuffer sb = new StringBuffer();

            rearrange(arr, n);
            StringBuffer sb = new StringBuffer();

            //appending and printing the elements
            for(int i =0; i < n; i++)
                sb.append(arr[i] + " ");
            System.out.println(sb);
        }
    }
    public static void rearrange(long arr[], int n){
        int min=0;
        int max=n-1;
        long max_Element=arr[max]+1;
        for(int i=0;i<n;i++){
            if(i%2==0){
                arr[i]=arr[i]+(arr[max]%max_Element)*max_Element;
                max--;
            }
            else{
                arr[i]=arr[i]+(arr[min]%max_Element)*max_Element;
                min++;
            }
        }
        for(int i=0;i<n;i++){
            arr[i]=arr[i]/max_Element;
        }

    }
}
