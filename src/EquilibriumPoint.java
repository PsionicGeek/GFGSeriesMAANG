
import java.io.*;
public class EquilibriumPoint {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");

            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }



            //calling equilibriumPoint() function
            System.out.println(new EquilibriumPoint().equilibriumPoint(arr, n));
        }
    }
    public static int equilibriumPoint(long arr[], int n) {

        long sumTotal=0;
        long sumLeft=0;
        for(int i=0;i<n;i++){
            sumTotal+=arr[i];
        }
        for(int i=0;i<n;i++){
            sumTotal-=arr[i];
            if(sumLeft==sumTotal)
                return i+1;
            sumLeft+=arr[i];

        }
        return -1;
    }
}
