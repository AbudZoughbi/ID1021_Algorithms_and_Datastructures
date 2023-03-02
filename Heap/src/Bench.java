import java.util.Random;

public class Bench {
    public static void main(String[] args){
        List list = new List();
        List list2 = new List();

        Random rnd = new Random();

        int[] sizes = {100,200,300,400,500,600,700,800,900,
                1000,1100,1200,1300,1400,1500,1600,2500,3000,5000,12800, 25600};
        System.out.printf("#%7s%9s%9s\n", "n   ", "List1", "List2");

        for(int n : sizes) {
            System.out.printf("%8d", n);
            HeapArray array = new HeapArray(n);

            array  = array.arrayGen(n);
            list = list.gen(n);
            list2 = list2.gen2(n);

            int k = 10000000;

            double t = 0;
            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                array.add(rnd.nextInt(n));
                long t1 = System.nanoTime();
                array.remove();
                t += (t1 - t0);
            }
            System.out.printf("%9.0f", (t/k));

            double t2 = 0;
            for (int i = 0; i < k; i++) {
                array.add(rnd.nextInt(n));
                long t0 = System.nanoTime();
                array.remove();
                long t1 = System.nanoTime();
                t2 += (t1 - t0);

            }

            System.out.printf("%9.0f\n", (t2/k));

        }
    }
}
