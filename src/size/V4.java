package size;

import sun.misc.Unsafe;

public class V4 {
    public static void main(String[] argv) throws Exception {
        Unsafe u = T.get();

        long obj = T.o2a(new Integer[] {1, 2, 3});
        for (int i = 0; i < 28; i++)
            System.out.print(u.getByte(obj + i) + " ");
    }
}