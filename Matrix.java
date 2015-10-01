/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Luana Menezes
 */
public class Matrix {
    
   
    public static double[][] readFile(Path path) throws IOException
    {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            
            int NR_OF_COLUMNS = 9;
            int NR_OF_ROWS = lines.size();

            double[][] result = new double[NR_OF_ROWS][NR_OF_COLUMNS];

             for(int rowIndex = 0; rowIndex < NR_OF_ROWS; rowIndex++)
             {
                 String lines2 =  lines.get(rowIndex).replace(",", "");
                 List<String> strings = Arrays.asList(new String[]{lines2});
                 String[] tokens = strings.get(0).split("\\s+");   //split every line
                 for(int columnIndex = 0; columnIndex < NR_OF_COLUMNS; columnIndex++)
                 result[rowIndex][columnIndex] = Double.parseDouble(tokens[columnIndex]);   //convert every token to an integer
             }
            
              return result;
    }
    
    public static void display(double m[][])
    {
        for(int i =0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                System.out.print(m[i][j] + " ");
            }
            
            System.out.println("\n");
        }
    }
    
    public static void main(String[] args) throws IOException
    {        
        Matrix matrixIO = new Matrix();
        Path p = Paths.get("c:/matrix.txt");
        double matrix[][];
        matrix = matrixIO.readFile(p);
        display(matrix);
    }
  }