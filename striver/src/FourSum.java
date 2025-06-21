import java.util.*;
import java.util.stream.Collectors;

public class FourSum {

    // Brute Force is to use 4 loops

    //TC:
    public static List<List<Integer>> fourSumBetter(int[] nums, int target){
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++) {
                Set<Integer> hashset = new HashSet<>();
                for(int k = j + 1; k < nums.length; k++) {
                    long currSum = nums[i];
                    currSum += nums[j];
                    currSum += nums[k];

                    long fourth = target - currSum;
                    if(hashset.contains((int)fourth)) { // Casting is necessary
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    hashset.add(nums[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
             if (i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < nums.length; j++){
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = nums.length - 1;

                while (k < l){
                    long currSum = nums[i];
                    currSum += nums[j];
                    currSum += nums[k];
                    currSum += nums[l];
                    if(currSum == target){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        Collections.sort(list);
                        set.add(list);

                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }else if(currSum < target) k++;
                    else l--;

                }
            }
        }

        return new ArrayList<>(set);
//        List<List<Integer>> result = set.stream().collect(Collectors.toList());
//        return result;
    }

    public static void main(String[] args) {
        int[] arr  ={2,2,2,2,2};
        System.out.println(fourSumBetter(arr, 8));
    }
}
