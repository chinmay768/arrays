public class CheckIfArrayIsSorted {

    //TC: O(2N)
    //SC: O(N)
    public static boolean checkSorted(int[] nums){
        int len = nums.length;
        if(len == 1) return true;

        int count = 1;
        for(int i = 2; i < 2 * len; i++){
            if(nums[(i - 1) % len] <= nums[i % len]){
                count++;
            }else
                count = 1;

            if(count == len) return true;
        }

        return false;
    }


    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};

        System.out.println(checkSorted(arr));
    }
}

