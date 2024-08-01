package recursion2;

public class fibonaci {

    public static int f(int n ){
        //base case 
        if ( n == 0 ||  n == 1) return n;
        return f(n-1) + f(n-2);
    }
    public static void main(String[] args) {
        System.out.println (f(6));
    }
    
}
