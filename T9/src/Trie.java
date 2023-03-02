import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Random;

public class Trie {
    Node root;

    public Trie(){
        root = new Node();

        try (BufferedReader bufReader = new BufferedReader(new FileReader("kelly.txt"))){
            String line = bufReader.readLine();
            while (line != null) {
                add(line);
                line = bufReader.readLine();
            }
            bufReader.close();
        }
        catch (Exception e) {
            System.out.println("file ");
            e.printStackTrace();
        }

    }

    public boolean lookup(String word){
        return false;
    }

    public class Node{
        public Node[] next;
        public Boolean word;

        public Node(){
            next = new Node[27];
            word = false;
        }

    }

    public Integer getIndexFromChar(char letter){
        if((letter - 'a') == 16 || (letter - 'a') == 22){
            return null;
        } else if ((letter - 'a') == 132) {
            return 24;
        } else if ((letter - 'a') == 131) {
            return 25;
        } else if ((letter - 'a') == 149) {
            return 26;
        } else if ((letter - 'a') > 20) {
            return (letter - 'a') - 2;
        } else if ((letter - 'a') > 16) {
            return (letter - 'a') - 1;
        } else {
            return letter - 'a';
        }
    }

    public char getCharFromCode(int code){
        if(code < 16){
            return (char)(code + 97);
        } else if (code == 16) {
            return 'r';
        } else if (code == 21) {
            return 'x';
        } else if (code == 24) {
            return 'å';
        } else if (code == 25) {
            return 'ä';
        } else if (code == 26) {
            return 'ö';
        } else if (code < 21){
            return (char)(code + 97 + 1);
        } else {
            return (char)(code + 97 + 2);
        }
    }

    public int getIndexFromKey(int key){
        return key - 1;
    }

    public int getKeyfromChar(char letter){
        return (getIndexFromChar(letter) / 3) + 1;
    }

    public void add(String word){
        if(word == null || word.isEmpty()){
            throw new IllegalArgumentException("Invalid input");
        }

        Node curr = root;

        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = getIndexFromChar(c);

            if (curr.next[index] == null){
                curr.next[index] = new Node();
                curr = curr.next[index];
            } else {
                curr = curr.next[index];
            }
        }
        curr.word = true;
    }

    public int getNumberFromChar(char c){
        return c - '0';
    }

    public String[] search(Node curr, String keySeq, int pos, String sofar){
        if(curr == null){
            return new String[0];
        }

        if(pos == keySeq.length()){
            if(curr.word){
                String[] tbr = new String[1];
                tbr[0] = sofar;
                return tbr;
            } else {
                return new String[0];
            }
        }

        Integer index = getIndexFromKey(getNumberFromChar(keySeq.charAt(pos)));
        Integer branch1 = index*3;
        Integer branch2 = index*3 + 1;
        Integer branch3 = index*3 + 2;

        String[] one = search(curr.next[branch1], keySeq, pos + 1, sofar + getCharFromCode(branch1));
        String[] two = search(curr.next[branch2], keySeq, pos + 1, sofar + getCharFromCode(branch2));
        String[] three = search(curr.next[branch3], keySeq, pos + 1, sofar + getCharFromCode(branch3));

        int size = one.length + two.length + three.length;

        String[] res = new String[size];

        for (int i = 0; i < one.length; i++){
            res[i] = one[i];
        }

        int b = one.length;
        for (int i = b; i < two.length; i++){
            res[i] = two[i];
        }

        int c = two.length;
        for (int i = c; i < three.length; i++){
            res[i] = three[i];
        }

        return res;

    }


}
