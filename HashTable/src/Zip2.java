import java.io.BufferedReader;
import java.io.FileReader;

public class Zip2 {
    Zip2.Node[] data;
    int max;

    public class Node{
        String name;
        Integer population;

        public Node(String name, Integer population){
            this.name = name;
            this.population = population;
        }
    }

    public Zip2(String file){
        data = new Zip2.Node[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code] = new Node(row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public boolean lookup(Integer zip){
        if(zip > 99999 || zip < 0){
            return false;
        }
        if(data[zip] != null){
            return true;
        }
        return false;

    }

/*    public boolean binary_search(Integer code) {
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

 */
}
