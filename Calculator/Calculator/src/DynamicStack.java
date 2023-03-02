import java.util.Arrays;

public class DynamicStack {
    int size = 4;                       // smallest size of the stack
    int[] stackArray = new int[size];
    private int sp = 0;

    public void push(int in) {
        if(sp <= size - 1){
            stackArray[sp] = in;
            sp++;
        }
        else{
            expand();       // expand the current array, instead of overflowing
            push(in);
        }
    }

    public int pop() {
        if(sp < size/2 && sp > 4){
            sp--;
            shrink();
        }
        else if(sp <= 0){
            System.out.println("Stack underflow!");
            sp = 1;
        }
        return stackArray[--sp];
    }

    public void expand(){   
        size = size * 2;                    // function for expanding the stackArray
        int[] expandedStack = new int[size];

        for(int i = 0; i < stackArray.length; i++){
            expandedStack[i] = stackArray[i];
        }
        stackArray = expandedStack;
        System.out.println("Expand");
        System.out.println(Arrays.toString(stackArray));
    }

    public void shrink() {
        size = size / 2;
        int[] shrunkenStack = new int[size];
        for(int i = 0; i < size; i++){
            shrunkenStack[i] = stackArray[i];
        }
        stackArray = shrunkenStack;
        System.out.println(Arrays.toString(stackArray));
    }
    
}
