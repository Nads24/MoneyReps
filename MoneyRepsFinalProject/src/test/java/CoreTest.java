import org.example.Core;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoreTest {

    @Test
    void testCalculateEarnings() {
        Core core = new Core("Plank", 1);
        assertEquals(10, core.calculateEarnings(10));
        assertEquals(0, core.calculateEarnings(0));
        assertEquals(-10, core.calculateEarnings(-10));
    }
}
