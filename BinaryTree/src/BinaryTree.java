import java.util.Iterator;
import java.util.Random;

public class BinaryTree implements Iterable<Integer>{
    static Node root;
    public Iterator<Integer> iterator(){
        return new TreeIterator();
    }

    public BinaryTree(){
        root = null;
    }

    public void add(Integer key, Integer value){
        if(root == null){
            root = new Node(key, value);
        } else {
            root.addNode(key, value);
        }
    }

    public Integer lookup(Integer key){
        return root.lookup(key);
    }

    public BinaryTree nodeGen(Integer key, Integer value, int n){
        Random rnd = new Random();
        BinaryTree bt = new BinaryTree();
        //BinaryTree.Node trad = bt.new Node(key,value);
        for (int i = 0; i< n; i++){
            bt.add(rnd.nextInt(n), rnd.nextInt(n*3));
        }
        return bt;
    }

    public class Node{
        public Integer key;
        public Integer value;
        public Node left;
        public Node right;

        public Node(Integer key, Integer value){
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
        public Node addNode(Integer key, Integer value){
            if(this.key == key){
                this.value = value;
            }
            if (this.key > key){
                if (this.left == null){
                    this.left = new Node(key, value);
                }
                else {
                    this.left = this.left.addNode(key, value);
                }
            } else {
                if(this.right == null){
                    this.right = new Node(key, value);
                } else {
                    this.right = this.right.addNode(key, value);
                }
            }
            return this;
        }
        public Integer lookup(Integer key){
            Node current = this;
            while (current != null){
                if(current.key == key){
                    return current.key;
                } else if (current.key > key) {
                    current = current.left;
                }else {
                    current = current.right;
                }
            }
            return null;
        }

        public void print() {
            if(left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if(right != null)
                right.print();
        }




    }

}
