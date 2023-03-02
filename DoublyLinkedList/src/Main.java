
public class Main {
    public static DoublyLinkedList list;
    public static DoublyLinkedList[] nodesArray;

    public static void main(String[] args) {

        DoublyLinkedList.Dlistgenerator(6);
        DoublyLinkedList.Display(list);
        System.out.println("-------------");

        DoublyLinkedList.updateArray(6);

        DoublyLinkedList.remove(nodesArray[3]);
        DoublyLinkedList.updateArray(6);
        DoublyLinkedList.remove(nodesArray[1]);
        DoublyLinkedList.updateArray(6);
        DoublyLinkedList.remove(nodesArray[3]);
        DoublyLinkedList.Display(list);

/*
        LinkedList list  = LinkedList.listGenerator(10);
        LinkedList.printout(list);
        list.append(new LinkedList(21, null));
        LinkedList.printout(list);
*/
    }

}