import java.util.*;
public class SpiralTraversalOfMatrix {

    // TC: O(n * m)
    // SC: O(n * m)
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;

        List<Integer> list = new ArrayList<>();

        while (top <= bottom && left <= right){
            // Right
            for(int i = left; i <= right; i++){
                list.add(matrix[top][i]);
            }
            top++;

            // Bottom
            for (int i = top; i <= bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;

            //Left
            if(top <= bottom){ // Single Row check
                for (int i = right; i >= left; i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //Top
           if(left <= right){ // 2 * 2 matrix check
               for (int i = bottom; i >= top; i--){
                   list.add(matrix[i][left]);
               }
               left++;
           }
        }

        return list;
    }

    public static void main(String[] args) {

    }
}
