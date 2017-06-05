import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by oleg on 9/20/16
 */
public class MagicTest2 {

    @Test
    public void test(){
        Integer integer = new Integer(2);
        System.out.println(integer);
        Magic2.makeSomeMagic(integer);
        Integer a = integer + integer;
        AtomicInteger atomicInteger = (AtomicInteger) (Object) integer;
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.get() + atomicInteger.get());


    }


}
