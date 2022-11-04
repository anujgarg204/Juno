public class KnapSack {
    public static void main(String[] args) {
        // int[] wt = {5,2,3,7,6,4,2,3,8,5,3};
        // int[] val = {10,20,55,43,49,21,89,100,90,10,12};

        // System.out.println(maxValue(wt, val, 15, 0, 0));

        int W = 100;
        int val[] = { 10, 30, 20 };
        int wt[] = { 5, 10, 15 };
        System.out.println(ksUnbounded(W, 0, wt, val, 0));
    }

    public static int ksUnbounded(int capacity, int idx, int[] wt, int[] val, int currVal){
        // when at the end of the array
        if(idx == wt.length){
            return currVal;
        }

        int excluded = ksUnbounded(capacity, idx+1, wt, val, currVal);
        int included = Integer.MIN_VALUE;

        if(wt[idx] <= capacity){
            // even after getting picked once, same val can get another chance
            included = ksUnbounded(capacity-wt[idx], idx, wt, val, currVal+val[idx]);
        }

        return Math.max(excluded, included);
    }

    public static int maxValue(int[] wt, int[] val, int capacity,int currVal, int idx){
        // when at the end of the array
        if(idx == wt.length){
            return currVal;
        }

        int excluded = maxValue(wt, val, capacity, currVal, idx+1);
        int included = Integer.MIN_VALUE;

        if(wt[idx] <= capacity){
            included = maxValue(wt, val, capacity-wt[idx], currVal+val[idx], idx+1);
        }  

        return Math.max(included, excluded);
    }


}
