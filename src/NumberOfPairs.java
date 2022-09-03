//https://practice.geeksforgeeks.org/problems/number-of-pairs-1587115620/1
//Given two arrays X and Y of positive integers, find the number of pairs such that x^y > y^x (raised to power of) where x is an element from X and y is an element from Y.

import java.io.*;
import java.util.Arrays;

public class NumberOfPairs {
    public static void main (String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int g = 0;g < t;g++)
        {
            String[] str = (br.readLine()).trim().split(" ");
            int M = Integer.parseInt(str[0]);
            int N = Integer.parseInt(str[1]);

            int[] x = new int[M];
            str = (br.readLine()).trim().split(" ");
            for(int i = 0;i< M;i++)
                x[i] = Integer.parseInt(str[i]);

            str = (br.readLine()).trim().split(" ");
            int[] y = new int[N];
            for(int i = 0;i< N;i++)
            {
                y[i] = Integer.parseInt(str[i]);

            }
            System.out.println(new NumberOfPairs().countPairs(x, y, M, N));

        }
    }
    static int getIndex(int y[] , int n , int ele){

        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(y[mid] >ele){
                ans = mid;
                high  =mid -1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }
    static long countPairs(int x[], int y[], int m, int n)
    {

        Arrays.sort(y);
        int zeros = 0,one = 0 , three = 0 , four = 0,two= 0;
        for(int i  =0;i<n;i++){
            if(y[i]==0)zeros++;
            if(y[i]==1)one++;
            if(y[i]==3)three++;
            if(y[i]==4)four ++;
            if(y[i]==2)two++;
        }

        long ans = 0;
        for(int i =0;i<m;i++){
            if(x[i]==0){
                continue;
            }
            else if(x[i]==1){
                ans +=zeros;
            }
            else if(x[i]==2){
                int index = getIndex(y , n , 2);
                if(index != -1){
                    ans += n - index;
                }
                ans -=three;
                ans -=four;
                ans += one +zeros;
            }
            else{
                int index = getIndex(y , n , x[i]);
                if(index!=-1){
                    ans+=n-index;
                }
                ans += one +zeros;
                if(x[i]==3){
                    ans+=two;
                }
            }
        }
        return ans;

    }
}
