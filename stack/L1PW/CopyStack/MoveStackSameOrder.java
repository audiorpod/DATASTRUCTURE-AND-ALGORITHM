package stack.L1PW.CopyStack;

import java.util.Scanner;
import java.util.Stack;

public class MoveStackSameOrder {

   public static void main(String[] args) {

    /**
     * // taking input through scanner class 
    Scanner sc = new Scanner(System.in);
    Stack<Integer> st = new Stack<>();
    // // taking the  input of 4 stack element 
    // int n;
    // System.out.println("enter the no element  you want to insert ");
    // n= sc.nextInt(); // taking the input 
    // System.out.println("Enter the element : ");
    // for (int i = 1; i<=n;i++){
    //     int x = sc.nextInt();
    //     st.push(x);
     * 
     */
//------------------------------------------------------------------------------------------------------------


        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
       System.out.println(st);

       // Putting the stack in reverse order 

       Stack<Integer> reverse= new Stack<>();
       while (st.size()>0) {
        int x = st.peek();
        reverse.push(x);
        st.pop();
        
       }
       System.out.println(reverse);

    }
    

   }

