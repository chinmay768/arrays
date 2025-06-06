import java.util.*;

public class PairWithGivenSum {

    public static void findPairsNaive(int[] arr, int target){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == target){
                    System.out.println(arr[i] + ", " + arr[j]);
                }
            }
        }
    }

    public static void findPairsMap(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(target - arr[i])){
                System.out.println(target - arr[i] + " " + arr[i]);
            }else {
                map.put(arr[i], map.getOrDefault(arr[i], 0)  + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 9, 7, 6, 0};

        findPairsMap(arr, 7);
    }
}
