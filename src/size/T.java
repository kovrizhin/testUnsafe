package size;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class T {

    public static Unsafe u;
    private static long fieldOffset;
    private static T instance = new T();
    private Object obj;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);

            u = (Unsafe) f.get(null);
            fieldOffset = u.objectFieldOffset(T.class.getDeclaredField("obj"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    ;

    public synchronized static long o2a(Object o) {
        instance.obj = o;
        return u.getLong(instance, fieldOffset);
    }

    public synchronized static Object a2o(long address) {
        u.putLong(instance, fieldOffset, address);
        return instance.obj;
    }

    public static Unsafe get() {
        return u;
    }

    public Object getObj() {
        return obj;
    }

    public static T getInstance() {
        return instance;
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String hex(byte bytee) {
        char[] hexChars = new char[2];

        int v = bytee & 0xFF;
        hexChars[0] = hexArray[v >>> 4];
        hexChars[1] = hexArray[v & 0x0F];

        return new String(hexChars);
    }
}