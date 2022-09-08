//https://practice.geeksforgeeks.org/problems/unsorted-array4925/1
//Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.
//
//Note: Left and right side elements can be equal to required element. And extreme elements cannot be required element.
//Example:-
//Example :
//
//Input:
//N = 4
//A[] = {4, 2, 5, 7}
//Output:
//5
//Explanation:
//Elements on left of 5 are smaller than 5
//and on right of it are greater than 5.




import java.io.*;
public class ElementsOnLeftSmallerAndOnRightGreater {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }


            System.out.println(new ElementsOnLeftSmallerAndOnRightGreater().findElement(a, n));

        }
    }
    public int findElement(int arr[], int n){
        int[] minRight=new int[n];
        minRight[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(arr[i]<=minRight[i+1]){
                minRight[i]=arr[i];
            }
            else{
                minRight[i]=minRight[i+1];
            }
        }
        int maxLeft=arr[0];
        for(int i=0;i<n-1;i++){
            if(maxLeft<=arr[i]&&arr[i]<=minRight[i]){
                if(i==0||i==n-1){
                    continue;
                }
                return arr[i];
            }
            maxLeft=Math.max(maxLeft,arr[i]);
        }
        return -1;
    }
}
