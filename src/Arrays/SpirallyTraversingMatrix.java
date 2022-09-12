package Arrays;//https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
//Given a matrix of size r*c. Traverse the matrix in spiral form.
//Example:
//
//Input:
//r = 4, c = 4
//matrix[][] = {{1, 2, 3, 4},
//           {5, 6, 7, 8},
//           {9, 10, 11, 12},
//           {13, 14, 15,16}}
//Output:
//1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

import java.io.IOException;
import java.util.*;
public class SpirallyTraversingMatrix {
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                    matrix[i][j] = sc.nextInt();
            }
            ArrayList<Integer> ans = new SpirallyTraversingMatrix().spirallyTraverse(matrix, r, c);
            for (Integer val: ans)
                System.out.print(val+" ");
            System.out.println();
        }
    }
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int m, int n)
    {
        ArrayList<Integer> result=new ArrayList<Integer>();
        int k=0,l=0,i;
        while(k<m&&l<n){
            for(i=l;i<n;i++){
                result.add(matrix[k][i]);
            }
            k++;
            for(i=k;i<m;i++){
                result.add(matrix[i][n-1]);

            }
            n--;
            if(k<m){
                for(i=n-1;i>=l;i--){
                    result.add(matrix[m-1][i]);

                }
                m--;
            }
            if(l<n){
                for(i=m-1;i>=k;i--){
                    result.add(matrix[i][l]);
                }
                l++;
            }
        }
        return result;
    }

}
