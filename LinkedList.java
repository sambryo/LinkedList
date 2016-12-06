import sun.awt.image.ImageWatched;

/**
 * Created by samuel on 11/23/16.
 */
public class LinkedList {
    Node head ;

    public LinkedList (Node n){
        head = n;
        //head.next = null;
    }
    public static void main (String[] args ){
	// Example :- creating a node with a randome number [3,4,6] 


	System.out.println("This code might have multiple methods to play with linked list practice problem");
        Node newNode = new Node (3);
        Node next1= new Node (4);
        Node next2 = new Node (6);

        newNode.next = next1;
        newNode.next.next = next2;
        newNode.next.next.next=null;

        LinkedList h = new LinkedList(newNode);

        System.out.println(display(newNode));
        System.out.println(display2(newNode));

        int[] newArray = {6,5,2,1,8,9,2,7};
        LinkedList ll2 = makeLinkedListFromArray(newArray);
        System.out.println(displayLinkedList(ll2));



    }
    public static String displayLinkedList(LinkedList l){
        StringBuffer str = new StringBuffer();
        while (l.head.next != null){
            str.append(l.head.data);
            str.append("--->");
            l.head = l.head.next;

        }
        str.append(l.head.data);
        return str.toString();
    }

     public static String display (Node head) {

        String result = "";
        while (head.next != null){
           result = result.concat(Integer.toString(head.data));
           result = result.concat(" -> ");

            head = head.next;
        }
        result = result.concat(Integer.toString(head.data));

        return result;

    }
    public static int addNodeData (Node head){
        int sum = 0;
        while (head != null){
            sum += head.data;
            head = head.next;
        }

        return sum;
    }


    public static String display2 (Node head) {

        StringBuffer result  = new StringBuffer();
        while (head.next != null){
            result.append(head.data);
            result.append(" -> ");

            head = head.next;
        }
        result.append(head.data);

        return result.toString();

    }

    public static LinkedList makeLinkedListFromArray (int[] array){
        if (array.length == 0)
            return null;
        Node head = new Node (array[0]);
        Node headCopy = head;
        for (int i=1; i<array.length; i++){
            head.next = new Node(array[i]);
            head = head.next;
        }
        head.next = null;
        return new LinkedList(headCopy);


    }

    public static Node reverseAndCopy(Node head){
        Node n = null;
        while (head != null){
            Node r = new Node (head.data); // clone
            r.next = n;
            n = head;
            head = head.next;
        }
        return n;
    }

// Finding the node which starts the loop
    public static Node LoopStarterNode(LinkedList head){
        LinkedList slow = head;
        LinkedList fast = head;

        while (fast ! = null || fast.next != null){
            slow = slow.next;
            fast = fast.next;

            if (slow == fast){
                break;
            }
        }

        //checking Error

        if (fast == null || fast.next == null){
            return null;
        }


        // here is the magic.
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        // return either the fast or slow. both pointing same node

        return fast;


    }
}
class Node {
    int data;
    Node next = null;


    public Node(int d) {
        data = d;
    }

}
