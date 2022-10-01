package utils;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FileManager {

    public int[][] readFile(String name) throws IOException {

        int size;
        int counter = 0;
        int [][] values;
        String line;
        System.out.println(Path.of("."));
        try (FileReader fr = new FileReader(name)) {
            BufferedReader br = new BufferedReader(fr);

            // First line identifies table length and witdh
            size = Integer.parseInt(br.readLine().trim());

            values = new int[size * 2][size];

            while((line = br.readLine()) != null){
                List<Integer> numbers = Arrays.stream(line.trim().split(" +")).map(Integer::parseInt).collect(Collectors.toList());
                for(int i = 0; i < size; i++){
                    values[counter][i] = numbers.get(i);
                }
                counter++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Cannot read file correctly");
        }

        return  values;
    }

    /**
     *
     * @param fileName
     * @param results
     * @throws IOException
     */
    public void writeFile(String fileName,Results [] results) throws IOException {

        try (FileWriter fileWriter = new FileWriter(fileName)) {

            for (int i = 0; i < results.length; i++) {
                fileWriter.write("Solucion " + (i + 1) + "\n");
                for (int s : results[i].getSol()) {
                    fileWriter.write(s + " ");
                }
                fileWriter.write("\n");
                fileWriter.write("Coste: " + results[i].getCost() + "\n");
                fileWriter.write("Evaluaciones: " + results[i].getIterations() + "\n");
            }

        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public static void main(String [] args) throws IOException {

        // Check correct read file
        FileManager file = new FileManager();
        int [][] values = file.readFile("resources/datasets/tai25b.dat");

        System.out.println("Length: " + values.length);
        int halfSize = values.length / 2;

        for(int i = 0; i < halfSize; i++) {
            for(int j = 0; j < halfSize; j++) {
                System.out.print(values[i][j] + " ");
            }
            System.out.println("\n----------------------------------- LINEA: " + (i+1) + " -----------------------------");
        }

    }
}

