import org.example.Push;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PushTest {
    private Push push;

    @Test
    void calculateEarnings_basic() {
        assertEquals(20, push.calculateEarnings(5));
    }

    @Test
    void calculateEarnings_zeroReps() {
        assertEquals(0, push.calculateEarnings(0));
    }

    @Test
    void calculateEarnings_negativeReps() {
        assertEquals(-20, push.calculateEarnings(-5));
    }
}
