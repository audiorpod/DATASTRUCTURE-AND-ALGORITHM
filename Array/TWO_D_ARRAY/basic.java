package Array.TWO_D_ARRAY;
import java.util.*;

import java.util.Scanner;

public class basic {
    public static void main(String[] args) {
        /**
         * 1 2 3
         * 4 5 6
         * 7 8 9
         */

         Scanner in = new Scanner(System.in);


         // declaring 

        //int[][] arr= new  int[3][3];  // no rows is monitory to declare niot columnn 
        
        // lets directly store it 

        // int[][] arr2D = {
        //     {1, 2, 3}, // oth index
        //     {4, 5, 6,}, // 1st index
        //     {7, 8, 9}   // 2nd index
        // };

        int[][] arr = new int[3][2];
        //System.out.println(arr.length);  // it will give no of rows 

        // input 

        for(int row =0; row < arr.length; row++){
            // for each col in every row 
            for(int col =0; col < arr[row].length; col++){
                    arr[row][col] = in.nextInt();
            }
        //System.out.println(arr[3][2]);
        }

        for(int row =0; row < arr.length; row++){
            // for each col in every row 
            for(int col =0; col < arr[row].length; col++){
                    System.out.println(arr[row][col] + " ");
    }
}
    }
}
