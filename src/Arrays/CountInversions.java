package Arrays;//https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
//Given an array of integers. Find the Inversion Count in the array.
//
//Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted.
//If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum.
//Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.



import java.util.*;
public class CountInversions {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];

            for(long i = 0; i < n; i++)
                arr[(int)i] = sc.nextLong();

            System.out.println(new CountInversions().inversionCount(arr, n));

        }
    }
    static long inversionCount(long arr[], long N)
    {

        return mergeSortAndCount(arr,0,N-1);
    }
    static long mergeSortAndCount(long[] arr, long l,
                                  long r)
    {

        long count = 0;

        if (l < r) {
            long m = (l + r) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count += mergeSortAndCount(arr, l, m);

            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, r);

            // Merge count
            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }
    static long mergeAndCount(long[] arr, long l,
                              long m, long r)
    {

        // Left subarray
        long[] left = Arrays.copyOfRange(arr, (int)l, (int)(m + 1));

        // Right subarray
        long[] right = Arrays.copyOfRange(arr, (int)(m + 1),(int)(r + 1));

        int i = 0, j = 0, k = (int)l;long swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swaps;
    }
}
