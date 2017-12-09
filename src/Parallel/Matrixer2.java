package Parallel;

import static Utility.Print.*;

public class Matrixer2
{
    String stringA;
    String stringB;

    public Matrixer2(String stringA, String stringB) {
        this.stringA = stringA;
        this.stringB = stringB;
    }

    public void runMatrixer2()
    {
        MatrixStorage matrixStorage = new MatrixStorage(stringA, stringB);
        Cell2 c1 = new Cell2(matrixStorage, 1,1);
        Cell2 c2 = new Cell2(matrixStorage, 2, 3);
        c1.start();
        c2.start();

//        printMatrix( matrixStorage.getMatrix() );
    }

    public static class test1
    {
        public static void main(String[] args)
        {
            String stringA = "GGTTGACTA";
            String stringB = "TGTTACGG";
            Matrixer2 matrixer2 = new Matrixer2(stringA, stringB);

            matrixer2.runMatrixer2();
        }
    }
}
