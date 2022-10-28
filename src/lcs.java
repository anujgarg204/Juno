public class lcs {
    public static void main(String[] args) {
        // String s1 = "wbcdehgj";
        // String s2 = "xbcdgbcdehkl";
        answer = 0;

        // bdebcd bcdnma

        String s1 = "bdebcd";
        String s2 = "bcdnma";
        
        lcsRec(s1,s2, 0);
        System.out.println(answer);

    }
    static int answer = 0;

    public static void lcsRec(String s1, String s2, int lcsSoFar){
        answer = Math.max(lcsSoFar, answer);

        if(s1.length() == 0 || s2.length() == 0)return;

        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);

        if(c1 == c2){
            lcsRec(s1.substring(1), s2.substring(1), lcsSoFar +1);
        }

        lcsRec(s1.substring(1), s2, 0);
        lcsRec(s1, s2.substring(1), 0);
    }
}
