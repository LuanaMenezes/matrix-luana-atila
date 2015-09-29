/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Luana Menezes
 */
public class Matrix {

    private void readFromFile()
    {
        
        try
        {
            File f = new File("C:/Users/Luana Menezes/Documents/NetBeansProjects/Matrix/src/matrix.txt");
            Scanner input = new Scanner(f);
            int[][] m = new int[5][5];
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++){
                m[i][j] = input.nextInt();
            
            }
            }
            System.out.println(m);           
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println(fnfe.getMessage());
        }
    }
    
    public static void main(String[] args)
    {
        Matrix matrixIO = new Matrix();
        
        matrixIO.readFromFile();
    }
    
}
