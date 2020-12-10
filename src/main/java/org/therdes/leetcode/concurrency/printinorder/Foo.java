package org.therdes.leetcode.concurrency.printinorder;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 使用原子操作排除竞态条件
 *
 * @see <a href="https://leetcode-cn.com/problems/print-in-order/">1114. 按序打印</a>
 */
public class Foo {

    private final AtomicBoolean firstDone = new AtomicBoolean(false);

    private final AtomicBoolean secondDone = new AtomicBoolean(false);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        firstDone.set(true);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!firstDone.get()) ;
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondDone.set(true);
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!secondDone.get()) ;
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
