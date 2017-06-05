package test;

import size.T;
import sun.misc.Unsafe;

import static test.O.toHex;

/**
 * Created by oleg on 5/31/17
 */
public class UnsafeInterest {
    public final static UnsafeInterest object = new UnsafeInterest();

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Unsafe unsafe = UnsafeGetter.getUnsafe();
//        long aLong = unsafe.getByte(object, 0l);
//        long aLong = unsafe.getByte(object, 1l);
//        int i1 = System.identityHashCode(object);
//        System.out.println(i1);
        Thread thread = new Thread(() -> {synchronized (object) {System.out.println("test");}});
        thread.start();
        long objStatic = unsafe.staticFieldOffset(UnsafeInterest.class.getField("object"));
        Object fieldStatic = unsafe.staticFieldBase(UnsafeInterest.class.getField("object"));
//        long objAdd = unsafe.objectFieldOffset(UnsafeInterest.class.getField("object"));
//        System.out.println(objStatic);
//        System.out.println(unsafe.getByte(fieldStatic, 0));
//        System.out.println(objAdd);
        System.out.println((unsafe.getByte(UnsafeInterest.object, 0l)));
        System.out.println((unsafe.getByte(UnsafeInterest.object, 1l)));
        System.out.println((unsafe.getByte(UnsafeInterest.object, 2l)));
        System.out.println((unsafe.getByte(UnsafeInterest.object, 3l)));
        System.out.println((unsafe.getByte(UnsafeInterest.object, 4l)));
        System.out.println((unsafe.getByte(UnsafeInterest.object, 5l)));
        System.out.println((unsafe.getByte(UnsafeInterest.object, 6l)));
        System.out.println((unsafe.getByte(UnsafeInterest.object, 7l)));
        System.out.println((unsafe.getInt(UnsafeInterest.object, 1l)));
        System.out.println(thread.hashCode());
        System.out.println(System.identityHashCode(thread));
//        System.out.println((unsafe.getByte(UnsafeInterest.object, 5l)));
//        System.out.println(unsafe.getByte(aLong));
        A a = new A();
        A b = new A();
//        unsafe.getLong(a, 0l);
        for (int  i= 0; i < 100; i++) {
            System.out.println("" + i + "byte=" + unsafe.getByte(a, i) + "\thex=" + toHex(unsafe.getByte(a, i)));
        }

        long aLong = unsafe.getLong(a, 20);
        long anInt = unsafe.getInt(a, 20);
        System.out.println(aLong);
        System.out.println(Long.toHexString(aLong));
        System.out.println(anInt);
        System.out.println(anInt << 3);
        System.out.println(Long.toHexString(anInt));
        System.out.println(Long.toBinaryString(anInt));
        System.out.println(Long.toHexString(anInt <<3));
        System.out.println(Long.toBinaryString(anInt <<3));
        long x = uintToLong(unsafe.getInt(a, 20));
        System.out.println(x);
        System.out.println(x<<3);
        System.out.println(Long.toHexString(x));
        System.out.println(Long.toHexString(x<<3));
        System.out.println(Long.toHexString(x<<3));
        System.out.println(Long.toBinaryString(x));
        System.out.println(Long.toBinaryString(x<<3));
        long l = x << 3;
        System.out.println(unsafe.getByte(l));
        for (int i = 0; i < 20; i++) {
            System.out.println("" + i + "byte=" + unsafe.getByte(l +i) + "\thex=" + toHex(unsafe.getByte(l+ i)));

        }



    }



        public static long uintToLong(int value) {
            if (value < 0) {
                return value & 0xFFFFFFFFL;
            }
            return value;
        }


}
