import java.util.Random;

public class Main {
    public static void main(String[] args) {
       /* BinaryTree tree = new BinaryTree();

        tree.add(5,105);
        tree.add(2,102);
        tree.add(7,107);
        tree.add(1,101);
        tree.add(8,108);
        //tree.add(4, 104);
        tree.add(6,106);
        tree.add(3,103);

        for (int i : tree) {
            System.out.println("next value " + i);
        }

*/
        //--------------------------------------------

        int[] sizes = {100,200,400,800,1000,1600,3200,6400,12800, 25600, 51200, 102400, 204800};

        for(int i : sizes){
            bench(10000, i);
        }

    }
    public static void bench(int tries, int size){

        Random rnd = new Random();

        BinaryTree myTree = generateRandom(size);

        double min = Double.POSITIVE_INFINITY;
        double max = 0;
        double sum = 0;


        for(int i = 0; i < tries; i++){
            double t0 = System.nanoTime();
            myTree.lookup(rnd.nextInt(size));
            double t1 = System.nanoTime();
            double time = t1 - t0;

            if(time < min)
                min = time;
            if(time > max)
                max = time;

            sum += time;
        }
        System.out.printf("Size: %6d\t Min: %.2fns\t Avg: %.2fns\t Max: %.2fns\n", size, min, (sum/tries), max);
    }

    public static BinaryTree generateRandom(int size){
        Random rnd = new Random();
        BinaryTree generated = new BinaryTree();

        for (int i = 0; i < size; i++) {
            generated.add(rnd.nextInt(size), rnd.nextInt(size));
        }
        return generated;
    }

}