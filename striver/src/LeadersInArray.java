import java.util.*;
public class LeadersInArray {

    public static int[] findLeaders(int[] arr){
        int maxRight = Integer.MIN_VALUE;
        List<Integer> leaders = new ArrayList<>();
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] > maxRight){
                leaders.add(arr[i]);
                maxRight = arr[i];
            }
        }

        int[] leadersArr = leaders.stream().mapToInt(i->i).toArray();

        return leadersArr;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};

        int[] leaders = findLeaders(arr);
        System.out.println(Arrays.toString(leaders));
    }
}
