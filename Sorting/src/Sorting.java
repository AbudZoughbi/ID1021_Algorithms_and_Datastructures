import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) throws Exception {
        int[] a = {7, 8, 10, 2, 4, 6, 3};
        selection_Sort(a);

    }

    public static void selection_Sort(int[] array){
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            // let's set the first candidate to the index itself
            int cand = i;
            for (int j = i; j < array.length ; j++) {
            // If the element at position j is smaller than the value
            // at the candidate position - then you have a new candidate
            // posistion.
            if(array[cand] > array[j])
                cand = j;
            }
        // Swap the item at position i with the item at the candidate position.
        temp = array[i];
        array[i] = array[cand];
        array[cand] = temp;
        //System.out.println(Arrays.toString(array));
        }                    
    }

    public static void insertion_sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            // for each element from i towards 1, swap the item found with the
            // item before it if it is smaller
            int temp = array[i];
            
            for (int hole = i; hole > 0 && temp < array[hole - 1] ; hole--) {
                array[hole] = array[hole - 1];
                array[hole - 1] = temp;
            }
            //System.out.println(Arrays.toString(array));
        }            
    }

    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        // copy all items from lo to hi from org to aux
        for (int i = lo; i < hi; i++){
            aux[i] = org[i];
        }
        // let's do the merging
        int i = lo; // the index in the first part
        int j = mid+1; // the index in the second part
        // for all indeces from lo to hi
        for ( int k = lo; k <= hi; k++) {
        // if i is greater than mid, move the j item to the org array, update j
            if(i > mid){
                org[k] = aux[j++];
            }
        // else if j is greate than hi, move the i item to the org array, update i
            else if(j > hi){
                org[k] = aux[i++];
            }
        // else if the i item is smaller than the j item,
        // move it to the org array, update i
            else if(aux[i] < aux[j]){
                org[k] = aux[i++];
            }

        // else you can move the j item to the org array, update j
            else{
                org[k] = aux[j++];
            }
        }
    }        
        
    public static void mergeSort(int[] org) {
        if (org.length == 0)
        return;
        int[] aux = new int[org.length];
        sort(org, aux, 0, org.length -1);
        //System.out.println(Arrays.toString(org));
    }
    
    private static void sort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
        int mid = lo + (hi-lo)/2;
        // sort the items from lo to mid
        sort(org, aux, lo, mid);
        // sort the items from mid+1 to hi
        sort(org, aux, mid + 1, hi);
        // merge the two sections using the additional array
        merge(org, aux, lo, mid, hi);
        }
    }
        
}
