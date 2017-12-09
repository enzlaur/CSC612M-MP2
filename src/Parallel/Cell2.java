package Parallel;

import static Utility.Print.*;

public class Cell2 extends Thread
{
    MatrixStorage ms;

    int startX, startY;
    int endX, endY;
    int offset;

    public Cell2(MatrixStorage ms, int startX, int startY) {
        this.ms = ms;
        this.startX = startX;
        this.startY = startY;
    }

    public Cell2(MatrixStorage ms, int startX, int startY, int endX, int endY) {
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

    public void run()
    {

        try
        {

            for(int i = 1; i < ms.getStringALen(); i++)
            {
                ms.updateMatrixTableCellValue(i,startY, 88);
                println("did i even lod");
            }

        }
        catch ( Exception e)
        {
            e.printStackTrace();
        }
    }
}
