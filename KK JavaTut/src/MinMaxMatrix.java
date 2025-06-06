public class MinMaxMatrix {

    public static void findMinMaxElementsInMatrix(int[][] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] > max){
                    max = arr[i][j];
                }else if(arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }

        System.out.println(max + " " + min);
    }

    public static void main(String[] args) {
        int A[][] = { { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 },
                { 4, 4, 4, 4 } };


        findMinMaxElementsInMatrix(A);
    }
}
