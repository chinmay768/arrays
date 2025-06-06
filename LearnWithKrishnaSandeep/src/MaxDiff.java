public class MaxDiff {

    public static void main(String[] args) {
        int[] arr = {7, 9, 5, 6, 19, 2, 12};

//        int max = 0;
//        for(int i = 0; i < arr.length; i++){
//            for(int j = i + 1; j < arr.length; j++){
//                if(arr[j] > arr[i]){
//                    max = Math.max(arr[j] - arr[i], max);
//                }
//            }
//        }


        // Better Approach
        int maxDiff = 0;
        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - min > maxDiff){
                maxDiff = arr[i] - min;
            }

            if(arr[i] < min){
                min = arr[i];
            }
        }

        System.out.println(maxDiff);
    }
}
