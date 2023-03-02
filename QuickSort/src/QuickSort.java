public class QuickSort {

    public static void sort(int[] array, int low, int high) {
        if(low < high) {
            int j = partition(array, low, high);
            sort(array, low, j - 1);
            sort(array, j + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low;
        int j = high;

        while (i < j) {
            //stanna tills större än pivot
            while (array[i] <= pivot && i < high) {
                i++;
            }
            //stanna tills mindre än pivot
            while (array[j] > pivot && j > low) {
                j--;
            }
            //swappa dessa värden
            if (i < j) {
                swap(array, i, j);
            }
        }
        //swappa pivot med
        swap(array, low, j);
        return j;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}