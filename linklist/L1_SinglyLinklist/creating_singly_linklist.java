package linklist.L1_SinglyLinklist;

public class creating_singly_linklist {

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
     
      
      // lets link the nodes  5 -> 3 -> 9 -> 8 -> 16

      a.next = b;   //5 -> 3  9  8 16
      b.next = c;  //5 -> 3 -> 9  8  16
      c.next = d;  //5 -> 3 -> 9 -> 8 16
      d.next = e;  //5 -> 3 -> 9 -> 8 -> 16

      //System.out.println(a.data);  // or   System.out.println(a.data);
      //System.out.println(b.data);  // or   System.out.println(a.next.data);
     // System.out.println(c.data);  // or   System.out.println(a.next.next.data
     // System.out.println(d.data);  // or   System.out.println(a.next.next.next.data);
     // System.out.println(e.data);  // or    System.out.println(a.next.next.next.next.data);

        //or USING LOOP 

        // Node temp  = a;
        // for( int i=1; i<=5; i++){
        //     System.out.print(temp.data + " ");
        //     temp = temp.next;    // VERY VERY IMPORTANT 


            // if we are not given the size of   number of nodes in linklist 
            // as  we know that  last node tends to null 

            Node temp = a;
            while (temp!=null){
                System.out.print(temp.data + " ");
                temp = temp.next;    // VERY VERY IMPORTANT
            }


        }
    }    



