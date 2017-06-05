package size;

import sun.misc.Unsafe;

public class V6 {
    private int a = 2;
    private int b = 3;

    public static void main(String[] argv) throws Exception {
        Unsafe u = T.get();
        V6 v = new V6();
        synchronized (v) {
            long obj = T.o2a(v);
            for (int i = 0; i < 32; i++)
                System.out.print(T.hex(u.getByte(obj + i)) + " ");
        }
    }
}