package CodingSites.javaRevisited.linkedList;

public class IsLinkedListCircular {

    public static void main(String[] args) {

        //creating LinkedList with 5 elements including head
        LinkedList1 linkedList = new LinkedList1();
        linkedList.appendIntoTail(new LinkedList1.Node("101"));
        linkedList.appendIntoTail(new LinkedList1.Node("201"));
        linkedList.appendIntoTail(new LinkedList1.Node("301"));
        linkedList.appendIntoTail(new LinkedList1.Node("401"));
        linkedList.appendIntoTail(new LinkedList1.Node("101"));

        System.out.println("Linked List : " + linkedList);

        if(linkedList.isCyclic()){
            System.out.println("Linked List is cyclic as it contains cycles or loop");
        }else{
            System.out.println("LinkedList is not cyclic, no loop or cycle found");
        }

    }

}

class LinkedList1{

    private Node head;
    public LinkedList1(){
        this.head= new Node("head");
    }

    public Node head(){
        return head;
    }

    public void appendIntoTail(Node node){
        Node current = head;

        //finding the last element
        while(current.next()!=null){

            current = current.next();
        }

        //appending new Node to tail
        current.setNode(node);
    }

    public boolean isCyclic(){
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next !=null) {

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }

        }
        return false;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        Node current = head.next();
        while(current != null){
            sb.append(current).append("-->");
            current = current.next();

        }
        sb.delete(sb.length() - 3, sb.length());
        return sb.toString();
    }

    public static class Node{
        private Node next;
        private String data;

        public Node(String data) {
            this.data = data;
        }

        public String data() { return data; }
        public void setData(String data) { this.data = data;}

        public Node next() { return next; }
        public void setNode(Node next) { this.next = next; }

        @Override
        public String toString() {
            return this.data;
        }
    }
}