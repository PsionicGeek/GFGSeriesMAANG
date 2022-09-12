package Arrays;//https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
//Given an array arr[] and an integer K where K is smaller than size of array, the task is to find the Kth smallest element in the given array.
//It is given that all array elements are distinct.

import java.io.PrintWriter;
import java.util.*;
public class KthSmallestElement {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t=sc.nextInt();

        while(t-->0)
        {
            int n=sc.nextInt();

            int arr[]=new int[n];

            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();

            int k=sc.nextInt();
            out.println(new KthSmallestElement().kthSmallest(arr, 0, n-1, k));
        }
        out.flush();
    }
    public static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high], pivotloc = low;
        for (int i = low; i <= high; i++) {
        if (arr[i] < pivot) {
            int temp = arr[i];
            arr[i] = arr[pivotloc];
            arr[pivotloc] = temp;
            pivotloc++;
        }
    }
        int temp = arr[high];
        arr[high] = arr[pivotloc];
        arr[pivotloc] = temp;

        return pivotloc;
    }
    public static int kthSmallest(int[] arr, int low, int high, int k)
    {

        int partition = partition(arr, low, high);

        if (partition == k - 1)
            return arr[partition];
        else if (partition < k - 1)
            return kthSmallest(arr, partition + 1, high, k);
        else
            return kthSmallest(arr, low, partition - 1, k);
    }
}
