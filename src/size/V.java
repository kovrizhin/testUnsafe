package size;
import sun.misc.Unsafe;
import sun.text.normalizer.Utility;

public class V {
    private Integer b = 3;
    private int a = 4;


    public static void main(String[] argv) throws Exception {
        Unsafe u = T.get();
        V o = new V();

        long obj = T.o2a(o);
        long addr = u.getLong(o, 4L);
        obj = normalize(obj);
        for (int i = 0; i < 40; i++) {
//            System.out.println(o);
            System.out.print(u.getByte(obj + i) + " ");
        }
        System.out.println(T.getInstance().getObj());


    }

    private static long normalize(long value) {
        if(value >= 0) return value;
        return (~0L >>> 64) & value;
    }

}