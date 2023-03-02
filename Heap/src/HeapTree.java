import java.util.Random;

public class HeapTree {
    Node root;
    public Integer depth = 0;
    public Integer depthAdd = 0;

    public HeapTree(){
        root = null;
    }

    public Integer add(Integer value){
        depthAdd = 1;
        if(root == null){
            root = new Node(value);
            return depthAdd;
        } else {
            return root.addNode(value);
        }
    }
    public Integer remove(){
        if(root == null){
            return null;
        } else {
            Integer t = root.value;
            root.removeNode();
            return t;
        }
    }

    public Integer push(Integer incr) {
        if (root != null) {
            root.value += incr;
            return root.push();
        }
        return null;
    }

    public HeapTree generate(Integer n) {
        Random rnd = new Random();
        HeapTree tree = new HeapTree();
        for(int i = 0; i < n; i++) {
            tree.add(rnd.nextInt(101));
        }
        return tree;
    }

    /*public Integer push (Integer incr){
        if(root == null) {
            return null;
        }
        else if (root.size == 1) {
            root.value += incr;
            return 1;
        } else {
            root.value += incr;
            return root.push();
        }
    }
     */
    public class Node{
        public Integer value;

        public Integer size = 1;
        public Node left;
        public Node right;

        public Node(Integer value){
            this.value = value;
            this.left = this.right = null;
        }

        public Integer addNode(Integer value){
            this.size++;
            Node curr = this;
            Integer box;
            depthAdd++;

            //if new value less, then swap with curr
            if(curr.value > value){
                box = curr.value;
                curr.value = value;
                depthAdd--;
            } else {
                box = value;
            }


            if(curr.left == null){
                curr.left = new Node(box);
            } else if(curr.right == null){
                curr.right = new Node(box);
            } else if (curr.left.size < curr.right.size) {
                curr.left.addNode(box);
            } else if (curr.right.size < curr.left.size) {
                curr.right.addNode(box);
            } else {
                curr.left.addNode(box);
            }

            return depthAdd;
        }

        public void removeNode(){
           if(root.size == 1){
                root = null;
            }
            Node curr = this;
            curr.size--;

            if(curr.left == null){
                curr.value = curr.right.value;
                if(curr.right.size == 1){
                    curr.right = null;
                } else {
                    curr = curr.right;
                    //curr.size--;
                    curr.removeNode();
                }
            } else if(curr.right == null){
                curr.value = curr.left.value;
                if(curr.left.size == 1){
                    curr.left = null;
                } else {
                    curr = curr.left;
                    //curr.size--;
                    curr.removeNode();
                }
            } else if(curr.right.value < curr.left.value){
                curr.value = curr.right.value;
                if(curr.right.size == 1){
                    curr.right = null;
                } else {
                    curr = curr.right;
                    curr.removeNode();
                }
            } else{
                curr.value = curr.left.value;
                if(curr.left.size == 1){
                    curr.left = null;
                } else {
                    curr = curr.left;
                    curr.removeNode();
                }
            }


            /*
            if (this.left == null){
                return  this.right;
            } else if (this.right == null){
                return  this.left;
            } else if (this.right.value > this.left.value){
                this.value =  this.left.value;
                this.size--;
                if(this.left.size == 0)
                    this.left = null;
                else
                    this.left = this.left.removeNode();
                return this;
            } else {
                this.value =  this.right.value;
                this.size--;
                if(this.right.size == 0)
                    this.right = null;
                else
                    this.right = this.right.removeNode();
                return this;
            }
             */
        }

        /*public Integer push(){
            depth++;
            Node curr = this;

            if(curr.left == null){
                Integer temp = curr.value;
                if(curr.right.size == 1 && curr.right.value < curr.value){
                    curr.value = curr.right.value;
                    curr.right.value = temp;
                    return ++depth;
                } else if(curr.right.size == 1 && curr.right.value > curr.value) {
                    return depth;
                } else if(curr.right.value > curr.value){
                    return depth;
                } else {
                    curr.value = curr.right.value;
                    curr.right.value = temp;
                    curr = curr.right;
                    curr.push();
                }
            } else if (curr.right == null) {
                Integer temp = curr.value;
                if(curr.left.size == 1 && curr.left.value < curr.value){
                    curr.value = curr.left.value;
                    curr.left.value = temp;
                    return ++depth;
                } else if(curr.left.size == 1 && curr.left.value > curr.value) {
                    return depth;
                } else if(curr.left.value > curr.value){
                    return depth;
                } else {
                    curr.value = curr.left.value;
                    curr.left.value = temp;
                    curr = curr.left;
                    curr.push();
                }
            } else if (curr.left.value < curr.right.value) {
                Integer temp = curr.value;
                if(curr.left.size == 1 && curr.left.value < curr.value){
                    curr.value = curr.left.value;
                    curr.left.value = temp;
                    return ++depth;
                } else if(curr.left.size == 1 && curr.left.value > curr.value) {
                    return depth;
                } else if (curr.left.value < curr.value) {
                    curr.value = curr.left.value;
                    curr.left.value = temp;
                    curr = curr.left;
                    curr.push();
                }
            } else {
                Integer temp = curr.value;
                if(curr.right.size == 1 && curr.right.value < curr.value){
                    curr.value = curr.right.value;
                    curr.right.value = temp;
                    return ++depth;
                } else if(curr.right.size == 1 && curr.right.value > curr.value) {
                    return depth;
                } else if (curr.right.value < curr.value) {
                    curr.value = curr.right.value;
                    curr.right.value = temp;
                    curr = curr.right;
                    curr.push();
                }
            }
            return depth;
        }
        */

        public Integer push() {
            Node currentNode = this;
            depth++;
            if (currentNode.left == null && currentNode.right == null) {
                return depth;
            }
            else if (currentNode.left != null && currentNode.left.value < currentNode.value) {
                if (currentNode.right != null && currentNode.right.value < currentNode.left.value) {
                    Integer temp = currentNode.value;
                    currentNode.value = currentNode.right.value;
                    currentNode.right.value = temp;
                    // depth++;
                    currentNode.right.push();
                }
                else {
                    Integer temp = currentNode.value;
                    currentNode.value = currentNode.left.value;
                    currentNode.left.value = temp;
                    // depth++;
                    currentNode.left.push();
                }
            }
            else if (currentNode.right != null && currentNode.right.value < currentNode.value) {
                if (currentNode.left != null && currentNode.left.value < currentNode.right.value) {
                    Integer temp = currentNode.value;
                    currentNode.value = currentNode.left.value;
                    currentNode.left.value = temp;
                    // depth++;
                    currentNode.left.push();
                }
                else {
                    Integer temp = currentNode.value;
                    currentNode.value = currentNode.right.value;
                    currentNode.right.value = temp;
                    // depth++;
                    currentNode.right.push();
                }
            }
            return depth;
        }
    }
}
