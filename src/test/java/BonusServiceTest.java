import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 10_000_600;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredNoBonus() {
        BonusService service = new BonusService();

        long amount = 3333;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredMinBonus() {
        BonusService service = new BonusService();

        long amount = 3334;
        boolean registered = true;
        long expected = 1;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_600;
        boolean registered = false;
        long expected = 100;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 60_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredNoBonus() {
        BonusService service = new BonusService();

        long amount = 9999;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredMinBonus() {
        BonusService service = new BonusService();

        long amount = 10000;
        boolean registered = false;
        long expected = 1;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}
