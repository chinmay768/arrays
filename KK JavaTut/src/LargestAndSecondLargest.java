public class LargestAndSecondLargest {



    public static void main(String[] args) {
        int[] arr = {4, 1, 9, 19, 2, 10};

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }else if(arr[i] > secondMax){
                secondMax = arr[i];
            }
        }

        System.out.println(max + " " + secondMax);
    }
}
