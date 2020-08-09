package cn.jianbin.valitile;

import lombok.SneakyThrows;

public class OrderRearrangeTest {
    @SneakyThrows
    public static void main(String[] args) {
        int count = 0;
        for(;;) {
            V V = new V();
            Thread t1 = new Thread(() -> {
                V.a = 1;
                V.x = V.b;
            }, "t_1");


            Thread t2 = new Thread(() -> {
                V.b = 1;
                V.y = V.a;
            }, "t_2");

            t1.start(); t2.start();
            t1.join();  t2.join();

            count++;
            if (V.x == 0 && V.y == 0) {
                System.err.println("count: " + count);
                System.out.println("x = " + V.x + ", y = " + V.y + "    amazing!");
                break;
            }
        }
    }

    public static class V {
        int a, b;
        int x, y;
    }
}
