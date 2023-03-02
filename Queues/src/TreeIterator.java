import java.util.Iterator;
import java.util.Stack;

public class TreeIterator implements Iterator<Integer> {
    private BinaryTree.Node next;
    private SecondQueue queue;
    public TreeIterator() {
        queue = new SecondQueue();
        queue.add(BinaryTree.root);
    }
    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
    @Override
    public Integer next() {
        if(hasNext() == false){
            return null;
        }
        BinaryTree.Node curr = queue.head.data;
        Integer data = curr.value;
        if(curr.left != null){
            queue.add(curr.left);
        }
        if (curr.right != null){
            queue.add(curr.right);
        }
        queue.remove();
        return data;
    }

    @Override
    public void remove() {
        System.out.println("shlomo");
        throw new UnsupportedOperationException();
    }
}
