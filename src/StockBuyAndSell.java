//https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1
//The cost of stock on each day is given in an array A[] of size N.
//Find all the segment of days on which you buy and sell the stock so that in between those days your profit is maximum.
//Note: Since there can be multiple solutions, the driver code will return 1 if your answer is correct, otherwise, it will return 0.
//In case there's no profit the driver code will return the string "No Profit" for a correct solution.
//Example:-
//Input:
//N = 7
//A[] = {100,180,260,310,40,535,695}
//Output:
//1
//Explanation:
//One possible solution is (0 3) (4 6)
//We can buy stock on day 0,
//and sell it on 3rd day, which will
//give us maximum profit. Now, we buy
//stock on day 4 and sell it on day 6.


import java.io.*;
import java.util.*;
public class StockBuyAndSell {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int A[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                A[i] = Integer.parseInt(inputLine[i]);
            }
            int p = 0;
            for(int i=0; i<n-1; i++)
                p += Math.max(0,A[i+1]-A[i]);


            ArrayList<ArrayList<Integer> > ans = new StockBuyAndSell().stockBuySell(A, n);
            if(ans.size()==0)
                System.out.print("No Profit");
            else{
                int c=0;
                for(int i=0; i<ans.size(); i++)
                    c += A[ans.get(i).get(1)]-A[ans.get(i).get(0)];

                if(c==p)
                    System.out.print(1);
                else
                    System.out.print(0);
            }System.out.println();
        }
    }
    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {

        // code here
        ArrayList<ArrayList<Integer> > result=new ArrayList<ArrayList<Integer> >();
        if(n==1)
            return result;
        int i=0;
        while(i<n-1){
            while((i<n-1)&&(A[i+1]<=A[i]))
                i++;
            if(i==n-1)
                break;
            ArrayList<Integer> l=new ArrayList<>();
            l.add(i++);
            while((i<n)&&(A[i-1]<=A[i]))
                i++;

            l.add(i-1);
            result.add(l);
        }
        return result;
    }
}
