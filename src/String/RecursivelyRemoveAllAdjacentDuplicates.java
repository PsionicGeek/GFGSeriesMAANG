//https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates0744/1

//Given a string s, remove all its adjacent duplicate characters recursively.
//
//Example 1:
//
//Input:
//S = "geeksforgeek"
//Output: "gksforgk"
//Explanation:
//g(ee)ksforg(ee)k -> gksforgk
//
//Example 2:
//
//Input:
//S = "abccbccba"
//Output: ""
//Explanation:
//ab(cc)b(cc)ba->abbba->a(bbb)a->aa->(aa)->""(empty string)
//Expected Time Complexity: O(|S|)
//Expected Auxiliary Space: O(|S|)


package String;
import java.io.*;
public class RecursivelyRemoveAllAdjacentDuplicates {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();

            System.out.println(new RecursivelyRemoveAllAdjacentDuplicates().rremove(S));
        }
    }
    String rremove(String s) {
        int n = s.length();
        if(n==0 || n==1) return s;
        StringBuilder sb = new StringBuilder();
        if(s.charAt(0)!=s.charAt(1)){
            sb.append(s.charAt(0));
        }
        for(int i=1;i<n-1;i++){
            if(s.charAt(i-1)==s.charAt(i) || s.charAt(i)==s.charAt(i+1)){
                continue;
            }
            else sb.append(s.charAt(i));
        }
        if(s.charAt(n-2)!=s.charAt(n-1)){
            sb.append(s.charAt(n-1));
        }
        if(sb.length()==n){
            return sb.toString();
        }
        return rremove(sb.toString());
    }
}
