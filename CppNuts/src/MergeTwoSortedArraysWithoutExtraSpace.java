import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {


    public static void merge(int[] arr1, int[] arr2){
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length){
            if(arr1[i] > arr2[j]){
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;

                int k = j;
                int elm = arr2[k];
                while(k < arr2.length -1 && elm > arr2[k + 1]){
                    arr2[k] = arr2[k + 1];
                    k++;
                }
                arr2[k] = temp;
            }
            i++;
        }
    }

    static void mergeWithSorting(int[] arr1, int[] arr2)
    {
        int m = arr1.length;
        int n = arr2.length;
        int i = 0, j = 0, k = m - 1;
        while (i <= k && j < n) {
            if (arr1[i] < arr2[j])
                i++;
            else {
                int temp = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = temp;
                j++;
                k--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 7, 9};
        int[] arr2 = {2, 3, 6, 9};

        merge(arr1, arr2);
//        mergeWithSorting(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
