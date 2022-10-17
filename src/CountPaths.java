import java.util.HashMap;
import java.util.Map;

public class CountPaths {
    public static void main(String[] args) {
        
        map = new HashMap<>();
        // System.out.println(cPathsMem(0,50));
        // System.out.println(cPaths1(0,50));
        System.out.println(cPathDp(0, 50));
    }

    public static int cPathDp(int src, int des){

        int[] arr = new int[des+1];
       
        arr[des-1] = 1;
        arr[des-2] = 2;
        arr[des-3] = 4;

        for(int i = des-4; i>=0; i--){
            arr[i] = arr[i+1]+arr[i+2]+arr[i+3];
        }
        return arr[0];
    }

    static Map<String, Integer> map = new HashMap<>();

    public static int cPathsMem(int src, int des){
        if(src > des){
            return 0;
        }

        if(src == des){
            return 1;
        }

        String key = ""+src+"_"+des;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int p1 = cPathsMem(src+1, des);
        int p2 = cPathsMem(src+2, des);
        int p3 = cPathsMem(src+3, des);

        int answer = p1+p2+p3;
        map.put(key, answer);
        return answer;
    }

    public static int cPaths1(int src, int des){
        if(src > des){
            return 0;
        }

        if(src == des){
            return 1;
        }

        int p1 = cPaths1(src+1, des);
        int p2 = cPaths1(src+2, des);
        int p3 = cPaths1(src+3, des);

        int answer = p1+p2+p3;
        return answer;
    }
}
