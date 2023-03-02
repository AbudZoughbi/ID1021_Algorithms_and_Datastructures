public class City {
    String name;
    Connection[] neighbours;

    public City(String name){
        this.name = name;
        this.neighbours = new Connection[4];
    }

    public void addC(City next, int dist){
        Connection nextC = new Connection(next, dist);
        for(int i = 0; i < neighbours.length; i++){
            if(this.neighbours[i] == null){
                this.neighbours[i] = nextC;
                return;
            }
        }

    }
}
