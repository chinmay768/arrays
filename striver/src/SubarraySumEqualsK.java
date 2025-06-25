import java.util.*;

public class SubarraySumEqualsK {

    public int subarraySumNaive(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }

    public static int subarraySumOptimal(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1); // This is to handle the case where sum - k = 0
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];

            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }

            // This line should be at the bottom
            // To handle case k = 0
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subarraySumOptimal(arr, 0 ));

    }
}
