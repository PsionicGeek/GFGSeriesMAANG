//https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
//Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order without using any extra space. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.


import java.io.*;

public class MergeWithoutExtraSpace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            long arr1[] = new long[n];
            long arr2[] = new long[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Long.parseLong(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Long.parseLong(inputLine[i]);
            }
            merge(arr1, arr2, n, m);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr1[i] + " ");
            }
            for (int i = 0; i < m; i++) {
                str.append(arr2[i] + " ");
            }
            System.out.println(str);
        }
    }

    public static void merge(long ar1[], long ar2[], int n, int m) {
        // code here
        int gap = (int) Math.ceil((double) (n + m) / 2.0);
        while (gap > 0) {
            int i = 0;
            int j = gap;
            while (j < (n + m)) {
                if (j < n && ar1[i] > ar1[j]) {

                    long temp = ar1[i];
                    ar1[i] = ar1[j];
                    ar1[j] = temp;
                } else if (j >= n && i < n && ar1[i] > ar2[j - n]) {

                    long temp = ar1[i];
                    ar1[i] = ar2[j - n];
                    ar2[j - n] = temp;
                } else if (j >= n && i >= n && ar2[i - n] > ar2[j - n]) {

                    long temp = ar2[i - n];
                    ar2[i - n] = ar2[j - n];
                    ar2[j - n] = temp;
                }
                j++;
                i++;
            }
            if (gap == 1) {
                gap = 0;
            } else {
                gap = (int) Math.ceil((double) gap / 2.0);
            }
        }
    }
}
