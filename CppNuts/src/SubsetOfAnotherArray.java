import java.util.*;
public class SubsetOfAnotherArray {

    public static void isSubset(int[] arr1, int[] arr2){
        for(int i = 0; i < arr1.length; i++){
            boolean isPresent = false;

            for(int j = 0; j < arr2.length; j++){
                if(arr2[j] == arr1[i]){
                    isPresent = true;
                    break;
                }
            }

            if(!isPresent){
                System.out.println("Not a subset");
                return;
            }
        }
        System.out.println("Subset");
    }

    public static boolean isSubsetHashing(int[] arr1, int[] arr2){
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr2){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : arr1){
            if(map.containsKey(num)){
                map.put(num, map.get(num) -1);
            }else{
                return false;
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() < 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 5, 9, 1};
        int[] arr2 = {1, 2, 4, 5, 3, 6, 9, 7, 8, 10};

        System.out.println(isSubsetHashing(arr1, arr2));
    }
}
