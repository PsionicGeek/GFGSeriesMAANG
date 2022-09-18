//https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1
//Given an expression string x. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
//For example, the function should return 'true' for exp = “[()]{}{[()()]()}” and 'false' for exp = “[(])”.
//
//Example 1:
//
//Input:
//{([])}
//Output:
//true
//Explanation:
//{ ( [ ] ) }. Same colored brackets can form
//balaced pairs, with 0 number of
//unbalanced bracket.

package String;
import java.util.*;
public class ParenthesisChecker {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        //Reading total number of testcases
        int t= sc.nextInt();

        while(t-- >0)
        {
            //reading the string
            String st = sc.next();

            //calling ispar method of Paranthesis class
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");

        }
    }
    static boolean ispar(String x)
    {
        if(x.length()%2==1)
            return false;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<x.length();i++){
            char c=x.charAt(i);
            if(c==')'||c=='}'||c==']'){
                if(stack.isEmpty())
                    return false;
                c=c==')'?'(':c=='}'?'{':'[';
                char r=stack.pop();
                if(r!=c)
                    return false;
            }else{
                stack.push(c);
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
