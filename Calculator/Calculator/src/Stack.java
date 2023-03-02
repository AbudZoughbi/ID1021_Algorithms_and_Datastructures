public class Stack {
    int[] stackArray = new int[1000];
    private int sp = 0;

    public void push(int in) {
        if(sp < stackArray.length){
            stackArray[sp] = in;
            sp++;
        }
        else
            System.out.println("Stack overflow!");
    }

    public int pop() {
        if(sp < 0){
            return 0;
        }
        else
            return stackArray[--sp];

        /*
        if(sp == stackArray.length)
            sp--;
        if(sp <= 0)
            System.out.println("Stack underflow!");
        return stackArray[--sp];
        */
    }
}
