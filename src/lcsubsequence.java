public class lcsubsequence {
    public static void main(String[] args) {
        String s1 = "asdhflahsklfghs";
        String s2 = "asofhaoiasehfo";

    }

    public static int lcs(String s1, String s2){
        if(s1.length() == 0 || s2.length() == 0){
            return 0;
        }

        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);

        if(c1 == c2){
            return lcs(s1.substring(1), s2.substring(1)) + 1;
        }else{
            int s1m1 = lcs(s1.substring(1), s2);
            int s2m1 = lcs(s1, s2.substring(1));
            return Math.max(s1m1, s2m1);
        }
    }

}
