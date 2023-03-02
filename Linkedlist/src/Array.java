import java.util.Random;
public class Array {
    public static void arrayAppend(int[] a1, int[] a2){
        int[] newA = new int[a1.length + a2.length];
        int i = 0;
        for(i = 0; i < a1.length; i++){
            newA[i] = a1[i];
        }
        int index = 0;
        for(int j = a1.length; j < newA.length; j++){
            newA[j] = a2[index++];
        }
    }

    public static int[] array_append(int[] org, int[] tba){
        int tlen = org.length + tba.length;
        int[] tbr = new int[tlen];
        for(int i = 0; i <tlen; i++){
            if (i >= org.length) tbr[i] = tba[i-org.length];
            else tbr[i] = org[i];
        }
        return tbr;
    }

    public static int[] unsorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        for(int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(100);
        }
        return array;
    }
}
