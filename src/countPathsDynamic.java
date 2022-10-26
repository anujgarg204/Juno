import java.util.Arrays;

public class countPathsDynamic {
    public static void main(String[] args) {
        // int[] arr = {2,3,4,2,4,1,0,2,8,9,3,5};
        // int[] arr = {3,0,2,3,5};
        // System.out.println(cp(0, arr.length-1, arr));
        int[] arr = {2,3,5,0,9,6,3,1,2,3,5,1};
        dp(arr);
    }

    // Assuming src = 0;
    // des = arr.length -1
    public static int dp(int[] arr){
        int[] ans = new int[arr.length];

        ans[ans.length-1] = 1;

        for(int i= ans.length - 2; i >= 0; i--){
            // main calculation
            int pathsForIthPosn = 0;

            for(int j = 1 ; j<=arr[i]; j++){
                int newIndex = i+j;
                if(newIndex < arr.length){
                    pathsForIthPosn += ans[newIndex];
                }
            }
            
            ans[i] = pathsForIthPosn;
        }

        System.out.println(Arrays.toString(ans));

        return ans[0];
    }

    public static int cp(int src,int des, int[] arr){
        if(src == des)return 1;
        if(src >= des || arr[src] == 0)return 0;

        int tPaths = 0;

        for(int i = 1; i <= arr[src]; i++){
            int recursive = cp(src+i, des, arr);
            tPaths += recursive;
        }
        return tPaths;
    }
}
