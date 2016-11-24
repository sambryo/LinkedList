import sun.awt.image.ImageWatched;

/**
 * Created by samuel on 11/23/16.
 */
public class LinkedList {
    Node head ;

    public LinkedList (Node n){
        head = n;
    }
    public static void main (String[] args ){
        Node newNode = new Node (3);
        Node next1= new Node (4);
        Node next2 = new Node (6);

        newNode.next = next1;
        newNode.next.next = next2;
        newNode.next.next.next=null;

        LinkedList h = new LinkedList(newNode);

        System.out.println(display(newNode));

    }

    public static String display (Node head) {

        String result  = " ";
        while (head.next != null){
            result.concat(Integer.toString(head.data));
            result.concat(" -> ");

            head = head.next;
        }
        result += Integer.toString(head.data);

        return result;

    }
}
class Node{
    int data;
    Node next = null;


    public Node (int d){
        data = d;
    }
}
