import java.util.HashMap;
import java.util.Map;

public class targetSumSubset {
    public static void main(String[] args) {
        // int[] arr = {2,4, 6, 18, 9, 10, 3, 5};
        // int target = 20;
        // System.out.println(ts(arr, 0, 0, target));

        map = new HashMap<>();


        int[] arr = {3,5,6,2,1,3,10,8,6,2,10,10,10,10,10,10,44,2,10,8,6,2,44,2,2,1,3,10,5,6,2,1,3,10,8,6,2,44,2,10,8,6,2,44,2,2,1,3,10,3,5,6,2,1,3,10,8,6,2,44,2,10,8,6,2,44,2,2,1,3,10,5,6,2,1,3,10,8,6,2,44,2,10,8,6,2,44,2,2,1,3,10,3,5,6,2,1,3,10,8,6,2,44,2,10,8,6,2,44,2,2,1,3,10,5,6,2,1,3,10,8,6,2,44,2,10,8,6,2,44,2,2,1,3,10,3,5,6,2,1,3,10,8,6,2,44,2,10,8,6,2,44,2,2,1,3,10,5,6,2,1,3,10,8,6,2,44,2,10,8,6,2,44,2,2,1,3,10};
        int target = 104127;

        // System.out.println(ts(arr,0,0,target));
        // System.out.println(ts2(arr, 0, target));
            System.out.println(dp(arr, target));
    }

    public static boolean ts(int[] arr, int idx, int currSum, int target){
        if(idx == arr.length){
            return currSum == target;
        }

        boolean included = ts(arr, idx+1, currSum+arr[idx], target);
        boolean excluded = ts(arr, idx+1, currSum, target);

        return included || excluded;
    }

    // memorization
    // hashmap -> target_idx -> true/false
    public static Map<String, Boolean> map;
    public static boolean ts2(int[] arr, int idx, int target){
        if(idx == arr.length){
            return target == 0;
        }

        String key = "" + target + "_" + idx; //10_0, 5_3 (meaning from 3rd index, can I accomplish the target 5 either by including 3rd or excluding 3rd)
        if(map.containsKey(key))return map.get(key);

        boolean included = ts2(arr, idx+1, target - arr[idx]);
        boolean excluded = ts2(arr, idx+1, target);

        map.put(key, included || excluded);

        return included || excluded;
    }

    public static boolean dp(int[] arr, int target){
        boolean[][] dp = new boolean[arr.length+1][target+1];

        // fill true for target 0
        for(int i=0; i<dp.length; i++){
            dp[i][0] = true;
        }

        for(int i =1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                int val = arr[i-1];
                
                boolean excluded = dp[i-1][j];
                boolean included = false;

                if(j - val >= 0){
                    included = dp[i-1][j-val];
                }

                dp[i][j] = included || excluded;
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}
