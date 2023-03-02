public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(5,105);
        tree.add(2,102);
        tree.add(7,107);
        tree.add(1,101);
        tree.add(8,108);
        tree.add(6,106);
        tree.add(3,103);

        QueueArray queueArray = new QueueArray(4);
        queueArray.enqueue(tree.root);
        queueArray.enqueue(tree.root.left);
        queueArray.enqueue(tree.root.right);
        queueArray.enqueue(tree.root.left.left);
        queueArray.enqueue(tree.root);
        queueArray.enqueue(tree.root);
        queueArray.enqueue(tree.root.left.left);
        queueArray.enqueue(tree.root);
        queueArray.enqueue(tree.root);
        queueArray.enqueue(tree.root.left.left);


        for (int i = 0; i < queueArray.array.length; i++){
            if(queueArray.array[i] != null)
                System.out.println(queueArray.array[i].value);
        }
        System.out.println("first: " + queueArray.first);
        System.out.println("last: " + queueArray.last);
        System.out.println("sizze: " + queueArray.array.length);
    }
}