import java.lang.reflect.Array;
import java.util.Random;

class Bench {

   /*private static void linear(int[] array, int[] indx) {
	for (int i = 0; i < indx.length ; i++) {
	    Linear.search(array, indx[i]);
	}
    }
    */

    /*private static void binary(int[] array, int[] indx) {
	for (int i = 0; i < indx.length ; i++) {
	    Binary.search(array, indx[i]);
	}
    }
*/
    
    public static int[] unsorted(int n){
        Random rnd = new Random();
        int[] array = new int[n];
        for(int i = 0; i < array.length; i++){
            array[i] = rnd.nextInt(n*5);
        }
        return array;
    }

    private static int[] sorted(int n) {
	Random rnd = new Random();	
	int[] array = new int[n];
	int nxt = rnd.nextInt(10);

	for (int i = 0; i < n ; i++) {
	    array[i] = nxt;
	    nxt += rnd.nextInt(10) + 1 ;
	}	
	return array;
    }


    private static int[] keys(int loop, int n) {
	Random rnd = new Random();	
	int[] indx = new int[loop];
	for (int i = 0; i < loop ; i++) {
	    indx[i] = rnd.nextInt(n*5);
	}	
	return indx;
    }

    
    public static void main(String[] arg) {

	int[] sizes = {100,200,300,400,500,600,700,800,900,1000,1100,1200,1300,1400,1500,1600};

	System.out.printf("# searching through an array of length n, time in ns\n");
	System.out.printf("#%7s%10s%10s\n", "n", "selection", "insertion");
	for ( int n : sizes) {

	    int loop = 10000;
	    
	    //int[] array = unsorted(n);
	    int[] indx = keys(loop, n);

	    System.out.printf("%8d", n);

	    int k = 1000;
	    
	    double min1 = Double.POSITIVE_INFINITY;

	    for (int i = 0; i < k; i++) {
            int[] array = unsorted(n);
		long t0 = System.nanoTime();
		Sorting.selection_Sort(array);
		long t1 = System.nanoTime();
		double t = (t1 - t0);
		if (t < min1)
		    min1 = t;
	    }

	    System.out.printf("%10.0f", (min1));	    

	    double min2 = Double.POSITIVE_INFINITY;
	    
	    for (int i = 0; i < k; i++) {
            int[] array = unsorted(n);
		long t0 = System.nanoTime();
		Sorting.mergeSort(array);
		long t1 = System.nanoTime();
		double t = (t1 - t0);
		if (t < min2)
		    min2 = t;
	    }

	    System.out.printf("%10.0f%10.2f\n" , (min2), (min2/min1));
	}
    }
}
