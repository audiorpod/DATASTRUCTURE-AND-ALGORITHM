package Array;

import java.util.Arrays;
import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // array of primitives 
        int[] arr = new int[5];
        // arr[0]=1;
        // arr[2]=2;
        // arr[3]=3;
        // arr[4]=4;
        //arr[5]=1;

        //System.out.println(arr[2]);

        // input using loop 

        for(int i = 0; i<arr.length; i++ ){
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(arr)); // converting into string 



        // for(int i = 0; i<arr.length; i++){
        //     System.out.println(arr[i]);
        // }



    // array of objects 
    String[] st = new String[5];
    for(int i = 0; i<st.length; i++){
        st[i] = sc.next();
    }
    System.out.println(Arrays.toString (st));



    // modify 

     

    }

    
}
