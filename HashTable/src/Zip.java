import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
    Node[] data;
    int max;

    public class Node{
        String code;
        String name;
        Integer population;

        public Node(String code, String name, Integer population){
            this.code = code;
            this.name = name;
            this.population = population;
        }
    }

    public Zip(String file){
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public boolean lookup(String zip){
        for (int i = 0; i < 9675; i++){
            if(data[i].code.equals(zip)){
                return true;
            }
        }
        return false;
    }

    public boolean binary_search(String code) {
        Integer min = 0;
        Integer high = 9674;

        while (true) {
            int mid = min + (high - min) / 2;

            if (data[mid].code.equals(code)) {
                return true;
            }
            if (data[mid].code.compareTo(code) < 0 && mid < high) {
                min = mid + 1;
                continue;
            }
            if (data[mid].code.compareTo(code) > 0 && mid > min) {
                high = mid - 1;
                continue;
            }
            break;
        }
        return false;
    }
}
