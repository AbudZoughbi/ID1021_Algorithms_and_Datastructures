import java.util.Random;

public class HeapArray {
    public Integer[] array;
    Integer Index = 0;
    Integer max;

    public HeapArray(Integer n){
        array = new Integer[n];
        max = n-1;
    }

    public HeapArray arrayGen(Integer n) {
        Random rnd = new Random();
        HeapArray array = new HeapArray(n);
        for(int i = 0; i < array.array.length; i++) {
            array.array[i] = rnd.nextInt(n);
        }
        return array;
    }

    public Integer parent(int i){
        if( (i % 2) == 0 ) {
            if((i-2)/2 >= 0)
                return (i-2)/2;
            else return 0;
        } else return (i-1)/2;
    }

    public void add(Integer input){
        if(Index == max) {
            System.out.println("heap is full");
            return;
        }
        else if(array[0] == null) {
            array[0] = input;
            return;
        } else
            array[++Index] = input;

        Integer i = Index;
        while(array[i] < array[parent(i)] && i >= 0) {
            Integer temp = array[i];
            array[i] = array[parent(i)];
            array[parent(i)] = temp;
            i = parent(i);
        }
    }

    public Integer remove(){
        if(Index == -1){
            System.out.println("Heap is empty!");
            return null;
        } else {
            int val = array[0];
            array[0] = array[Index];
            array[Index] = null;
            Index--;
            sink();
            return val;

        }
    }

    public void sink() {
        int parent = 0;
        int child1 = parent * 2 + 1;
        int child2 = parent * 2 + 2;

        while ((array[child2] != null && Index > 1) && (array[parent] > array[child1] || array[parent] > array[child2])) {
            if(array[child1] > array[child2]){
                int temp = array[child2];
                array[child2] = array[parent];
                array[parent] = temp;

                parent++;
                child1 = parent*2 + 1;
                child2 = parent*2 + 2;
            } else {
                int temp = array[child1];
                array[child1] = array[parent];
                array[parent] = temp;

                parent++;
                child1 = parent*2 + 1;
                child2 = parent*2 + 2;
            }
        }

        if ((Index == 1 && array[child2] == null) && (array[parent] > array[child1])){
            int tmp = array[child1];
            array[child1] = array[parent];
            array[parent] = tmp;
        }
    }
}
