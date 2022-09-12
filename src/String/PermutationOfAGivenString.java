//https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0
//Given a string S. The task is to print all unique permutations of the given string in lexicographically sorted order.
//
//Example:
//
//Input: ABC
//Output:
//ABC ACB BAC BCA CAB CBA
//Explanation:
//Given string ABC has permutations in 6
//forms as ABC, ACB, BAC, BCA, CAB and CBA.



package String;
import java.io.*;
import java.util.*;
public class PermutationOfAGivenString {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();

            List<String> ans = new PermutationOfAGivenString().find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();

        }
    }
    Set<String> result=new HashSet<>();
    public List<String> find_permutation(String S) {
        // Code here
        permute(S,0,S.length()-1);
        List<String> s=new ArrayList<>(result);
        Collections.sort(s);
        return s ;
    }
    public void permute(String s,int l,int r){
        if(l==r){
            result.add(s);
            return;
        }
        for(int i=l;i<=r;i++){
            s=swap(s,l,i);
            permute(s,l+1,r);
            s=swap(s,l,i);
        }
    }
    String swap(String str, int i, int j)
    {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
