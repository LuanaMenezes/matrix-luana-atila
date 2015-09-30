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

        double [][] matrix = new double [size][size];

        double d = 0;
    //    String line = m;
        String[] split = m.split(",");    
        while((m = in.readLine()) != null)
        {
            for (int i= 0; i < split.length; i++)
            {
                for (int j= 0; j < split.length; j++)
                {
                    d = Double.parseDouble(split[j]);
                   // System.out.println(d);
                    matrix[i][j] = d;     
                }
            }
        }
        
        
        
        
        
       /* for(int i = 0; i < split.length; i++)
        { 
             d = Double.parseDouble(split[i]);
             matrix[0][i] = d;
        } */
               
        /*  for (int j = 0; j < 9; j++)
          {
              
               matrix[0][j] = split[j];
          }
          for (int i = 1; (line = in.readLine()) != null; ++i)
          {
                for (int j = 0; j < 9; j++) 
                {
                   matrix[i][j] = String.valueOf(line.charAt(j));
                }
          }*/

        
        
           for (int i = 0; i < 9; i++) 
           {
                for (int j = 0; j < 9; j++) 
                {
                   System.out.print(matrix[i][j] + " ");
                   
                }
                System.out.println("\n");
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
