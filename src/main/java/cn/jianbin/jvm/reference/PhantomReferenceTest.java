package cn.jianbin.jvm.reference;

import lombok.SneakyThrows;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {

    @SneakyThrows
    public static void main(String[] args) {
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> p1 = new PhantomReference<>(new Object(),
                queue);

        System.out.println(p1.get());
    }
}
