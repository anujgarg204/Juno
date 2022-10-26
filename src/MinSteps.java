public class MinSteps {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 0, 2, 8, 9, 1, 3, 5, 11, 2, 7, 0, 2, 5};
    
        System.out.println(minJumps(0, 16, arr));
    }

    public static Integer minJumps(int src, int des, int[] arr){
        if(src == des)return 0;

        if(src > des || arr[src] == 0)return null;

        Integer minSoFar = Integer.MAX_VALUE;

        for(int i=1; i<= arr[src]; i++){
            Integer aageKeMoves = minJumps(src+i, des, arr);
            if(aageKeMoves != null){
                minSoFar = Math.min(minSoFar, aageKeMoves);
            }
        }
        return minSoFar == Integer.MAX_VALUE ? null : minSoFar + 1;
    }

}

