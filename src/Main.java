import standard.MagicalTraceback;
import standard.StandardMatrixFiller;

import java.util.Arrays;

public class Main {



    public static void main(String[] args)
    {
        String stringA = "GGACTA";
        String stringB = "GCTA";

        MagicalTraceback magicalTraceback;
        int[][] matrix;
        StandardMatrixFiller standardMatrixFiller = new StandardMatrixFiller();
        matrix = standardMatrixFiller.fillMatrix(stringA, stringB);

        magicalTraceback = new MagicalTraceback(matrix, standardMatrixFiller.getHighX(), standardMatrixFiller.getHighY());

        Main.printMatrix(matrix);

        magicalTraceback.generateAlignments(stringA, stringB);
    }

    public static void printMatrix(int [][] matrix) {
        System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
    }
}
