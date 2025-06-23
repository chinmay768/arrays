import java.util.Arrays;

public class MergeSortedArraysWithoutExtraSpace {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1;
        int ptr2 = 0;

        while (ptr1 >= 0 && ptr2 <= n - 1){
            if(nums1[ptr1] > nums2[ptr2]){
                swap(nums1, nums2, ptr1, ptr2);
                ptr2++;
                ptr1--;
            }

            if(nums1[ptr1] <= nums2[ptr2]) break;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }

    private static void swap(int[] arr1, int[] arr2, int i, int j){
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int m = 3;

        int[] arr2 = {2,5,6};
        int n = 3;

        merge(arr1, m, arr2, n);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
