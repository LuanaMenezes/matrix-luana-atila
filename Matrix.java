/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.io.File;
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
    
   
    public static void readFile(Path path, String file) throws IOException
    {
            
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                 
            //Some variables
           String[] count = null;
           int count1, count2, count3 = 0;

           // Reading a file 
            Scanner in = new Scanner(new File(file));
            
            //Capturing only the first line
            String firstLine = new String(in.nextLine());
            count = firstLine.split(" ");
            
            // Checking the size of the matrix in accord of the first line
            count1 = Integer.parseInt(count[0]);
            count2 = Integer.parseInt(count[1]);
            count3 = Integer.parseInt(count[2]);     
            double[][] matrix1 = new double[count1][count2];
            double[][] matrix2 = new double[count2][count3];
            double[][] result = new double[count1][count3];
            
            // For the first matrix 
             int rowIndex = 0;
             
             for(int i = 1; i < (count1+1); i++)
             {               
                 String lines2 =  lines.get(i+1).replace(",", "");
                 List<String> strings = Arrays.asList(new String[]{lines2});
                 String[] tokens = strings.get(0).split("\\s+");   //split every line
                 for(int columnIndex = 0; columnIndex < count2; columnIndex++){
                 matrix1[rowIndex][columnIndex] = Double.parseDouble(tokens[columnIndex]);}  //convert every token to a double
                 rowIndex=rowIndex + 1;
             }
              
             // Print first matrix - Is not necessary
             for(int i =0; i<count1; i++)
             {
                for(int j=0; j<count2; j++)
                {
                    System.out.print(matrix1[i][j] + " ");
                }

                System.out.println("\n");
              }
             
             
              // For the second matrix 
              
             int numlines = 3;
             rowIndex = 0;
             
              for(int i = 0; i <count2; i++)
             {               
                 String lines2 =  lines.get(count1+numlines+i).replace(",", "");
                 List<String> strings = Arrays.asList(new String[]{lines2});
                 String[] tokens = strings.get(0).split("\\s+");   //split every line
                 for(int columnIndex = 0; columnIndex < count3; columnIndex++){
                 matrix2[rowIndex][columnIndex] = Double.parseDouble(tokens[columnIndex]);}  //convert every token to a double
                 rowIndex=rowIndex + 1;
             }
              
            // Print second matrix - Is not necessary
             for(int i =0; i<count2; i++)
             {
                for(int j=0; j<count3; j++)
                {
                    System.out.print(matrix2[i][j] + " ");
                }

                System.out.println("\n");
              }
    }
   
    
    public static void main(String[] args) throws IOException
    {        
        Matrix matrix = new Matrix();
        Path p = Paths.get("c:/matrix.txt");
        String f = "c:/matrix.txt";
        matrix.readFile(p, f);
        
    }
  }