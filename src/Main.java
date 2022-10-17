import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // System.out.println(fib(5));


        int n = 6;
        int[] arr = new int[n+1];
        System.out.println(fibMemorized(n, arr));
    }

    public static int fib(int n){
        if(n ==1 || n ==0 )return n;

        int fibm1 = fib(n-1);
        int fibm2 = fib(n-2);

        int answer = fibm1 + fibm2;

        return answer;
    }

    public static int fibMemorized(int n, int[] arr){
        if(n ==1 || n ==0 )return n;

        if(arr[n] != 0)return arr[n];

        int fibm1 = fibMemorized(n-1, arr);
        int fibm2 = fibMemorized(n-2, arr);

        int answer = fibm1 + fibm2;
        arr[n] = answer;
        
        return answer;  
    }
}

