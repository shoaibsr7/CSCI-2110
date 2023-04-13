import java.util.Scanner;
public class MatrixMult {
    public static void main(String[] args) {

        //time measurement variables
        long startTime, endTime, executionTime;


        //creating a scanner to read in the first two square matrices
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();
        int value = in.nextInt();

//        Since they are square matrix the number of rows and columns will be the same
        double[][] a = new double[size][size];
        double[][] b = new double[size][size];


        //reading matrix 1 and matrix 2
        for (int i = 0; i <size ; i++)
            for (int j = 0; j <size ; j++)
                a[i][j]=value;

        //System.out.println("----------------------------");


        for (int i = 0; i <size ; i++)
            for (int j = 0; j <size ; j++)
                b[i][j]=value;

/*
        //printing matrix 1 and matrix 2
        System.out.println("Matrix A");
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Matrix B");
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(b[i][j] + "\t");
            }
            System.out.println();
        }
*/


        //declaring a matrix to store the result of the multiplication of matrix 1 and matrix 2
        double[][] resultmatrix = new double[size][size];

        //calling the method to multiply the two matrices and measuring the elapsed time
        startTime = System.currentTimeMillis();

        resultmatrix = multiplyMatrix(a,b);

        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;


/*
        //printing the resultant matrix
        System.out.println("Matrix Result");
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(resultmatrix[i][j] + "\t");
            }
            System.out.println();
        }
*/

        System.out.println("Size:"+size+" Time:"+executionTime+" ms");


    }

    /**
     * multiplies the 2 matrices
     * @param a matrix a
     * @param b matrix b
     * @return resultant matrix c
     */
    public static double[][] multiplyMatrix(double[][] a, double[][] b){

        double[][] resultMatrix = new double[a.length][a.length];

       //YOUR WORK STARTS HERE
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                resultMatrix[i][j] = 0;     //initializing first element of row and column to 0
                for (int k = 0; k < a.length; k++) {
                    resultMatrix[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return resultMatrix;
    }
}
