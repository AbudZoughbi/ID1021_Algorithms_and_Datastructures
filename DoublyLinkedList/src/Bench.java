import java.util.Random;

public class Bench {
    public static LinkedList singeList;
    public static void main(String[] args){
        int[] sizes = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 6400, 12800, 32000};
        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s%8s\n", "n", "S","D","3rd");

        for (int n : sizes) {
            System.out.printf("%8d", n);

            // Lists being made
            singeList = LinkedList.listGenerator(n);
            DoublyLinkedList.Dlistgenerator(n);
            //Nodes to be added
            LinkedList tempL = new LinkedList(10, null);
            DoublyLinkedList tempDL = new DoublyLinkedList(21);
            DoublyLinkedList.updateArray(n);

            int k = 100000;

            int[] sequence = new int[k];
            Random rnd = new Random();
            for (int i = 0; i < k; i++) {
                sequence[i] = rnd.nextInt(n);
            }

            double t = 0;
            double min = Double.POSITIVE_INFINITY;
            for (int i = 0; i < k; i++) {
                LinkedList l = new LinkedList(sequence[i], null);
                long t0 = System.nanoTime();
                singeList.remove(sequence[i]);
                singeList.append(l);
                long t1 = System.nanoTime();
                t = (t1 - t0);
                if (t < min) {
                    min = t;
                }
            }

            System.out.printf("%8.0f", (min));

            double t2 = 0;
            min = Double.POSITIVE_INFINITY;
            for (int i = 0; i < k; i++) {
                DoublyLinkedList d = new DoublyLinkedList(Main.nodesArray[sequence[i]].value);
                long t0 = System.nanoTime();
                DoublyLinkedList.remove(Main.nodesArray[sequence[i]]);
                Main.list.add(d);
                long t1 = System.nanoTime();
                DoublyLinkedList.updateArray(n);
                t2 += (t1 - t0);
                if (t2 < min){
                    min = t2;
                }
            }
            System.out.printf("%8.0f\n", (t2/k));
        }
    }
}
