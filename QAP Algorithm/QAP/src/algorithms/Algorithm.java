package algorithms;

public abstract class Algorithm {
    protected int [][] values;
    protected int [][] distance;
    protected int size;

    protected Algorithm(int [][] table){
        initTables(table);
    }


    protected void initTables(int [][] table){
        this.size = table.length/2;
        this.distance = new int[size][size];
        this.values = new int[size][size];

        for(int i=0;i < size;i++) {
            for(int j=0;j < size;j++) {
                values[i][j] = table[i][j];
                distance[i][j] = table[i+size][j];
            }
        }
    }
}
