import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        long intClassAddress = normalize(getUnsafe().getLong(new Integer(0), 4L));
        long strClassAddress = normalize(getUnsafe().getLong("", 4L));
        getUnsafe().putAddress(intClassAddress + 36, strClassAddress);

        String s1 = (String) (Object) (new Integer(0));
        String s = s1;
        System.out.println(s + s);
    }

    private static long normalize(int value) {
        if(value >= 0) return value;
        return (~0L >>> 32) & value;
    }

    private static long normalize(long value) {
        if(value >= 0) return value;
        return (~0L >>> 64) & value;
    }


    private static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }

}
