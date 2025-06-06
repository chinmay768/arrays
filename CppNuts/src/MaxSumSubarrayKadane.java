public class MaxSumSubarrayKadane {



    public static void main(String[] args) {
        int[] arr = {-2, 1, 3, -1, 2, -5, 3};

        int sum = 0;
        int maxSum = 0;

        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];

            maxSum = Math.max(sum, maxSum);

            if(sum < 0){
                sum = 0;
            }
        }

        System.out.println(maxSum);

    }
}
