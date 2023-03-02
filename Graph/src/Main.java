public class Main {
    public static void main(String[] args) {
        Map map = new Map("G:\\Min enhet\\Skola\\AlgoData\\trains.csv");

        int t = 0;
        for (int i = 0; i < map.cities.length; i++){
            if(map.cities[i] != null) {
                System.out.println(i + ", " + map.cities[i].name);
                t++;
            }
        }
        System.out.println(t);


    }

    private static Integer hashN(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 % 541) + name.charAt(i);
        }
        return hash % 541;
    }

}