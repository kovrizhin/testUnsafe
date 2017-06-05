package size;

import sun.misc.Unsafe;

public class V2 {
    private int a = 2;
    private Integer b = 777;

    public static void main(String[] argv) throws Exception {
        Unsafe u = T.get();

        long obj = T.o2a(new V());
        for (int i = 0; i < 28; i++)
            System.out.print(u.getByte(obj + i) + " ");

        long field = u.getAddress(obj + 3 * 4);
        Object i = T.a2o(field);
        System.out.print("\nInteger: " + i);
    }
}