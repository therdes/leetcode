package org.therdes.leetcode.concurrency.buildingh2o;

public class H2OMain {

    public static void main(String[] args) {
        H2O h2O = new H2O();
        int n = 50;
        new Thread(() -> {
            for (int i = 0; i < 2 * n; i++) {
                try {
                    h2O.hydrogen(() -> System.out.print("H"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < n; i++) {
                try {
                    h2O.oxygen(() -> System.out.print("O"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
