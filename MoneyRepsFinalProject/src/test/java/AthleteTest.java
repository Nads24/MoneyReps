package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AthleteTest {

    @Test
    void testLogExercise_singleLogUpdatesEarningsAndHistory() {
        Athlete athlete = new Athlete("Yi", 101);
        Exercise pushExercise = new Push("Push", 2);
        athlete.logExercise(pushExercise, 10); // 10 reps x 2 = 20
        athlete.assignExercises(List.of(pushExercise));
        assertEquals(20, athlete.getTotalEarnings());
        assertEquals(1, athlete.getAssignedExercises().size());
    }

    @Test
    void testLogExercise_multipleLogsAccumulateCorrectly() {
        Athlete athlete = new Athlete("Aminul", 101);
        Exercise pushExercise = new Push("Push", 2);  // 5 reps = 10 pts
        Exercise pullExercise = new Pull("Pull", 3);  // 4 reps = 12 pts
        athlete.logExercise(pushExercise, 5);
        athlete.logExercise(pullExercise, 4);
        assertEquals(22, athlete.getTotalEarnings());
    }

    @Test
    void testAssignExercises_addsToAssignedList() {
        Athlete athlete = new Athlete("Nadeem", 101);
        Exercise pushExercise = new Push("Push", 2);
        Exercise pullExercise = new Pull("Pull", 3);
        athlete.assignExercises(List.of(pushExercise, pullExercise));
        assertEquals(2, athlete.getAssignedExercises().size());
    }

    @Test
    void testAssignExercises_accumulatesOnMultipleCalls() {
        Athlete athlete = new Athlete("Wang", 101);
        Exercise pushExercise = new Push("Push", 2);
        Exercise pullExercise = new Pull("Pull", 3);
        athlete.assignExercises(List.of(pushExercise));
        athlete.assignExercises(List.of(pullExercise));
        assertEquals(2, athlete.getAssignedExercises().size());
    }

    @Test
    void testGetTotalEarnings_initialIsZero() {
        Athlete athlete = new Athlete("Billy", 101);
        assertEquals(0, athlete.getTotalEarnings());
    }
}
