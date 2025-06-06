import java.util.*;

public class IntersectionOfTwoArrays {

    public static Integer[] intersection(int[] arr1, int[] arr2){
        List<Integer> list = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;

        int i = 0, j = 0;

        while (i < m && j < n){
            while (i + 1  < m && arr1[i] == arr1[i + 1]) i++;
            while (j + 1  < n && arr2[j] == arr2[j + 1]) j++;

            if(arr1[i] < arr2[j]){
                i++;
            }else if(arr2[j] < arr1[i]){
                j++;
            }else{
                list.add(arr1[i]);
                i++;
                j++;
            }
        }

        return list.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 2, 3, 4, 7};

        Integer[] intersecton = intersection(arr1, arr2);

        System.out.println(Arrays.toString(intersecton));
    }
}
