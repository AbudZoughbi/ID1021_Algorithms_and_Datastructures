
public class Main {
    public static LinkedList a = LinkedList.listGenerator(10);

    public static void main(String[] args){
       /*int[] sizes = {100, 400, 800, 1000, 1200, 1400, 2600, 5000, 8000, 14000};
        double min;
        System.out.printf("#%7s%8s%8s%8s%8s\n", "n", "ListF", "ArrayF", "ListUN" , "ArrayUN");

        for(int n : sizes){
            min = Double.POSITIVE_INFINITY;
            System.out.printf("%8d", n);

            for(int i = 0; i < 1000; i++){
                LinkedList fixed = LinkedList.listGenerator(1000);
                LinkedList newList = LinkedList.listGenerator(n);
                long t0 = System.nanoTime();
                fixed.append(newList);
                long t1 = System.nanoTime();
                double time = t1 - t0;
                if(time < min){
                    min = time;
                }
            }
            System.out.printf("%8.0f", min);

            min = Double.POSITIVE_INFINITY;

            for(int i = 0; i < 1000; i++){
                int[] a = new int[1000];
                int[] b = new int[n];

                long t0 = System.nanoTime();
                Array.arrayAppend(a, b);
                long t1 = System.nanoTime();
                double time = t1 - t0;
                if(time < min){
                    min = time;
                }
            }
            System.out.printf("%8.0f", min);

            for(int i = 0; i < 1000; i++){
                LinkedList fixed = LinkedList.listGenerator(1000);
                LinkedList newList = LinkedList.listGenerator(n);
                long t0 = System.nanoTime();
                newList.append(fixed);
                long t1 = System.nanoTime();
                double time = t1 - t0;
                if(time < min){
                    min = time;
                }
            }
            System.out.printf("%8.0f", min);

            min = Double.POSITIVE_INFINITY;

            for(int i = 0; i < 1000; i++){
                int[] a = new int[1000];
                int[] b = new int[n];

                long t0 = System.nanoTime();
                Array.arrayAppend(b, a);
                long t1 = System.nanoTime();
                double time = t1 - t0;
                if(time < min){
                    min = time;
                }
            }
            System.out.printf("%8.0f\n", min);
        }*/

        LinkedList.printout(a);
        System.out.println();
        a.push(200);
        LinkedList.printout(a);
        System.out.println();
        a.push(200);
        LinkedList.printout(a);

        System.out.println();
        a.pop();
        LinkedList.printout(a);

    }
}
