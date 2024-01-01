import java.util.*;

public class factorial {
     public static int f(int n){
        // base case 
        if(n ==1) return 1;
        int assumption = f(n-1); // function work correctly for n-1
        return n * assumption;
     }
    public static void main(String[] args){    
    System.out.println(f(6));   
    }   
}
