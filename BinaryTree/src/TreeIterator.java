import java.util.Iterator;
import java.util.Stack;

public class TreeIterator implements Iterator<Integer> {
    private BinaryTree.Node next;
    private Stack<BinaryTree.Node> stack;
    public TreeIterator() {
        stack = new Stack<BinaryTree.Node>();
        next = BinaryTree.root;
        while (next != null){
            stack.push(next);
            next = next.left;
        }
    }
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    @Override
    public Integer next() {
        if(hasNext() == false) {
            return null;
        }
        BinaryTree.Node current = stack.pop();
        if(current.right != null){
            while (current.right != null){
                stack.push(current.right);
                current.right = current.right.left;
            }
        }
        return current.value;
    }

    @Override
    public void remove() {
        System.out.println("shlomo");
        throw new UnsupportedOperationException();
    }
}
