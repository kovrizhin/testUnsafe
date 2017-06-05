import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by oleg on 9/20/16
 */
public class Magic2 {
    public static void makeSomeMagic(Integer integer) {
        try {
        long intClassAddress = normalize(getUnsafe().getInt(new Integer(0), 4L));
            AtomicInteger o = new AtomicInteger(2);
            long strClassAddress = normalize(getUnsafe().getLong(o, 8L));

//        System.out.println(intClassAddress);
//        System.out.println(strClassAddress);


            getUnsafe().putAddress(intClassAddress + 36, strClassAddress);
//            Field field = integer.getClass().getDeclaredField("value");
//            System.out.println(getUnsafe().getInt(integer, 8));

//            getUnsafe().putObject(integer, getUnsafe().objectFieldOffset(field), new AtomicInteger(3));
//            System.out.println(getUnsafe().getInt(integer, 8));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }
    private static long normalize(long value) {
        if(value >= 0) return value;
        return (~0L >>> 64) & value;
    }

}
