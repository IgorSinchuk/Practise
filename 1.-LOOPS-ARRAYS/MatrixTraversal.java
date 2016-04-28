/**
 * Created by Столик on 28.04.2016.
 */
public class MatrixTraversal {
    public int[] print(int[][] input) {
    int colLength = input.length;
    int rowLength = getMaxRowLength(input);
    int[] output = new int[getLengthOfMatrix(input)];
    int counter = 0;

    for (int i = 0; i < colLength/2+1; i++) {

        for (int right = i; right < rowLength; right++) {
            try {
                output[counter] = input[i][right];
                counter++;
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        System.out.println();

        for (int down = i + 1; down < colLength; down++) {
            try {
                output[counter] = input[down][(rowLength - 1)];
                counter++;
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

        for (int left = rowLength - 1 - 1; left >= i; left--) {
            try {
                output[counter] = input[(colLength - 1)][left];
                counter++;
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

        for (int top = colLength - 1 - 1; top >= i + 1; top--) {
            try {
                output[counter] = input[top][i];
                counter++;
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

        colLength--;
        rowLength--;
    }

    return output;
}

    private int getLengthOfMatrix(int[][] matrix) {
        int length = 0;
        for (int[] col : matrix) {
            length += col.length;
        }
        return length;
    }

    private int getMaxRowLength(int[][] matrix) {
        int max = 0;
        for (int[] col : matrix) {
            if (col.length > max) max = col.length;
        }
        return max;
    }
}

