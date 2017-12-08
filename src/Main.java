import Utility.IOMaster;
import standard.MagicalTraceback;
import standard.StandardMatrixFiller;

import java.util.Arrays;

import static Utility.Print.printMatrix;

public class Main {



    public static void main(String[] args)
    {
        StandardMatrixFiller standardMatrixFiller = new StandardMatrixFiller();
        MagicalTraceback magicalTraceback;
        IOMaster ioMaster = new IOMaster();
        String[] sequences = new String[2];
        String stringA, stringB;
        int[][] matrix;

        /* Read sequences from file */
        try
        {
            sequences = ioMaster.readFileToStringArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* Copy to stringA and stringB */
        stringA = sequences[0];
        stringB = sequences[1];
        /* Populate matrix */
        matrix = standardMatrixFiller.fillMatrix(stringA, stringB);
        /* Perform traceback */
        magicalTraceback = new MagicalTraceback(matrix, standardMatrixFiller.getHighX(), standardMatrixFiller.getHighY());
        /* Print matrix table */
        printMatrix(matrix);
        /* Find the best local alignment */
        magicalTraceback.generateAlignments(stringA, stringB);
    }


}
