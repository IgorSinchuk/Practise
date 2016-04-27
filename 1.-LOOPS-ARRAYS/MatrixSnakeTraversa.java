/**
 * Created by Столик on 27.04.2016.
 */
public class MatrixSnakeTraversa {
    public int[] print(int[][] input) {
        int matrixElementsQuantity = 0;
        for (int i = 0; i < input.length; i++) {
            matrixElementsQuantity += input[i].length;
        }
        int result[] = new int[matrixElementsQuantity];
        int directionSwitcher = 1;
        int row = 0;
        int arrayIndex = 0;

        for (int column = 0; column < input[0].length; column++) {
            while (row >= 0 && row < input.length) {
                result[arrayIndex++] = input[row][column];
                row += directionSwitcher;
            }
            directionSwitcher = -directionSwitcher;
            row += directionSwitcher;
        }
        return result;
    }
}