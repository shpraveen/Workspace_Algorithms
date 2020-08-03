package CodingSites.javaRevisited.linkedList;

public class ReverseLinkedListRecusion {

    public static void main(String[] args) {
        SinglyLinkedList1.Node head = new SinglyLinkedList1.Node(1);
        SinglyLinkedList1 linkedList = new SinglyLinkedList1(head);

        linkedList.add(new SinglyLinkedList1.Node(2));
        linkedList.add(new SinglyLinkedList1.Node(3));

        linkedList.print();

        //linkedList.reverse();
        linkedList.reverseRecursively();

        linkedList.print();

    }

}


class SinglyLinkedList1{

    static class Node{

        private int data;
        private Node next;

        public Node(int data){
            this.data= data;
        }

        public int data(){
            return data;
        }

        public Node next(){
            return next;
        }
    }

    private Node head;
    public SinglyLinkedList1(Node head){
        this.head= head;
    }

    public void add(Node node){
        Node current = head;
       while(current != null){
           if(current.next == null){
               current.next = node;
               break;
           }
           current= current.next;
       }
    }

    public void print(){
        Node node = head;
        while(node !=null){
            System.out.print(node.data()+ " ");
            node = node.next();

        }
        System.out.println("");
    }

    public void reverse(){
        Node pointer = head;
        Node previous = null, current = null;

        while(pointer !=null){

            current=pointer;
            pointer=pointer.next;

            //reversing
            current.next=previous;
            previous=current;
            head=current;
        }
    }

    private Node reverseRecursively(Node node){
        Node newHead;

        if(node.next == null){
            return node;
        }

        newHead = reverseRecursively(node.next);
        node.next.next=node;
        node.next=null;
        return newHead;
    }

    public void reverseRecursively(){
        head= reverseRecursively(head);
    }

}