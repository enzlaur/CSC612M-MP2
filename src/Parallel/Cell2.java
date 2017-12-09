package Parallel;

import static Utility.Print.*;

public class Cell2 extends Thread
{
    MatrixStorage ms;
    /* Variables for traversing */
    int start, end;
    int startX = 1, startY = 1;
    int endX, endY;
    int offset = 1;
    /* Constant variables */
    private final int matchScore = 3;
    private final int mismatchScore = -3;
    private final int gapPenalty = -2;

    public Cell2(MatrixStorage matrixStorage, int start, int end)
    {
        this.ms = matrixStorage;
        this.start = start;
        this.end = end;
    }

    public Cell2(MatrixStorage ms, int startX, int startY, int endX, int endY)
    {
        this.ms = ms;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public Cell2(MatrixStorage ms)
    {
        this.ms = ms;
    }

    public int computeCellScore(int x, int y)
    {
        int score = 0;
        int maxPossibleScore = 0;
        int pDiag = 0;
        int pUp = 0;
        int pLeft = 0;

        /* if both letters match, add 3 to the score + diag value */
        if ( ms.getLetterAtA(x) == ms.getLetterAtB(y))
        {
            score = ms.getMatrixTableCellValue(x - 1,y - 1) + matchScore;
        }
        else
        {
            pDiag   = ms.getMatrixTableCellValue(x - 1,y - 1 ) + mismatchScore;
            pLeft   = ms.getMatrixTableCellValue(x, y -1 ) + gapPenalty;
            pUp     = ms.getMatrixTableCellValue(x - 1, y ) + gapPenalty;

            if( pDiag > maxPossibleScore ) {
                maxPossibleScore = pDiag;
            }
            if( pUp > maxPossibleScore ) {
                maxPossibleScore = pUp;
            }
            if( pLeft > maxPossibleScore ) {
                maxPossibleScore = pLeft;
            }

            score = maxPossibleScore;
        }

        return score;
    }

    public void run()
    {
        long startTime = System.currentTimeMillis();
        int tempVal;
        try {
            if (startY == 0)
            {
                for (int offset = 1; offset <= endY; offset++) {
                    for (int i = startX; i <= endX; i++) {
                        tempVal = computeCellScore(i, offset);
                        ms.updateMatrixTableCellValue(i, offset, tempVal);
                    }
                    startX++;
                }
            }
            if( startX == 0)
            {
                for( int offset = 1; offset <= endX; offset++)
                {
                    for( int i = startY; i <= endY; i++ )
                    {
                        tempVal = computeCellScore(offset, i);
                        ms.updateMatrixTableCellValue( offset, i, tempVal);
                    }
                }
            }

        }
        catch ( Exception e)
        {
            e.printStackTrace();
        }
        ms.incrementFinishedThreads();

        if( ms.getFinishedThreads() == 2 )
        {
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Time: " + totalTime);
            println("Finished all " + ms.getFinishedThreads() + " thread(s) ");
//            printMatrix( ms.getMatrix() );
        }
    }
}

    /*
    public void run()
    {
        try
        {
            for( offset = 1; offset <= ms.getStringBLen(); offset++ )
            {
                for( int i = start; i <= ms.getStringALen(); i++ )
                {
                    ms.updateMatrixTableCellValue(i, offset, end);

                }
                start++;
            }
            println("");
            printMatrix( ms.getMatrix() );

        }
        catch ( Exception e)
        {
            e.printStackTrace();
        }
    }
}
*/
