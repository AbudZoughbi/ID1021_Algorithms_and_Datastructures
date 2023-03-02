public class BinaryTree {
    public class Node{
        public int key;
        public int value;
        public Node left, right;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }

    Node root;
    public BinaryTree(){
        root = null;
    }

    public void add(int key, int value){

    }

    public int lookup(int key){
        return 0;
    }
}
