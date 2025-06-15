public class RotateImageOrRotateMatrix {

    public void rotate(int[][] matrix){
        int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                rotatedMatrix[j][matrix.length - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = rotatedMatrix[i][j];
            }
        }
    }

    public void rotateOptimal(int[][] matrix) {
        // Transpose O(n/2 * n/2)
        for(int i = 0; i < matrix.length - 1; i++){
            for (int j = i + 1; j < matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // O(n * n/2)
        for (int i = 0; i < matrix.length; i++){
            reverseArray(matrix[i]);
        }
    }

    public static void reverseArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

    }
}
