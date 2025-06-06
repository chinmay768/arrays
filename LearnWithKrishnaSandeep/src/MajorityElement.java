public class MajorityElement {

    public static int majority(int[] arr){
        int majority = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == majority) {
                count++;
            }else {
                count--;
            }

            if(count == 0){
                majority = arr[i];
                count = 1;
            }
        }

        return majority;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 3, 2, 1, 2, 2};

        System.out.println(majority(arr));
    }
}
