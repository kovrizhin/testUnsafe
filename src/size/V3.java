package size;

import size.T;
import sun.misc.Unsafe;

public class V3 {
    private int a = 2;
    private int b = 3;

    public static void main(String[] argv) throws Exception {
        Unsafe u = T.get();

        long obj = T.o2a(new V());
        V3 v = new V3();
        v.a = 5;
        v.b = 6;
        for (int i = 0; i < 32; i++)
            System.out.print(u.getByte(obj + i) + " ");
    }
}
