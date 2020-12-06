package org.therdes.leetcode.concurrency.fizzbuzzmultithreaded;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzzUseSemaphore {

    private final Semaphore fizz = new Semaphore(0);
    private final Semaphore buzz = new Semaphore(0);
    private final Semaphore fizzbuzz = new Semaphore(0);
    private final Semaphore number = new Semaphore(1);

    private final int n;

    public FizzBuzzUseSemaphore(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 && i % 5 != 0) {
                fizz.acquire();
                printFizz.run();
                number.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; ++i) {
            if (i % 3 != 0 && i % 5 == 0) {
                buzz.acquire();
                printBuzz.run();
                number.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzz.acquire();
                printFizzBuzz.run();
                number.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; ++i) {
            number.acquire();
            if (i % 3 == 0 && i % 5 != 0) {
                fizz.release();
            } else if (i % 3 != 0 && i % 5 == 0) {
                buzz.release();
            } else if (i % 3 == 0) {
                fizzbuzz.release();
            } else {
                printNumber.accept(i);
                number.release();
            }
        }
    }
}
