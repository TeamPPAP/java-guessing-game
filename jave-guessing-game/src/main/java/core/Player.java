package core;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static int seq = 0;
    private final int id = ++seq;

    List<Integer> triesHistory  = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void recordAttempt(int tries) {
        triesHistory.add(tries);
    }

    public int latestTries() {
        return triesHistory.get(triesHistory.size()-1);
    }

    public static void resetSequence() {
        seq = 0;
    }
}
