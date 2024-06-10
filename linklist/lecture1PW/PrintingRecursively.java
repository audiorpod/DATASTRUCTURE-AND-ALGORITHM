package linklist.lecture1PW;

//import linklist.L1_SinglyLinklist.creating_singly_linklist.Node;

public class PrintingRecursively {

    public static void displayR(Node head){
        if (head == null) return ;
        System.out.println(head.data );
        displayR(head.next);

    }


    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }

    }

   
    public static void main(String args[]){

        Node a = new  Node(2);
        Node b = new Node(10);
        Node c = new Node(14);
        Node d = new Node(20);


        a.next = b;
        b.next = c;
        c.next = d;
      
        displayR(a);





    }
    
}
