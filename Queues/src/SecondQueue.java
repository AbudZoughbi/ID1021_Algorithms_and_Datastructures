public class SecondQueue {
    Node head;
    Node last;

    public class Node{
        public BinaryTree.Node data;
        public Node tail;

        public Node(BinaryTree.Node data, Node tail){
            this.data = data;
            this.tail = tail;
        }

        public void printout(){
            Node current = this;
            System.out.print(" "+ current.data + " ");
            if(current.tail != null) {
                current = current.tail;
                current.printout();
            }
        }
    }

    public SecondQueue(){
        head = null;
        last = null;
    }

    public void add(BinaryTree.Node data){
       Node node = new Node(data, null);
       if(last == null){
           head = last = node;
       }
       else {
           last.tail = node;
           last = last.tail;
       }
    }

    public BinaryTree.Node remove(){
        if(head == null){
            return null;
        }
        BinaryTree.Node temp = head.data;
        if(head == last){
            head = null;
            last = null;
            return temp;
        }
        head = head.tail;
        return temp;
    }

    public boolean isEmpty(){
        if(this.head == null && this.last == null){
            return true;
        }
        return false;
    }
}
