public class Search {
    /*public static void main(String[] args) {
                                             search_unsorted benchmarks
        Random rnd = new Random();
        int[] array = new int[100000];

        for(int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(100000);
        }

        for(int i = 0; i < 10; i++){
        System.out.println(search_unsorted(array, rnd.nextInt(100000)));
        }
        

        Random rnd = new Random();
        for(int i = 0; i < 10; i++){
            int[] sortedArray = sorted(10000);
            System.out.println(search_unsorted(sortedArray, rnd.nextInt(10000)));
        }

    }*/

    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
            if(array[index] > key)
                break;
        }
        return false;
    }
}
