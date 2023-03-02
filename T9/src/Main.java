public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        String[] tbr = trie.search(trie.root, "515", 0, "");
        for (int i = 0; i < tbr.length; i++){
            System.out.println(tbr[i] + ", ");
        }
    }
}