import java.util.*;

public class FindDuplicates {

    public static ArrayList<Integer> findDuplicates(int[] arr){
        Set<Integer> set = new HashSet<>();

        ArrayList<Integer> duplicates = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            if(set.contains(arr[i])){
                duplicates.add(arr[i]);
            }else{
                set.add(arr[i]);
            }
        }

        return duplicates;
    }


    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 19, 22, 2, 4, 19, 3};

//        Naive
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    System.out.println(arr[j]);
                }
            }
        }

//
        System.out.println(findDuplicates(arr));
    }
}
