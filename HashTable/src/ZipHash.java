import java.io.BufferedReader;
import java.io.FileReader;

public class ZipHash {
    Node[] data;

    Node[] buckets;
    Integer[] keys;
    int max;
    Integer mod = 21521;

    public class Node{
        String name;
        Integer population;
        Integer code;
        Node next;

        public Node(Integer code, String name, Integer population){
            this.code = code;
            this.name = name;
            this.population = population;
            this.next = null;
        }
    }

    public ZipHash(String file){
        data = new ZipHash.Node[10000];
        keys = new Integer[10000];
        buckets = new Node[30000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                keys[i] = code;
                data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    /*public boolean lookup(Integer zip){
        if(zip > 99999 || zip < 0){
            return false;
        }
        if(data[zip] != null){
            return true;
        }
        return false;
    }
     */

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.println("Mod: " + mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }

    public Integer getHash(Integer code) {
        return code % mod;
    }

    public void add(Node node){
        Integer index = getHash(node.code);
        if(buckets[index] == null){
            buckets[index] = node;
        } else {
            Node curr = buckets[index];
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = node;
        }
    }

    public void addBucketLast(Node node){
        Integer index = getHash(node.code);
        if(buckets[index] == null){
            buckets[index] = node;
        }else {
            while (buckets[++index] != null) {}
            buckets[index] = node;
        }
    }

    public Integer lookupLast(Integer zipC){
        Integer index = getHash(zipC);
        Integer temp = 0;
        if (buckets[index] != null) {
            if (buckets[index].code.equals(zipC)) {
                return buckets[index].code;
            }
            while (buckets[++index] != null) {
                temp++;
                if (buckets[index].code.equals(zipC)) {
                    System.out.println("found: " + buckets[index].code);
                    //return buckets[index].code;
                    return temp;
                }
            }
        }
        System.out.println("Not found!");
        return null;
    }

    public void fillBucket(){
        for (int i = 0; i < 9675; i++){
            addBucketLast(data[i]);
        }
    }

    public Integer lookup(Integer zipC){
        Integer index = getHash(zipC);
        if(buckets[index] == null){
            return null;
        } else {
            Node curr = buckets[index];
            while (curr.next != null){
                System.out.println(curr.code);
                if(curr.code.equals(zipC)){
                    return curr.code;
                } else {
                    curr = curr.next;
                }
            }
            if(curr.code.equals(zipC)){
                return curr.code;
            }
        }
        System.out.println("did not find!");
        return null;
    }



}
