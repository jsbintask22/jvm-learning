package cn.jianbin.jvm.reference;

import lombok.SneakyThrows;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

public class SoftReferenceTest {

    /**
     *  20 M = 20 * 1 * 1024 KB = 20 * 1024 * 1024 B
     *
     *    VM options  Xmx20M
     */
    @SneakyThrows
    public static void main(String[] args) throws Exception{
        byte[] bytes = new byte[1 * 10 * 1024 * 1024];
        SoftReference<byte[]> softReference = new SoftReference<byte[]>(bytes);
        bytes = null;

        System.out.println(softReference.get());

        System.gc();

        TimeUnit.SECONDS.sleep(1L);

        System.out.println(softReference.get());

        SoftReference<byte[]> s2 = new SoftReference<byte[]>(new byte[1 * 10 * 1024 * 1024]);

        System.out.println(s2.get());

        System.out.println(softReference.get());
    }
}
