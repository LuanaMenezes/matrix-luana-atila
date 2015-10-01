

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 @author Luana Menezes e Atila Souza
 */
public class File extends Matrix{
    public String fileName;
    
    public String setFile(String f)
    {
        if(f != null && f != "")
        {
            this.fileName = f;
        }
        else
        {
            System.out.println("File does not exists !");
            System.exit(0);
        }
        
        return fileName;
    }
    
    public String getFile()
    {
        return fileName;
    }
    
    public static void readFile(String file) throws IOException
    {
           try
           {
            List<String> lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
                 
            //Some variables
           String[] count;
           int count1, count2, count3;

           // Reading a file 
            Scanner in = new Scanner(new java.io.File(file));
            
            //Capturing only the first line
            String firstLine = in.nextLine();
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
    
     catch (IOException e) 
     {
                System.out.println("File does not exists !");
                System.exit(0);
     }
  }
}
