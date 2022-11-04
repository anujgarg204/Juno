import java.util.ArrayList;
import java.util.List;

public class coinChangePermutation {
    public static void main(String[] args) {
        int[] coins = {2,3,5,7};
        int target = 10;
        List<String> list = new ArrayList<>();
        // recursive(coins, target, list, "");
        recursiveComb(coins, target, list, "", 0);

        for(String s: list){
            System.out.println(s);
        }
    }

    public static void recursive(int[] coins, int target, List<String> list, String currPerm){

        if(target < 0)return;

        if(target == 0){
            list.add(currPerm);
        }

        for(int i=0; i<coins.length; i++){
            recursive(coins, target - coins[i], list, currPerm + coins[i]+", ");
        }
    }

    public static void recursiveComb(int[] coins, int target, List<String> list, String currPerm, int idx){

        if(target < 0)return;

        if(target == 0){
            list.add(currPerm);
        }

        for(int i=idx; i<coins.length; i++){
            recursiveComb(coins, target - coins[i], list, currPerm + coins[i]+", ", i);
        }
    }
}
