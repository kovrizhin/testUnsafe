package size;
import sun.misc.Unsafe;

public class V5 {
    private Integer a = 1;

    public static void main(String[] argv) throws Exception {
        Unsafe u = T.get();

        long obj = T.o2a(new V5());
        for (int i = 0; i < 28; i++)
            System.out.print(u.getByte(obj + i) + " ");
    }
}