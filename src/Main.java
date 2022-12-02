public class Main {
    public static void main(String[] args) {
        System.out.println(minSteps(2,2));
    }
    public static int sol(int a, int b, int x, int y, int c){
        if( a == x && b == y)
            return c;
        else if(a > x || b > y)
            return -1;
        else{
            int z= sol(a+b, a, x, y,c+1);
            return z!=-1?z:sol(a, a+b, x, y,c+1);

        }
    }
    public static int minSteps(int input1, int input2){
        return sol(1,1,input1,input2,0);
    }
}