/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Luana Menezes
 */
public class Matrix {
    
    public void readFile(String f) throws java.io.FileNotFoundException,java.io.IOException{ 
     
        try {
        File fil = new File("c:/matrix.txt");
        FileReader dataFile = new FileReader(fil);
        BufferedReader in = new BufferedReader(dataFile);

        String m = in.readLine();

        int size = m.length();

        String [][] matrix = new String [size][size];

        double d = 0;
        String line = m;
        String[] split = m.split(", ");    
        
       /* for(int i = 0; i < split.length; i++)
        { 
             d = Double.parseDouble(split[i]);
             matrix[0][i] = d;
        } */
               
          for (int j = 0; j < 8; j++)
          {
              
               matrix[0][j] = String.valueOf(split[j]);
          }
          for (int i = 1; (line = in.readLine()) != null; ++i)
          {
                for (int j = 0; j < 8; j++) 
                {
                   matrix[i][j] = String.valueOf(line.charAt(j));
                }
          }

           for (int i = 0; i < 8; i++) 
           {
                for (int j = 0; j < 8; j++) 
                {
                   System.out.print(matrix[i][j] + " ");
                }
             System.out.println("");
           }

        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
}  
    
    public static void main(String[] args) throws IOException
    {        
        Matrix matrixIO = new Matrix();
        matrixIO.readFile("c:/matrix.txt");
       
    }
  }
    

