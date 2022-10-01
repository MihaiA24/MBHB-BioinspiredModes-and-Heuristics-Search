package utils;

public class costs {

    int[][] value;
    int[][] distance;

    public costs(int[][] values,int [][] dist){
        this.value = values;
        this.distance = dist;
    }

    public int getCost(int[] solArray) {
         int sol = 0;

         for(int i = 0; i < solArray.length; i++){
             for(int j = 0; j < solArray.length; j++){
                 sol += value[i][j] * distance[solArray[i]][solArray[j]];
             }
         }
         return sol;
    }
}
