package test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by oleg on 5/31/17
 */
public class UnsafeGetter {

    public static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }
}
