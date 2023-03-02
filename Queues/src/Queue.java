public class Queue {

    Node head;
    public class Node{
        public Integer data;
        public Node tail;

        public Node(Integer data, Node tail){
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

    public Queue(Integer data){
        head = new Node(data, null);
    }

    public void add(Integer data){
        Node nxt = this.head;
        while (nxt.tail != null){
            nxt = nxt.tail;
        }
        nxt.tail = new Node(data, null);
    }

    public Integer remove(){
       Queue curr = this;
       Integer tbr = curr.head.data;
       curr.head = curr.head.tail;
       return tbr;
    }
}
