
/**
 @author Luana Menezes e Atila Souza
 */
public class Matrix{
    
    public static double[][] matrix1;
    public static double[][] matrix2;
    public static double[][] result;
    public static boolean allow = true;
   
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

  }
   
