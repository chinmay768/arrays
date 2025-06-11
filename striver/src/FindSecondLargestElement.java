import java.util.Arrays;

public class FindSecondLargestElement {

    public static int findSecondLargestBrute(int[] nums){
        Arrays.sort(nums);

        int i = nums.length;
        while (i >= 0){
            if(nums[i - 1] != nums[i]){
                return nums[i - 1];
            }
        }

        return -1;
    }

    public static int findSecondLargest(int[] nums){
        int largest = nums[0];
        int secondLargest = Integer.MIN_VALUE;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > largest){
                secondLargest = largest;
                largest = nums[i];
            }else if(nums[i] > secondLargest){
                secondLargest = nums[i];
            }
        }

        return secondLargest;
    }

    public static void main(String[] args) {

    }
}
