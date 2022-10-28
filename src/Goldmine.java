import java.util.Arrays;

public class Goldmine {
    public static void main(String[] args) {
        int[][] arr = {{4,5,6,7,8,2,5,3,4,6},
                        {1,5,9,7,8,2,0,3,14,6},
                        {4,15,6,7,18,2,1,3,4,7},
                        {4,1,6,2,8,2,6,3,4,6},
                        {4,15,6,17,8,2,9,3,4,6},
                        {4,25,6,37,8,2,5,43,4,6},
                        {4,5,6,7,8,32,5,3,34,6},
                        {4,15,6,37,8,2,5,3,4,6},
                        {4,5,6,17,8,2,5,3,14,6},
                        {4,5,6,7,8,21,51,3,4,6}}; 
        
                        System.out.println(goldmine(arr));
    }
    public static int goldmine(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;

        int[][] dp = new int[m][n];

        // fill last column
        for(int i=0; i<m; i++){
            dp[i][n-1] = arr[i][n-1];
        }

        for(int j=n-2; j>=0; j--){
            
            for(int i=0; i<m; i++){
                int maxGoldInNextCol = Integer.MIN_VALUE;

                if(i > 0){
                    maxGoldInNextCol = Math.max(maxGoldInNextCol, dp[i-1][j+1]);
                }

                    maxGoldInNextCol = Math.max(maxGoldInNextCol, dp[i][j+1]);

                if(i < m -1){
                    maxGoldInNextCol = Math.max(maxGoldInNextCol, dp[i+1][j+1]);
                }

                dp[i][j] = maxGoldInNextCol + arr[i][j];
            }
        }

        for(int[] row: dp){
            System.out.println(Arrays.toString(row));
            System.out.println();
        }


        int ans = Integer.MIN_VALUE;
        for(int i=0; i< m; i++){
            ans = Math.max(ans, dp[i][0]);
        }
        return ans;
    }
}
