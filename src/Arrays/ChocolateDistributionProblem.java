package Arrays;//https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
//Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet.
// Each packet can have a variable number of chocolates.
// There are M students, the task is to distribute chocolate packets among M students such that :
//1. Each student gets exactly one packet.
//2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.


import java.util.*;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
            int m = sc.nextInt();
            System.out.println(new ChocolateDistributionProblem().findMinDiff(arr, n, m));
        }

    }

    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        Collections.sort(a);
        long result = a.get(m - 1) - a.get(0);
        for (int i = 1; i < n - m + 1; i++) {
            result = Math.min(result, a.get(i + m - 1) - a.get(i));
        }
        return result;
    }
}
