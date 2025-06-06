import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static int[] merge(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int[] merged = new int[n + m];

        int i = 0, j = 0, k = 0;
        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
                merged[k++] = arr1[i++];
            }else{
                merged[k++] = arr2[j++];
            }
        }

        while (i < n){
            merged[k++] = arr1[i++];
        }

        while (j < m){
            merged[k++] = arr2[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 9};
        int[] arr2 = {3, 4, 5, 6, 9};

        System.out.println(Arrays.toString(merge(arr1, arr2)));
    }
}
