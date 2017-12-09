import Parallel.Matrixer;
import Utility.IOMaster;
import standard.MagicalTraceback;
import standard.StandardMatrixFiller;

import java.util.Arrays;

import static Utility.Print.printMatrix;

public class Main {


    public static int[][] runSingle(String stringA, String stringB)
    {
        StandardMatrixFiller standardMatrixFiller = new StandardMatrixFiller();
        /*
         * Single version
         * */
        /* Populate matrix */
        long startTime = System.currentTimeMillis(); /* time thingy */
        int[][] matrix = standardMatrixFiller.fillMatrix(stringA, stringB);
        /* timer thingy */
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time: " + totalTime);
//        printMatrix(matrix);
        try {
            printToFile(matrix);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matrix;
    }

    public static void runParallel(String stringA, String stringB)
    {
        long startTime = System.currentTimeMillis();
        /* parallel version */
        Matrixer matrixer = new Matrixer();
        matrixer.runMe(stringA, stringB);
        int[][] matrix = matrixer.getResultMatrix();
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time: " + totalTime);
        /*try {
            printToFile(matrix);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public static void printToFile(int[][] matrix) throws Exception
    {
        IOMaster ioMaster = new IOMaster();
        try {
            ioMaster.writeStringToFile(matrix);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {

        MagicalTraceback magicalTraceback;
        IOMaster ioMaster = new IOMaster();
        String[] sequences = new String[2];
        String stringA, stringB;
        int[][] matrix;

        /* Read sequences from file */
        try
        {
            sequences = ioMaster.readFileToStringArray();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        /* Copy to stringA and stringB */
        stringA = sequences[0];
        stringB = sequences[1];
        /*
        * CHOOSE ONE ONLY
        * */
//        runSingle(stringA, stringB);
        runParallel(stringA, stringB);

        /*
        * Perform Traceback below
        * */
//        magicalTraceback = new MagicalTraceback(matrix, standardMatrixFiller.getHighX(), standardMatrixFiller.getHighY());
        /* Print matrix table */
//        printMatrix(matrix);
        /* Find the best local alignment */
//        magicalTraceback.generateAlignments(stringA, stringB);
    }


}
