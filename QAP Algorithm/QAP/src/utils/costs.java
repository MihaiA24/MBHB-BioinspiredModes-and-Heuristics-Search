package utils;

public class Costs {


    public static int getCost(int [][] values,int [][] distance, int[] solArray) {
         int sol = 0;

         for(int i = 0; i < solArray.length; i++){
             for(int j = 0; j < solArray.length; j++){
                 sol += values[i][j] * distance[solArray[i]][solArray[j]];
             }
         }
         return sol;
    }
}
