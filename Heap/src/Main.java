import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*List list = new List();
        list.add2(10);
        list.add2(20);
        list.add2(4);
        list.add2(5);
        list.add2(13);
        list.add2(35);
        list.add2(17);
        list.add2(1);

        list.print();

        list.remove2();
        list.print();

        list.remove2();
        list.print();

        list.remove2();
        list.print();

        list.remove2();
        list.print();*/
/*
        HeapTree heap = new HeapTree();

        HeapTree.Node b = heap.new Node(7);
        HeapTree.Node c = heap.new Node(8);


        System.out.println("addDepth: " + heap.add(3));
        System.out.println("addDepth: " + heap.add(5));
        System.out.println("addDepth: " + heap.add(7));
        System.out.println("addDepth: " + heap.add(8));
        System.out.println("addDepth: " + heap.add(2));
        System.out.println("addDepth: " + heap.add(10));
        System.out.println("addDepth: " + heap.add(1));
        System.out.println("addDepth: " + heap.add(4));
        System.out.println("addDepth: " + heap.add(100));
        System.out.println("addDepth: " + heap.add(100));

*/

/*
        System.out.println(heap.root.value);
        System.out.println(heap.root.right.value);
        System.out.println(heap.root.right.left.value);
        System.out.println(heap.root.left.value);
        System.out.println(heap.root.left.left.value);
        System.out.println(heap.root.left.right.value);

        System.out.println("-----------------");

        System.out.println("depth: " + heap.push(100));

        System.out.println(heap.root.value);
        System.out.println(heap.root.right.value);
        System.out.println(heap.root.right.left.value);
        System.out.println(heap.root.left.value);
        System.out.println(heap.root.left.left.value);
        System.out.println(heap.root.left.right.value);

        System.out.println("-----------------");


*/
  /*      HeapArray heapA = new HeapArray(7);
        heapA.add(12);
        heapA.add(7);
        heapA.add(6);
        heapA.add(10);
        heapA.add(8);
        heapA.add(20);
        for (int i = 0; i < heapA.array.length; i++){
            System.out.print("[" + heapA.array[i] + "], ");
        }
        heapA.add(5);
        //heapA.add(0);
        System.out.println("----------------");

        for (int i = 0; i < heapA.array.length; i++){
            System.out.print("[" + heapA.array[i] + "], ");
        }
        //heapA.add(0);
        System.out.println("----------------");

        for (int i = 0; i < heapA.array.length; i++){
            System.out.print("[" + heapA.array[i] + "], ");
        }

   */
        HeapTree tree = new HeapTree();
        HeapTree tree2 = new HeapTree();
        Random rnd = new Random();

        int g = 1000;

        /*Integer pushAvg = 0;
        for(int i = 0; i < g; i++) {
            tree = tree.generate(64);
            Integer temp = tree.push(rnd.nextInt(10, 31));
            pushAvg += temp;
            System.out.println(temp);
        }
        System.out.println("push average: " + (pushAvg/g));

         */

        Integer addAvg = 0;
        for(int i = 0; i < 1000; i++) {
            Integer temp = tree2.add(rnd.nextInt(101));
            addAvg += temp;
            System.out.println("temp: " + temp);
        }
        System.out.println("add average: " + (addAvg/(1000)));

    }
}