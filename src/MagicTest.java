import org.testng.annotations.Test;

/**
 * Created by oleg on 9/20/16
 */
public class MagicTest {

    @Test
    public void test(){
        Integer integer = new Integer(2);
        System.out.println(integer);
        Magic.makeSomeMagic(integer);

        String integer1 =(String) (Object) integer;
        System.out.println(integer1);
        System.out.println(integer + integer);
        System.out.println(integer1 + integer);
        System.out.println(integer + integer1);




    }



}
