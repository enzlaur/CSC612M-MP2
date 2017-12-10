import Parallel.Matrixer;
import Parallel.Matrixer2;
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
            printToFile("single.txt", matrix);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matrix;
    }

    public static void runParallel3(String stringA, String stringB)
    {
        Matrixer2 m2 = new Matrixer2(stringA, stringB);
        m2.runMatrixer2B();

    }

    public static void runParallel2(String stringA, String stringB)
    {
        Matrixer2 m2 = new Matrixer2(stringA, stringB);
        m2.runMatrixer2();
        try
        {
            printToFile("parallel2.txt", m2.getMs().getMatrix());
        }
        catch ( Exception e)
        {
            e.printStackTrace();
        }

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



    public static void printToFile(String fileName, int[][] matrix) throws Exception
    {
        IOMaster ioMaster = new IOMaster(fileName);
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
//        runSingle(stringA, stringB);
//        runSingle(stringA, stringB);
        runSingle(stringA, stringB);
//        runParallel2(stringA, stringB);
//        runParallel2(stringA, stringB);
//        runParallel2(stringA, stringB);
//        runParallel2(stringA, stringB);
//        runParallel3(stringA, stringB);

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
