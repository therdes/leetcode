package org.therdes.leetcode.concurrency.buildingh2o;

import java.util.concurrent.Semaphore;

public class H2O {

    private final Semaphore h = new Semaphore(2);

    private final Semaphore o = new Semaphore(1);

    private final Semaphore s1 = new Semaphore(0);

    private final Semaphore s2 = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        s1.release();
        s2.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        h.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        s2.release(2);
        s1.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        o.release();
    }
}
