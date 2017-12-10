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

    public void manualLoop(MatrixStorage ms)
    {

    }

    public void runMatrixer2B()
    {
        MatrixStorage ms = new MatrixStorage(stringA, stringB);
        Cell2 c1, c2;
        int i = 1, j = 1;

        while( i <= ms.getStringALen() )
        {
            println(ms.getFinishedThreads());
            while( ms.getFinishedThreads() < 2)
            {
                println("ft: " + ms.getFinishedThreads());

            }
            ms.resetFinishedThreads();
//            println("FS: " + ms.getFinishedThreads());
            c1 = new Cell2("1", ms, i, ms.getStringALen(), 'r');
            c2 = new Cell2("2", ms, i, ms.getStringBLen(), 'd');
            i++;

            c1.start();
            c2.start();




            println("FT NOW: " + ms.getFinishedThreads());
        }
        println("finishedThreads: " + ms.getFinishedThreads());
        println("m2b finished");
        printMatrix(ms.getMatrix());
    }

    public void runMatrixer2()
    {
        MatrixStorage matrixStorage = new MatrixStorage(stringA, stringB);
        Cell2 c1 = new Cell2(matrixStorage, 1,0, matrixStorage.getStringALen(),matrixStorage.getStringBLen());
        Cell2 c2 = new Cell2(matrixStorage, 0, 2, matrixStorage.getStringALen(), matrixStorage.getStringBLen());
        c2.start(); /* upright triangle*/
        c1.start(); /* downward triangle*/
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

            matrixer2.runMatrixer2B();
        }
    }
}
