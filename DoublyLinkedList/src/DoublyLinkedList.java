import java.util.LinkedList;
import java.util.Random;

public class DoublyLinkedList {
    int value;
    DoublyLinkedList prev;
    DoublyLinkedList next;

    public DoublyLinkedList(int value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public DoublyLinkedList(int value, DoublyLinkedList prev, DoublyLinkedList next){
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public int value() {
        return this.value;
    }

    public DoublyLinkedList getNode(){
        DoublyLinkedList tbr = new DoublyLinkedList(this.value, this.prev, this.next);
        return tbr;
    }

    public void add(DoublyLinkedList nodeTobeAdded) {
        nodeTobeAdded.next = Main.list;
        nodeTobeAdded.prev = null;
        Main.list.prev = nodeTobeAdded;
        Main.list = nodeTobeAdded;
    }

    public static void remove(DoublyLinkedList nodeToRemove) {
        if(nodeToRemove.prev == null){
            Main.list = Main.list.next;
        }
        else if (nodeToRemove.next == null) {
            nodeToRemove.prev.next = null;
        }
        else {
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
        }
    }

    public void DisplayNode(){
        System.out.println(this.value);
    }
    public static void Display (DoublyLinkedList a){
        while (a.next != null) {
            System.out.print(a.value + ", ");
            a = a.next;
        }
        System.out.println(a.value);
    }

    public static int[] unsorted(int k, int n){
        Random rnd = new Random();
        int[] arr = new int[k];
        for (int i = 0; i < arr.length; i++){
            arr[i] = rnd.nextInt(n);
        }
        return arr;
    }

    public static void Dlistgenerator(int n){
        Main.list = new DoublyLinkedList(0);
        for (int i  = 1; i < n; i++) {
            Main.list.add(new DoublyLinkedList(i));
        }
    }

    public static void updateArray(int n){
        DoublyLinkedList temp = Main.list;
        Main.nodesArray = new DoublyLinkedList[n];
        for (int i = 0; i < n; i++){
            if(Main.list != null){
                Main.nodesArray[i] = Main.list;
                Main.list = Main.list.next;
            }
        }
        Main.list = temp;
    }

}
