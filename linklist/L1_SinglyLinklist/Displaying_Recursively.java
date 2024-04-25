package linklist.L1_SinglyLinklist;

public class Displaying_Recursively {

    // creating function 
    public static void  display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data+" ");
            temp = temp.next;    // VERY VERY IMPORTANT

    }
    class Node{
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
     
      
      // lets link the nodes  5 -> 3 -> 9 -> 8 -> 16

      a.next = b;   //5 -> 3  9  8 16
      b.next = c;  //5 -> 3 -> 9  8  16
      c.next = d;  //5 -> 3 -> 9 -> 8 16
      d.next = e;  //5 -> 3 -> 9 -> 8 -> 16

      display(a); // calling the function which contain head 
    
}
}
