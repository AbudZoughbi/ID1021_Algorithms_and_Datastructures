public class QueueArray {
    BinaryTree.Node[] array;

    int first, last;

    public QueueArray(int n){
        array = new BinaryTree.Node[n];
        first = -1;
        last = -1;
    }

    public void enqueue(BinaryTree.Node node){
       if((last + 1)% array.length == first){
           System.out.println("kön är full + ökad arrraayyzz");

           BinaryTree.Node[] temp = new BinaryTree.Node[array.length * 2];
           for (int i = 0; i < array.length; i++){
               temp[i] = array[i];
           }
           array = temp;
           last = (last + 1);
           array[last] = node;
        }
        else if(this.isEmpty()){
            first = last = 0;
            array[first] = node;
        } else {
            last = (last + 1) % array.length;
            array[last] = node;
        }
    }

    public BinaryTree.Node dequeue(){
        if(isEmpty()){
            return null;
        } else if(first == last){
            BinaryTree.Node tbr = array[first];
            first = last = -1;
            return tbr;
        } else {
            BinaryTree.Node tbr = array[first];
            array[first] = null;
            first = (first + 1) % array.length;
            return tbr;
        }

    }

    public boolean isEmpty() {
        if (first == -1 && last == -1) {
            return true;
        }
        return false;
    }
}
