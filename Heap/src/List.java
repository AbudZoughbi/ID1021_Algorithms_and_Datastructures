import java.util.Random;

public class List {
    Node head;
    Node end;
    public class Node{
        int value;
        Node next;

        public Node (int v){
            this.value = v;
            this.next = null;
        }
    }

    public void add(int v){
        if (head == null) {
            end = new Node(v);
            head = end;
        } else {
            Node t = new Node(v);
            t.next = head;
            head = t;
        }
    }

    public Node remove(){
     /*   Node smallest = head;
        Node current = head;
        Node prev = null;

        while (current.next != null){
            if(current.next.value < smallest.value){
                smallest = current.next;
                prev = current;
            }
            current = current.next;
        }
        if(smallest == head){
            head = head.next;
        } else {
            prev.next = smallest.next;
        }

        return smallest;
      */
        Node current = head;
        Node smallest = head;
        Node previous = null;

        while(current.next != null) {
            if(current.next.value < smallest.value) {
                smallest = current.next;
                previous = current;
            }
            current = current.next;
        }
        if(smallest == head) {
            Node temp = smallest;
            head = head.next;
            return temp;
        }
        else {
            previous.next = previous.next.next;
            return smallest;
        }
    }

    public void add2(int v){
        Node newNode = new Node(v);
        if(head == null){
            head = newNode;
        } else {
            if(newNode.value < head.value){
                newNode.next = head;
                head = newNode;
            } else {
                Node curr = head;
                while (curr.next != null){
                    if(newNode.value < curr.next.value){
                        newNode.next = curr.next;
                        curr.next = newNode;
                        return;
                    }
                    curr = curr.next;
                }
                curr.next = newNode;
            }
        }
    }

    public Node remove2(){
        Node tbr = head;
        head = head.next;
        return tbr;
    }

    public void print() {
        Node node = head;
        System.out.print("[");
        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println("]");
    }

    public List gen(int n) {
        Random rnd = new Random();
        List list = new List();
        for(int i = 0; i < n; i++) {
            list.add(rnd.nextInt(n*5));
        }
        return list;
    }

    public List gen2(int n) {
        Random rnd = new Random();
        List list = new List();
        for(int i = 0; i < n; i++) {
            list.add2(rnd.nextInt(n*5));
        }
        return list;
    }
}
