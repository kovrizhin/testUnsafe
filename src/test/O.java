package test;

/**
 * Created by oleg on 6/1/17
 */
public class O {
    public static String toHex(byte b){
        String s = Integer.toHexString(b);
        if(s.length() > 2){
            s = s.substring(6);
        }
        return s;
    }
}
