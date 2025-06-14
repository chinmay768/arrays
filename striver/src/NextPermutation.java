import java.util.Arrays;

public class NextPermutation {

    //Brute approach is using recursion

    // TC: O(n + n + n)
    //SC: O(1)
    public static void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        if(idx == -1){ // Means array is reverse sorted
            reverse(0, n - 1, nums);
            return;
        }

        for (int i = n - 1; i > idx; i--){
            if(nums[i] > nums[idx]){
                swap(i, idx, nums);
                break;
            }
        }

        reverse(idx + 1, n - 1, nums);
    }

    public static void reverse(int startIdx, int endIdx, int[] arr){
        while (startIdx < endIdx){
            swap(startIdx, endIdx, arr);
            startIdx++;
            endIdx--;
        }
    }

    private static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
