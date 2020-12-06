package org.therdes.leetcode.concurrency.thediningphilosophers;

import java.util.HashMap;
import java.util.Map;

public class OutputVerifier {

    private final Map<String, String> opDesc = new HashMap<String, String>() {{
        put("1", "拿起");
        put("2", "放下");
        put("3", "吃面");
    }};

    private String[] splitSteps(String output) {
        String toProcess = output.substring(1, output.length() - 1);
        String[] steps = toProcess.split("],\\[");
        steps[0] = steps[0].substring(1);
        steps[steps.length - 1] = steps[steps.length - 1].substring(0, steps[steps.length - 1].length() - 1);

        return steps;
    }

    public void verify(String output) {
        String[] steps = splitSteps(output);

        Map<String, Integer> eatCount = new HashMap<>();
        for (String step : steps) {
            String[] operations = step.split(",");
            String philosopher = operations[0];
            String operation = operations[2];
            Integer count = eatCount.getOrDefault(philosopher, 0);
            if ("3".equals(operation)) {
                eatCount.put(philosopher, count + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : eatCount.entrySet()) {
            System.out.printf("philosopher %s eat %d times%n", entry.getKey(), entry.getValue());
        }
    }

    public void showDetailOperations(String output) {
        String[] steps = splitSteps(output);
        for (String step : steps) {
            String[] operations = step.split(",");
            String philosopher = operations[0];
            String operation = operations[2];
            String handSide = operations[1];
            String desc = String.format("哲学家 %s 号 ", philosopher) +
                opDesc.getOrDefault(operation, "") +
                ("0".equals(handSide) ? "" : String.format(" %s 的叉子", "1".equals(handSide) ? "左边" : "右边"));
            System.out.println(desc);
        }
    }

    public static void main(String[] args) {
        OutputVerifier verifier = new OutputVerifier();

        String myOutput = "[[0,1,1],[0,2,1],[3,1,1],[3,2,1],[3,0,3],[3,1,2],[3,2,2],[2,1,1],[2,2,1],[0,0,3],[0,1,2],[0,2,2],[4,1,1],[4,2,1],[2,0,3],[2,1,2],[2,2,2],[1,1,1],[1,2,1],[2,1,1],[2,1,2],[4,0,3],[4,1,2],[4,2,2],[3,1,1],[3,2,1],[1,0,3],[1,1,2],[1,2,2],[1,1,1],[0,1,1],[1,1,2],[0,2,1],[0,0,3],[0,1,2],[0,2,2],[3,0,3],[3,1,2],[3,2,2],[4,1,1],[4,2,1],[0,1,1],[0,1,2],[4,0,3],[4,1,2],[4,2,2],[3,1,1],[3,2,1],[3,0,3],[3,1,2],[3,2,2],[2,1,1],[2,2,1],[2,0,3],[2,1,2],[2,2,2],[1,1,1],[1,2,1],[4,1,1],[4,2,1],[1,0,3],[1,1,2],[1,2,2],[4,0,3],[4,1,2],[4,2,2],[0,1,1],[0,2,1],[2,1,1],[2,2,1],[0,0,3],[0,1,2],[0,2,2],[2,0,3],[2,1,2],[2,2,2],[1,1,1],[1,2,1],[1,0,3],[1,1,2],[1,2,2]]";
        verifier.verify(myOutput);

//        String excepted = "[[0,1,1],[0,2,1],[2,2,1],[2,1,1],[2,0,3],[2,1,2],[2,2,2],[3,2,1],[3,1,1],[2,2,1],[0,0,3],[0,1,2],[0,2,2],[1,2,1],[3,0,3],[3,1,2],[3,2,2],[4,2,1],[2,1,1],[4,1,1],[2,0,3],[2,1,2],[2,2,2],[4,0,3],[4,1,2],[4,2,2],[4,2,1],[4,1,1],[4,0,3],[4,1,2],[4,2,2],[4,2,1],[4,1,1],[3,2,1],[1,1,1],[1,0,3],[1,1,2],[1,2,2],[0,1,1],[4,0,3],[4,1,2],[4,2,2],[0,2,1],[3,1,1],[0,0,3],[0,1,2],[0,2,2],[0,1,1],[0,2,1],[0,0,3],[0,1,2],[0,2,2],[1,2,1],[1,1,1],[1,0,3],[1,1,2],[2,2,1],[1,2,2],[3,0,3],[3,1,2],[3,2,2],[2,1,1],[1,2,1],[2,0,3],[2,1,2],[2,2,2],[1,1,1],[1,0,3],[1,1,2],[1,2,2],[3,2,1],[3,1,1],[3,0,3],[3,1,2],[3,2,2]]";
//        verifier.verify(excepted);

        String error = "[[0,1,1],[0,2,1],[2,1,1],[2,2,1],[3,1,1],[3,1,2],[3,1,1],[3,1,2],[3,1,1],[3,1,2],[3,1,1],[3,1,2],[3,1,1],[3,1,2]]";
//        verifier.showDetailOperations(myOutput);
    }
}
