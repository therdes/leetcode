package org.therdes.leetcode.concurrency.fizzbuzzmultithreaded;

import java.util.function.IntConsumer;

public class FizzBuzzUseLockWaitNotifyAll {

    private int current = 1;

    private final int n;

    public FizzBuzzUseLockWaitNotifyAll(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {
            while (current <= n) {
                if (!(current % 3 == 0 && current % 5 != 0)) wait();
                if (!(current % 3 == 0 && current % 5 != 0)) continue;
                if (current > n) break;
                printFizz.run();
                ++current;
                notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (current <= n) {
                if (!(current % 3 != 0 && current % 5 == 0)) wait();
                if (!(current % 3 != 0 && current % 5 == 0)) continue;
                if (current > n) break;
                printBuzz.run();
                ++current;
                notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (current <= n) {
                if (!(current % 3 == 0 && current % 5 == 0)) wait();
                if (!(current % 3 == 0 && current % 5 == 0)) continue;
                if (current > n) break;
                printFizzBuzz.run();
                ++current;
                notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (current <= n) {
                if (!(current % 3 != 0 && current % 5 != 0)) wait();
                if (!(current % 3 != 0 && current % 5 != 0)) continue;
                if (current > n) break;
                printNumber.accept(current);
                ++current;
                notifyAll();
            }
        }
    }
}
