import java.util.Arrays;

public class FindMissingNumber {

    // Naive Way (Sorting)
    public static void findMissingSorting(int[] arr, int size){
        Arrays.sort(arr);

        // Extreme cases
        if (arr[0] != 1) {
            System.out.println(1);
            return;
        }
        if (arr[size - 1] != (size + 1)) {
            System.out.println(size + 1);
            return;
        }
        int start = 0;
        int end = arr.length - 1;

        while(end - start > 1){
            int mid = (start + end) / 2;

            if(arr[start] - start != arr[mid] - mid){
                end = mid;
            }else if(arr[end] - end != arr[mid] - mid){
                start = mid;
            }
        }

        System.out.println(arr[start] + 1);
    }

    // Optimal Approach
    public static void findMissingWithSum(int[] arr){
        int n = arr.length + 1;
        int totalSum = n * (n + 1) / 2;

        int sum = 0;
        for(int num : arr){
            sum += num;
        }

        int missingNum = totalSum - sum;
        System.out.println(missingNum);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        int n = arr.length;

//        findMissingSorting(arr, n);
        findMissingWithSum(arr);
    }
}
