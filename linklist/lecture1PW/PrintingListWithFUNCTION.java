package linklist.lecture1PW;

public class PrintingListWithFUNCTION {

    // CREATING A FUNCTION TO DISPLAY 

    public static void  display (Node head ){

        Node temp = head;
        while(temp!= null){
            System.out.println(temp.data+"");
            temp = temp.next ;
        }

    }


    
 
    public static class Node{

        int data;  // value 
        Node next;  // next denotes =  data + next node ka address

        
        // creating a constructor 

        Node(int data){
            this.data = data;
            this.next = null;
        }

    }
    public static void main(String[] args) {
      Node a = new Node(5);
      Node b = new Node(3);
      Node c = new Node(9);
      Node d = new Node(8);
      Node e = new Node(16);
      Node f = new Node(100);
     
      
      // lets link the nodes  5 -> 3 -> 9 -> 8 -> 16

      a.next = b;   //5 -> 3  9  8 16
      b.next = c;  //5 -> 3 -> 9  8  16
      c.next = d;  //5 -> 3 -> 9 -> 8 16
      d.next = e;  //5 -> 3 -> 9 -> 8 -> 16
      e.next = f;



// PRINTING THE LIST WITH HELP OF FUNCTION 
                display(a);
              
    
    }    
}


