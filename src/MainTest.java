import org.testng.annotations.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;



/**
 * Created by oleg on 9/20/16
 */
public class MainTest {
    @Test
    public void testUnsafe() throws NoSuchFieldException, IllegalAccessException {
//        System.out.println(sizeOfCalc(new Integer(0)));
//        System.out.println(sizeOf(""));

        long intClassAddress = normalize(getUnsafe().getInt(new Integer(0), 4L));
        long strClassAddress = normalize(getUnsafe().getInt("2", 4L));

//        System.out.println(intClassAddress);
//        System.out.println(strClassAddress);

        getUnsafe().putAddress(intClassAddress + 36, strClassAddress);
//        System.out.println(new Integer(42));
        Integer integer = new Integer(2);
//        System.out.println(sizeOf(integer));
        System.out.println(integer);
        String integer1 = (String) (Object) integer;
        System.out.println(integer);

        Field field = integer1.getClass().getDeclaredField("value");
        getUnsafe().putObject(integer1, getUnsafe().objectFieldOffset(field), new char[]{'3', '3', '3'});
        System.out.println(sizeOf(integer1));
        System.out.println(integer);
        System.out.println(integer1);
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

    public static long sizeOf(Object object) throws NoSuchFieldException, IllegalAccessException {
        return getUnsafe().getAddress(
                normalize(getUnsafe().getInt(object, 4L)) + 12L);
    }

    public static long sizeOfCalc(Object o) throws NoSuchFieldException, IllegalAccessException {
        Unsafe u = getUnsafe();
        HashSet<Field> fields = new HashSet<Field>();
        Class c = o.getClass();
        while (c != Object.class) {
            for (Field f : c.getDeclaredFields()) {
                if ((f.getModifiers() & Modifier.STATIC) == 0) {
                    fields.add(f);
                }
            }
            c = c.getSuperclass();
        }

        // get offset
        long maxSize = 0;
        for (Field f : fields) {
            long offset = u.objectFieldOffset(f);
            if (offset > maxSize) {
                maxSize = offset;
            }
        }

        return ((maxSize/8) + 1) * 8;   // padding
    }




}