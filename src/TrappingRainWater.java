/*
https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
Given an array arr[] of N non-negative integers representing the height of blocks.
If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season.
Example
Input:
N = 4
arr[] = {7,4,0,9}
Output:
10
Explanation:
Water trapped by above
block of height 4 is 3 units and above
block of height 0 is 7 units. So, the
total unit of water trapped is 10 units.
*/



import java.io.*;
public class TrappingRainWater {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){

            //size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements to the array
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }



            //calling trappingWater() function
            System.out.println(new TrappingRainWater().trappingWater(arr, n));
        }
    }
    static long trappingWater(int arr[], int n) {
        int l=0,r=n-1,ml=0,mr=0;
        long total=0;
        while(l<r){
            if(arr[l]<=arr[r]){
                if(arr[l]>ml){
                    ml=arr[l];
                }
                else{
                    total+=ml-arr[l];
                }
                l++;
            }
            else{
                if(arr[r]>mr){
                    mr=arr[r];
                }
                else{
                    total+=mr-arr[r];
                }
                r--;
            }
        }
        return total;
    }
}
