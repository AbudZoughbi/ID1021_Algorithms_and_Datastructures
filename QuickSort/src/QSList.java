public class QSList {

    Node head, last;

    public QSList(int value) {
        head = new Node(value);
    }

    public class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public void printout() {
            Node curr = this;
            System.out.print(curr.value + ", ");
            if (curr.next != null) {
                curr = curr.next;
                curr.printout();
            }
        }
    }

    public void add(int val) {
        if (head.next == null) {
            last = new Node(val);
            head.next = last;
        } else {
            Node t = last;
            t.next = new Node(val);
            last = t.next;

            //last = new Node(val);
            //t.next = last;
        }
    }

    public static void sort(Node first, Node last) {
        if (first == last || first == null) {
            return;
        }
        Node divider = partition(first, last);
        sort(first, divider);
        sort(divider.next, last);
    }

    public static Node partition(Node first, Node last) {
        if (first == last || first == null) {
            return first;
        }
        //initiering
        int pivot = first.value;
        Node prev = first;
        Node curr = first.next;

        // metoden
        while (curr != last.next) {
            if (curr.value < pivot) {
                swap(prev.next, curr);
                prev = prev.next;
            }
            curr = curr.next;
        }

        //avslut
        swap(first, prev);
        return prev;
    }

    public static void swap(Node prevNxt, Node curr){
        int temp = prevNxt.value;
        prevNxt.value = curr.value;
        curr.value = temp;
    }
}
