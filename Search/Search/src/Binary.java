import java.util.Random;

public class Binary {

    // Testing binary
    /*public static void main(String[] args){
        int n = 100000;
        int[] array = new int[n];
        Random rnd = new Random();

        array = sorted(n);

        for(int i = 0; i < 10; i++){
        System.out.println(binary_search(array, rnd.nextInt(100000)));
        }

    }*/


    public static boolean binary_search(int[] array, int key) {
        //long time0 = System.nanoTime();
        
        int first = 0;
        int last = array.length-1;

        while (true) {

            int index = first + (last - first) / 2;
            if (array[index] == key) {
            return true;
            }
            if (array[index] < key && index < last) {
            first = index + 1;
            continue;
            }
            if (array[index] > key && index > first) {
            last = index - 1;
            continue;
            }
            break;
        }
        return false;
    }

    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
        }

}
