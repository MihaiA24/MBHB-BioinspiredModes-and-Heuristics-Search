package algorithms;

import utils.Costs;
import utils.FileManager;
import utils.Results;

import java.io.IOException;
import java.util.Random;

public class RandomSearchAlgorithm extends Algorithm {

    protected RandomSearchAlgorithm(int[][] table) {
        super(table);
    }

    private int[] getRandomSolution() {
        Random r = new Random(System.currentTimeMillis());

        int [] ord = new int[size];

        for(int i =0;i<size;i++) {
            ord[i] = i;
        }
        int [] sol = new int[size];

        int k = size;
        for(int i=0;i<size;i++){
            int ale= r.nextInt(k);
            sol[i]=ord[ale];
            ord[ale]=ord[k-1];
            k--;
        }
        return sol;
    }

    public Results applyRandomSeach(int nIter) {
        int [] initSolution = this.getRandomSolution();
        int [] actualSolution;
        int [] bestSolution = initSolution;
        int iter = 0;

        for(int l=0;l<nIter;l++) {
            actualSolution = this.getRandomSolution();
            if(Costs.getCost(this.values,this.distance,actualSolution) < Costs.getCost(this.values,this.distance,bestSolution)) {
                bestSolution = actualSolution;
            }
            iter +=2;
        }
        return new Results(bestSolution, Costs.getCost(this.values,this.distance,bestSolution), iter);
    }

    public static void main(String[] args) throws IOException {
        FileManager fileManager = new FileManager();
        int [][] table = fileManager.readFile("resources/datasets/tai25b.dat");

        RandomSearchAlgorithm randomSearchAlgorithm = new RandomSearchAlgorithm(table);

        System.out.println("Busqueda aleatoria ------ ");
        Results r = randomSearchAlgorithm.applyRandomSeach(10000);
        for(int i : r.getSol()){
            System.out.print(i + " ");
        }

        System.out.println("Mejor Sol: " + r.getCost());
    }
}
