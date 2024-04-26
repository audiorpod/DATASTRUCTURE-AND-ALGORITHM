package stack.L1PW;

import java.util.*;

// there are 3 Major operation 
/*
 * 1) st.push -> push the element on the top 
 * 2) st.pop   -> take out the element from the  top 
 * 3) st.peek -> Return the element which is present of on the top of the stack
 *  
 * 
 */

public class basics {
    public static void main(String[] args) {
        
        // declaration of the stack 
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(23);
        st.push(96);
        st.push(8);
        st.push(34);

        // peek function -> return element present on the top of the stack 

        System.out.println(st.peek());

        // to present complete stack 
        System.out.println( st);

        // st.pop -> remove the top element from the stack 
        System.out.println(st.pop());  // -> output 34

        System.out.println(st); //-> removed the first element from  the stack and printed the stack 
        st.pop();

        
        // printing the size of the stack 
        System.out.println("size of the stack : " + st.size());

        // printing the particular stack  through while loop 
         while (st.size()>2) {  // condition for printing 2 stack 
        st.pop();
            
         }
         System.out.println(st.peek()); // printing peek condition 
         System.out.println(st);        // after the peek condition  printing the stack 
    }


    
}
