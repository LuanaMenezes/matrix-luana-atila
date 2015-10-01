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
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Luana Menezes
 */
public class Matrix {
   
    private String fileName;
    private static double[][] matrix1;
    private static double[][] matrix2;
    private static double[][] result;
    private static boolean allow = true;
   
    
     public String getFile()
    {
        return fileName;
    }
    
    public String setFile(String f)
    {
        try
        {
            if(f != null || f != "")
            {
                this.fileName = f;
            }  
        }
        catch(NullPointerException e)
        {
            System.out.println("This file does not exists.");
        }
        
        return fileName;
    }
   
    public static void readFile(String file) throws IOException
    {
            
            List<String> lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
                 
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
            matrix1 = new double[count1][count2];
            matrix2 = new double[count2][count3];
            result = new double[count1][count3];
            
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
              
          
    }
    public void mutiply()
    {
        if(matrix1[0].length == matrix2.length) // Verify if number of columns of matrix1 is equals to number of rows of matrix2
        {
            for(int i=0; i<matrix1.length;i++)
            {
                for(int j=0; j<matrix2[0].length;j++)
                {
                    for(int k=0; k<matrix1[0].length;k++) 
                    {
                        result[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
        }
        else
        {
            System.out.println("Cannot multiply these matrices. "
                    + "Number of columns of matrix A differs from number of rows of matrix B");
            allow = false;
        }
    }

    public String toString(double matrix[][])
    {
	String output = "";

	for (int i=0; i<matrix.length; i++)
        {
            for (int j=0; j<matrix[0].length; j++)
            {
		output += "["+ matrix[i][j] + "]\t";
            }	
            output +="\n";	
        }	
	return output; 
    }

   
    
    public static void main(String[] args) throws IOException
    {        
        Matrix matrix = new Matrix();
     //   String f = matrix.setFile("c:/matrix.txt"); // For Windows
        String desktop = System.getProperty ("user.home") + "/Desktop/"; // For Mac OS
        String f = matrix.setFile(desktop + "matrix.txt"); // For Mac OS
        matrix.readFile(f);
        matrix.mutiply();
        if(allow)
        {
            System.out.println("\nMatrix A\n");
            System.out.print(matrix.toString(matrix1));
            System.out.println("\nMatrix B\n");
            System.out.print(matrix.toString(matrix2));
            System.out.println("\nMatrix C = A * B\n");
            System.out.print(matrix.toString(result));
        }
    }
  }
