public class FindMinMax {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 6, 10, 9};

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }else if(min > arr[i]){
                min = arr[i];
            }
        }

        System.out.println(min + " " + max);
    }
}
