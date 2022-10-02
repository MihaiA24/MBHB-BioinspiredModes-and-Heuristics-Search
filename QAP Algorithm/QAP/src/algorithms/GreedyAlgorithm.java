package algorithms;

import utils.Costs;
import utils.FileManager;
import utils.Results;

import java.io.IOException;

public class GreedyAlgorithm extends Algorithm {

    protected GreedyAlgorithm(int[][] table) {
        super(table);
    }

    public Results applyGreedy() {
        int[] pValues = new int[this.size];
        int[] pDistance = new int[this.size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                pValues[i] += this.values[i][j];
                pDistance[i] += this.distance[i][j];
            }
        }

        int[] sol = new int[this.size];
        int v;
        int d;

        for (int k = 0; k < size; k++) {
            v = 0;
            d = 0;
            for (int i = 0; i < size; i++) {
                if (pValues[i] > pValues[v])
                    v = i;
                if (pDistance[i] < pDistance[d])
                    d = i;
            }
            sol[v] = d;
            pDistance[d] = Integer.MAX_VALUE;
            pValues[v] = 0;
        }

        return new Results(sol, Costs.getCost(values, distance, sol), 1);
    }

    public static void main(String[] args) throws IOException {
        FileManager fileManager = new FileManager();
        int [][] table = fileManager.readFile("resources/datasets/tai25b.dat");

        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm(table);

        System.out.println("Greedy ------ ");
        Results r = greedyAlgorithm.applyGreedy();
        for(int i : r.getSol()){
            System.out.print(i + " ");
        }

        System.out.println("Mejor Sol: " + r.getCost());
    }
}
