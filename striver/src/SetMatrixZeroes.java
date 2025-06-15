public class SetMatrixZeroes {

    public void setZeroesNaive(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    markRowAndCol(matrix, i, j);
                }
            }
        }


        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void markRowAndCol(int[][] matrix, int i, int j){
        //Mark row
        for(int k = 0; k < matrix[0].length; k++){
            if(matrix[i][k] != 0){
                matrix[i][k] = -1;
            }
        }

        //Mark Col
        for(int k = 0; k < matrix.length; k++){
            if(matrix[k][j] != 0){
                matrix[k][j] = -1;
            }
        }
    }

    // TC: O(2 * n * m)
    //SC: O(n + m)
    public void setZeroesBetter(int[][] matrix) {
        int[] markRow = new int[matrix.length];
        int[] markCol = new int[matrix[0].length];

        for (int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 0){
                    markRow[row] = 1;
                    markCol[col] = 1;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++) {
                if(markRow[row] == 1 || markCol[col] == 1){
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
