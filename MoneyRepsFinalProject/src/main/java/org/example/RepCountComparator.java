package org.example;

import java.util.Comparator;

public class RepCountComparator implements Comparator<WorkoutLog> {

    @Override
    public int compare(WorkoutLog w1, WorkoutLog w2) {
        return Integer.compare(w2.getReps(), w1.getReps());
    }
}
