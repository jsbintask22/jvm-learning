package cn.jianbin.jvm.reference;

import lombok.SneakyThrows;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class WeakReferenceTest {

    @SneakyThrows
    public static void main(String[] args) {
        WeakReference<Object> w1 = new WeakReference<>(new Object());
        System.out.println(w1.get());

        System.gc();

        System.out.println(w1.get());

        ThreadLocal<Object> t1 = new ThreadLocal<>();
        t1.set(new We());

        System.gc();
        TimeUnit.SECONDS.sleep(1L);
        System.out.println(t1.get());

        t1.remove();
    }

    public static class We {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("We.finalize");
        }
    }
}
