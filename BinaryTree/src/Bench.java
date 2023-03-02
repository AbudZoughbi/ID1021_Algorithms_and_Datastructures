import java.util.Random;

public class Bench {
    public static void main(String[] args) {

        int[] sizes = {100,200,400,800,1000,1600,3200,6400,12800, 25600, 51200, 102400, 204800};
        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s\n", "n", "1st");
        Random rnd = new Random();


        for (int n : sizes) {
            System.out.printf("%8d", n);
            int k = 100000;
            double min = Double.POSITIVE_INFINITY;


            double t = 0;
            for (int i = 0; i < k; i++) {
                BinaryTree tree = new BinaryTree();
                for(int j = 0; j < n; j++) {
                    tree.add(rnd.nextInt(n), rnd.nextInt(n));
                }

                long t0 = System.nanoTime();
                tree.lookup( (n/5)+ rnd.nextInt(n));
                long t1 = System.nanoTime();
                t += (t1 - t0);
            }

            System.out.printf("%8.0f\n", (t/k));
        }
    }
}