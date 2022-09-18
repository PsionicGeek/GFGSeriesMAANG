
//https://practice.geeksforgeeks.org/problems/anagram-1587115620/1
//Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, act and tac are an anagram of each other.
//
//Example 1:
//
//Input:a = geeksforgeeks, b = forgeeksgeeks
//Output: YES
//Explanation: Both the string have same characters with
//        same frequency. So, both are anagrams.

package String;
import java.io.*;
import java.util.*;
public class Anagram {
    public static void main (String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String str = br.readLine();
            String s1 = str.split(" ")[0];
            String s2 = str.split(" ")[1];


            if(isAnagram(s1,s2))
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }



        }
    }
    public static boolean isAnagram(String a,String b)
    {
        if(a.length()!=b.length())
            return false;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<a.length();i++){
            char c=a.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<b.length();i++){
            char c=b.charAt(i);
            int r=map.getOrDefault(c,0);
            if(r==0){
                return false;
            }
            map.put(c,r-1);
        }
        return true;

    }
}
