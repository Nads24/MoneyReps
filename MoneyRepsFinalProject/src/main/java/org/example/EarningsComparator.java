package org.example;

import java.util.Comparator;

public class EarningsComparator implements Comparator<Athlete> {
    @Override
    public int compare(Athlete a1, Athlete a2) {
        return Integer.compare(a2.getTotalEarnings(), a1.getTotalEarnings());

    }
}
