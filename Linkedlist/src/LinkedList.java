import java.util.Random;

public class LinkedList {
    int head;
    LinkedList tail;

    public LinkedList(int item, LinkedList list){
        head = item;
        tail = list;
    }

    public int head(){
        return this.head;
    }

    public LinkedList tail(){
        return this.tail;
    }

    public void append(LinkedList b){
        LinkedList nxt = this;
        while(nxt.tail != null){
            nxt = nxt.tail;
        }
        nxt.tail = b;
    }

    public static LinkedList listGenerator(int size){
        Random rnd = new Random();
        LinkedList list = new LinkedList(rnd.nextInt(size*5), null);
        for(int i = 0; i < size; i++){
            list.append(new LinkedList(rnd.nextInt(size*5), null));
        }
        return list;
    }

    /*public int pop(){
        LinkedList list = this;
        while (list.tail.tail != null){
            list = list.tail;
        }
        list.tail = null;
        return list.head;
    }

    public void push(int n){
        LinkedList thisL = this;
        while (thisL.tail != null){
            thisL = thisL.tail;
        }
        thisL.tail = new LinkedList(n, null);
    }
*/
    public void push(int val){
        LinkedList temp = new LinkedList(val, LinkedList.this);
        Main.a = temp;
    }
    public int pop(){
        int val = Main.a.head;
        Main.a = Main.a.tail;
        return val;
    }
    public static void printout(LinkedList a){
        while (a.tail != null) {
            System.out.print("[" + a.head + "], ") ;
            a = a.tail;
        }
        System.out.println(a.head);
    }
}
