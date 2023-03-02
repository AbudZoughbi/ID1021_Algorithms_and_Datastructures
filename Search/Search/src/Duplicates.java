import java.util.Random;

public class Duplicates {

    public static void main(String[] args){
        int[] keys = sorted(1000);
        int[] items = sorted(1000);
        System.out.println(duplicateSearch(keys, items));
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

    public static int duplicateSearch(int[] keysArray, int[] itemArray){
        int counter = 0;

        for(int i = 0; i < keysArray.length; i++){
            if(binary_search(itemArray, keysArray[i])){
                counter++;
            }
            //System.out.println(counter);
        }
        return counter;
    }

    public static void duplicateSearch2(int[] keysArray, int[] itemArray){
        int keyspointer = 0;
        int itemspointer = 0;

        for(int i = 0; i < keysArray.length; i++){
            if(keysArray[keyspointer] > itemArray[itemspointer])
                itemspointer++;
            if(keysArray[keyspointer] < itemArray[itemspointer])
                keyspointer++;
            if(keysArray[keyspointer] == itemArray[itemspointer])
                itemspointer++;
                keyspointer++;
            if(keyspointer == keysArray.length - 1 || itemspointer == itemArray.length - 1)
                break;
        }
    }

    public static boolean binary_search(int[] array, int key) {        
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
    
}
