import org.example.Push;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PushTest {

    @Test
    void testCalculateEarningsPositive() {
        Push push = new Push("Pushup", 2);
        assertEquals(10, push.calculateEarnings(5)); // 5 * 2 = 10
    }

    @Test
    void testCalculateEarningsZero() {
        Push push = new Push("Pushup", 2);
        assertEquals(0, push.calculateEarnings(0));
    }
}
