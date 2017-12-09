package Parallel;

import static Utility.Print.printMatrix;

/**
 * Will be updated by all threads
 */
public class MatrixStorage
{
    private int[][] matrix;
    private String stringA, stringB;
    private int stringALen, stringBLen;

    public MatrixStorage(String stringA, String stringB)
    {
        this.matrix = new int[ stringA.length() + 1 ][ stringB.length() + 1 ];
        this.stringA = stringA;
        this.stringB = stringB;
    }

    public void updateMatrixTableCellValue(int x, int y, int value)
    {
        this.matrix[x][y] = value;
        printMatrix( matrix );
    }

    public int getMatrixTableCellValue(int x, int y)
    {
        return this.matrix[x][y];
    }

    public char getLetterAtA(int index)
    {
        return stringA.charAt(index - 1);
    }

    public char getLetterAtB(int index)
    {
        return stringB.charAt(index - 1);
    }

    public int getStringALen()
    {
        this.stringALen = stringA.length();
        return this.stringALen;
    }

    public int getStringBLen()
    {
        this.stringBLen = stringB.length();
        return this.stringBLen;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
