import java.io.IOException;

/*
 @author Luana Menezes e Atila Souza
 */
public class Main extends Matrix {
    public static void main(String[] args) throws IOException 
    {        
        Matrix matrix = new Matrix();
        File file = new File();
     //   String f = matrix.setFile("c:/matrix.txt"); // For Windows: put the txt file in the C directory
        String desktop = System.getProperty ("user.home") + "/Desktop/"; // For Mac OS: put the txt file in the Desktop directory
        String f = file.setFile(desktop + "matrix.txt"); // For Mac OS
        File.readFile(f);
        matrix.mutiply();
        if(Matrix.allow)
        {
            System.out.println("\nMatrix A\n");
            System.out.print(matrix.toString(Matrix.matrix1));
            System.out.println("\nMatrix B\n");
            System.out.print(matrix.toString(Matrix.matrix2));
            System.out.println("\nMatrix C = A * B\n");
            System.out.print(matrix.toString(Matrix.result));
        }
    }
}