public class Main {
    public static void main(String[] args) {
       //Zip zip = new Zip("G:\\Min enhet\\Skola\\AlgoData\\postnummer.csv");
       //Zip2 zip = new Zip2("G:\\Min enhet\\Skola\\AlgoData\\postnummer.csv");
/*
        int k = 100000;
        int t = 0;

        for(int i = 0; i < k; i++) {
            double t0 = System.nanoTime();
            boolean lookup = zip.lookup(94499);
            double t1 = System.nanoTime();
            t += (t1-t0);
        }
        System.out.println("time for lookup (111 15): " + (t/k));

 */



        ZipHash hash = new ZipHash("G:\\Min enhet\\Skola\\AlgoData\\postnummer.csv");
        hash.fillBucket();
        System.out.println(hash.lookupLast(80320));


        /*
        t = 0;
        for(int i = 0; i < k; i++) {
            double t0 = System.nanoTime();
            boolean binary = zip.binary_search(11115);
            double t1 = System.nanoTime();
            t += (t1-t0);
        }
        System.out.println("time for binary (111 15): " + (t/k));


        for(int i = 0; i < k; i++) {
            double t0 = System.nanoTime();
            boolean lookup = zip.lookup(99499);
            double t1 = System.nanoTime();
            t += (t1-t0);
        }
        System.out.println("time for lookup (994 99): " + (t/k));

        t = 0;
        for(int i = 0; i < k; i++) {
            double t0 = System.nanoTime();
            boolean binary = zip.binary_search(99499);
            double t1 = System.nanoTime();
            t += (t1-t0);
        }
        System.out.println("time for binary (994 99): " + (t/k));
         */

    }
}