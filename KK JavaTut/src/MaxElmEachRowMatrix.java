public class MaxElmEachRowMatrix {

    public static void printMaxEachRow(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            int currRowMax = Integer.MIN_VALUE;
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] > currRowMax)
                    currRowMax = arr[i][j];
            }

            System.out.println(currRowMax);
        }
    }

    public static void main(String[] args) {
        int A[][] = { { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 },
                { 4, 4, 4, 4 } };


        printMaxEachRow(A);
    }
}
