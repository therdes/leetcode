package org.therdes.leetcode.concurrency.printfoobaralternately;

import java.util.concurrent.Semaphore;

public class FooBar {

    private final Semaphore fooStart = new Semaphore(1);

    private final Semaphore barStart = new Semaphore(0);

    private final int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooStart.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barStart.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barStart.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooStart.release();
        }
    }
}
