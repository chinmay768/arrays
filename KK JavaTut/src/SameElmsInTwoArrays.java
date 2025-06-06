import java.util.ArrayList;

public class SameElmsInTwoArrays {

    public static ArrayList<Integer> findCommon(int[] arr1, int[] arr2){
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2.length; j++){
                if(arr1[i] == arr2[j]){
                    list.add(arr1[i]);
                    break;
                }
            }
        }

        return list;
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};

        int[] arr2 = {2, 5, 9, 10, 1};

        System.out.println(findCommon(arr1, arr2));
    }
}
