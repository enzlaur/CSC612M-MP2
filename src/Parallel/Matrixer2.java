package Parallel;

import static Utility.Print.*;

public class Matrixer2
{
    String stringA;
    String stringB;
    MatrixStorage ms;

    public Matrixer2(String stringA, String stringB) {
        this.stringA = stringA;
        this.stringB = stringB;
    }



    public void runMatrixer2()
    {
        MatrixStorage matrixStorage = new MatrixStorage(stringA, stringB);
        Cell2 c1 = new Cell2(matrixStorage, 1,0, matrixStorage.getStringALen(),matrixStorage.getStringBLen());
        Cell2 c2 = new Cell2(matrixStorage, 0, 2, matrixStorage.getStringALen(), matrixStorage.getStringBLen());
        c1.start(); /* upright triangle*/
        c2.start(); /* downward triangle*/
        this.ms = matrixStorage;
//        printMatrix( matrixStorage.getMatrix() );
    }

    public MatrixStorage getMs() {
        return ms;
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
