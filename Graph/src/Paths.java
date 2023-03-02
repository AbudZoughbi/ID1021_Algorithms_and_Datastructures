public class Paths {
        City[] path;
        int sp;
        public Paths() {
            path = new City[54];
            sp = 0;
        }
        public Integer shortest(City from, City to, Integer max) {
            if(max < 0)
                return null;
            if(from == to)
                return 0;

            Integer shrt = null;

            for (int i = 0; i < sp; i++) {
                if (path[i] == from)
                    return null;
            }
            path[sp++] = from;
            for (int i = 0; i < from.neighbours.length; i++){
                if(from.neighbours[i] != null){
                    Connection conn = from.neighbours[i];
                    Integer dist  = shortest(conn.city, to, max - conn.distance);
                    if((dist != null) && ((shrt == null) || (shrt > dist + conn.distance))){
                        shrt = dist + conn.distance;
                    }
                    //Improved version
                    if((shrt != null) && max > shrt){
                        max = shrt;
                    }

                }
            }
            path[sp--] = null;
            return shrt;
        }

    public static void main(String[] args) {
        Map map = new Map("G:\\Min enhet\\Skola\\AlgoData\\trains.csv");
        Paths paths = new Paths();

        String from = "Malmö";
        String to = "Stockholm";
        Integer max = 100000900;

        long t0 = System.nanoTime();
        Integer dist = paths.shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;

        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }
}
