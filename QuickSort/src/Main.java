import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*QSList list = generate(10);
        list.head.printout();
        System.out.println();
        System.out.println("--------------");
        QSList.sort(list.head, list.last);
        list.head.printout();
        */





        //-------------------------------------
        QSList list = new QSList(1);
        Random rnd = new Random();
        int[] sizes = {100,200,300,400,500,600,700,800,900,
                1000,1100,1200,1300,1400,1500,1600,2000,3000,4000,5000,6000,7000,8000,9000,10000,12800};
        System.out.printf("#%7s%9s%10s\n", "n   ", "AddList", "Array");

        for(int n : sizes) {
            System.out.printf("%8d", n);

            int k = 10000;

            double min = Double.POSITIVE_INFINITY;
            double min2 = Double.POSITIVE_INFINITY;
            double t = 0;
            double tT = 0;
            for (int i = 0; i < k; i++) {

                QSList l = new QSList(1);
                int[] array = new int[n];

                for(int j = 0; j < n; j++) {
                    array[j] = rnd.nextInt(5*n);
                }

                for(int f = n-1; f > -1; f--) {
                    l.add(array[f]);
                }
                list = l;

                long t0 = System.nanoTime();
                list.sort(list.head, list.last);
                long t1 = System.nanoTime();
                t += (t1 - t0);

                long ta = System.nanoTime();
                QuickSort.sort(array, 0, array.length-1);
                long tb = System.nanoTime();
                tT += (tb - ta);
            }

            System.out.printf("%9.0f%9.0f\n", t/k, tT/k);

        }
    }

    public static QSList generate(int n) {
        QSList list = new QSList(10);
        Random rnd = new Random();

        for(int i = 0; i < n; i++) {
            list.add(rnd.nextInt(n*5));
        }
        return list;
    }

    public static void print(QSList list1){
        QSList list = list1;
        while (list.head != null){
            System.out.print(list.head.value + ", ");
            list.head = list.head.next;
        }
    }
}