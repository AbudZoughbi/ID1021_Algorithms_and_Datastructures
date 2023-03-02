import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(searchDup(1000));
    }

   public static double access(int n){
        int k = 1_000_000;
int l = n;
Random rnd = new Random();
int[] indx = new int[l];
// fill the indx array with random number from 0 to n (not including n)
    for (int i = 0; i < l ; i++) {
      indx[i] = rnd.nextInt(n);
       }
    
int[] array = new int[n];
// fill the array with dummy values (why not 1)
       for(int i = 0; i < n; i++){
        array[i] = 1;
       }
int sum = 0;
long t0 = System.nanoTime();
for (int j = 0; j < k; j++) {
for (int i = 0; i < l; i++) {
// access the array with the index given by indx[i]
// sum up the result
sum += array[indx[i]];
}
}
long t_access = (System.nanoTime() - t0);
t0 = System.nanoTime();
// do the same loop iteration but only do a dummy add operation
int val = 0;
for (int j = 0; j < k; j++) {
    for (int i = 0; i < l; i++) {
    }
    val += 1;
    }

long t_dummy = (System.nanoTime() - t0);
return ((double)(t_access - t_dummy))/((double)k*(double)l);

    }

public static double search(int n){
    int m = 1000;
    int k = 1000;
    long t_total = 0;

    int[] keys = new int[m];
    int[] array = new int[n];

    Random rnd = new Random();

    int sum = 0;
    for (int j = 0; j < k; j++){
        for(int b = 0; b < m; b++){
            keys[b] = rnd.nextInt(10 * n);
        }
        for(int a = 0; a < m; a++){
            array[a] = rnd.nextInt(10 * n);
        }

        long t0 = System.nanoTime();
        for (int ki = 0; ki < m; ki++) {
        int key = keys[ki];
        for (int i = 0; i < n ; i++) {
            if (array[i] == key) {
                sum++;
                break;
            }
        }
        }
        
        t_total += (System.nanoTime() - t0);
    }
    return t_total;
}

public static double searchDup(int n){

    double t_totald = 0;

    Random rnd = new Random();

    int[] keys = new int[n];
    int[] array = new int[n];

    for(int i = 0; i < n; i++){
        keys[i] = rnd.nextInt(10*n);
    }

    int sum = 0;

        for(int i = 0; i < n; i++){
            array[i] = rnd.nextInt(10*n);
        }

        long t0 = System.nanoTime();
        for(int ki = 0; ki < n; ki++){
         int key = keys[ki];
            for(int i = 0; i < n; i++){
             if(array[i] == key){
                   sum++;
                }
            }
        }

        double t1 = System.nanoTime();
        return (t1 - t0);
}

}
