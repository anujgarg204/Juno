import java.util.Arrays;

public class nQueens {
    public static void main(String[] args) {
       int queens = 4;
        nQueens(queens);
    }

    public static void nQueens(int q){
        char[][] chess = new char[q][q];
        populateChess(chess);

        helper(q, chess, 0);
    }

    private static void populateChess(char[][] chess) {
        for(int i=0; i<chess.length; i++){
            for(int j=0; j<chess[0].length; j++){
                chess[i][j] = ' ';
            }
        }
    }

    public static void helper(int q, char[][] chess, int row){
        if(q == 0){
            print(chess);
            return;
        }

        if(row >= chess.length){
            return;
        }

        // try to place a queen in the given row
        for(int j=0; j<chess[0].length; j++){
            if(canPlaceQueen(row, j, chess)){
                // place the queens
                placeQueen(chess, row, j);
                // give chance to next queens
                helper(q-1, chess, row+1);
                // on the way back unplace queen to check for next positions
                unplaceQueen(chess, row, j);
            }
        }
    }

    private static void unplaceQueen(char[][] chess, int row, int j) {
        chess[row][j] = ' '; 
    }

    private static void placeQueen(char[][] chess, int row, int j) {
        chess[row][j] = 'q';
    }

    private static boolean canPlaceQueen(int row, int col, char[][] chess) {
        // found queen on upper side
        for(int i = row; i>=0; i--){
            if(chess[i][col] == 'q')return false;
        }

        // found queen on left side
        for(int j = col; j>= 0; j--){
            if(chess[row][j] == 'q')return false;
        }

        // upper right diagonal
        int r1 = row; int c1 = col;
        while(r1>=0 && c1 < chess[0].length){
            
            if(chess[r1][c1] == 'q')return false;

            r1--; 
            c1++;
        }

        // upper left diagonal
        int r2 = row; int c2 = col;
        while(r2 >=0 && c2 >=0){
            
            if(chess[r2][c2] == 'q')return false;

            r2--;
            c2--;
        }

        // no queen found in the way. Safe to place.
        return true;
    }

    private static void print(char[][] chess) {
        for(char[] row: chess){
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
