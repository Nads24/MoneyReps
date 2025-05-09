import org.example.Pull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PullTest {

    @Test
    void testCalculateEarningsPositive() {
        Pull pull = new Pull("Pullup", 3);
        assertEquals(15, pull.calculateEarnings(5)); // 5 * 3 = 15
    }

    @Test
    void testCalculateEarningsZero() {
        Pull pull = new Pull("Pullup", 3);
        assertEquals(0, pull.calculateEarnings(0));
    }

}