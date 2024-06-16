package Array.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class basic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        // syntax
        ArrayList<Integer> list = new ArrayList<Integer>(10);
         
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // list.add(6);
        // list.add(7);
        // list.add(8);
        // list.add(9);
        // list.add(10);
        // list.add(11);

       
        // System.out.println(list.contains((10))); // it exist it will give true  or if not it will give false 

        // list.set(1, 200);  // set a new value at any index  with help of list.set(index, value you want to add)
        // System.out.println(list);

        // list.remove(2);

        // for (int i = 0 ; i< 2; i++){
        //     System.out.println(list);
        // }


        // taking input 

        for(int i =0; i<5; i++){

           list.add(in.nextInt());
        }

        // get item at any index 

        for( int i = 0; i<5; i++){
            System.out.println(list.get(i));

        }

        //System.out.println(list);



    }

    
}
