package utils;

public class Results {
    private int  [] sol;
    private int cost;
    private int iterations; // numero de iteraciones


    public Results(int [] sol,int cost, int nIter){
        this.sol = sol;
        this.cost = cost;
        this.iterations = nIter;
    }

    public int[] getSol() {
        return sol;
    }

    public void setSol(int[] sol) {
        this.sol = sol;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
}
