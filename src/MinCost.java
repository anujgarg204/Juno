import java.util.Arrays;

public class MinCost {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                       {8, 6, 4, 3},
                       {6, 5, 3, 69},
                       {2, 3, 6, 5}};

        int[][] arr1 = {{1,2,3},
                       {3,4,2},
                       {5,6,1}};

        int[][] arr3 = {{4,5,6,7,8,2,5,3,4,6},
                        {1,5,9,7,8,2,0,3,14,6},
                        {4,15,6,7,18,2,1,3,4,7},
                        {4,1,6,2,8,2,6,3,4,6},
                        {4,15,6,17,8,2,9,3,4,6},
                        {4,25,6,37,8,2,5,43,4,6},
                        {4,5,6,7,8,32,5,3,34,6},
                        {4,15,6,37,8,2,5,3,4,6},
                        {4,5,6,17,8,2,5,3,14,6},
                        {4,5,6,7,8,21,51,3,4,6}};                    

// 4 -> 1 -> 4 -> 4 -> 1 -> 6 -> 2 -> 8 -> 3
        // System.out.println(minCost(0, 0, 2, 2, arr1));
        System.out.println(dp(arr3));
        // System.out.println(minCost(0, 0, 9, 9, arr3));
    }

// assuming going form 0,0 to arr.length-1, arr[0].length -1
    public static int dp(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int[][] ans = new int[n][m];

        // fill the des
        ans[n-1][m-1] = arr[n -1][m -1];

        // fill last row (i = n-1)
        for(int j=m-2; j>=0; j--){
            int i= n-1;
            ans[i][j] = ans[i][j+1] + arr[i][j];
        }

        // fill last col
        for(int i=n-2; i>=0; i--){
            int j = m-1;
            ans[i][j] = ans[i+1][j] + arr[i][j];
        }

        // final step -> fill the rest of dp
        for(int i=n-2; i >= 0; i--){
            for(int j=m-2; j>=0; j--){
                ans[i][j] = Math.min(ans[i+1][j], ans[i][j+1])+arr[i][j];
            }
        }

        for(int[] ar: ans){
            System.out.println(Arrays.toString(ar));
            System.out.println();
        }

        return ans[0][0];
    }


    // 1 -> 3 -> 5 -> 6 -> 1

    // src -> i, j
    // des -> x, y
    // maze -> arr
    public static int minCost(int i, int j, int x, int y, int[][] arr){
        if(i == x && j == y){
            return arr[i][j];
        }

        //  if(ans[i][j] != 0){return ans[i][j]}

        int cost1 = Integer.MAX_VALUE, cost2 = Integer.MAX_VALUE;
        // only make valid calls

        if(i < arr.length-1){
            cost1 = minCost(i+1, j, x, y, arr);
        }

        if(j < arr[0].length -1){
            cost2 = minCost(i, j+1, x, y, arr);
        }

        // ans[i][j] = Math.min(cost1, cost2) + arr[i][j];

        return Math.min(cost1,cost2) + arr[i][j];
    }
}
