package org.therdes.leetcode.concurrency.thediningphilosophers;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    private final int[] sleepTimeouts = new int[]{5, 13, 23, 37, 47, 59};

    private final Semaphore[] forks = new Semaphore[]
        {new Semaphore(1), new Semaphore(1), new Semaphore(1),
            new Semaphore(1), new Semaphore(1)};

    private final ReentrantLock waitLock = new ReentrantLock();

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        final int leftForkIndex = philosopher;
        final int rightForkIndex = philosopher == 0 ? 4 : leftForkIndex - 1;

        Semaphore leftFork = forks[leftForkIndex];
        Semaphore rightFork = forks[rightForkIndex];

        int rightForkAcquireFailureAmount = 0;
        while (true) {
            while (!leftFork.tryAcquire()) {
                synchronized (forks[leftForkIndex]) {
                    forks[leftForkIndex].wait();
                }
            }
            pickLeftFork.run();

            if (rightFork.tryAcquire()) {
                pickRightFork.run();
                break;
            } else {
                leftFork.release();
                putLeftFork.run();
                synchronized (forks[leftForkIndex]) {
                    forks[leftForkIndex].notifyAll();
                }
                Thread.sleep(sleepTimeouts[rightForkAcquireFailureAmount % sleepTimeouts.length]);
                ++rightForkAcquireFailureAmount;
            }
        }

        eat.run();

        putLeftFork.run();
        putRightFork.run();
        leftFork.release();
        rightFork.release();
        synchronized (forks[leftForkIndex]) {
            forks[leftForkIndex].notifyAll();
        }
        synchronized (forks[rightForkIndex]) {
            forks[rightForkIndex].notifyAll();
        }
    }
}
