package formation.mocks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Stub: Sensor: shouldActivateAlarmWhenPressureIsTooLow
 * Mock: BlackBox: shouldNotifyBlackBoxWhenAlarmIsOn
 */
public class AlarmTest {

    @Test
    public void shouldRaiseAlarmWhenOverThreshold() {
        Alarm alarm = new Alarm();

        alarm.check();

        assertEquals(alarm.isAlarmOn(), true);
    }

    @Test
    public void shouldRegisterInBlackBoxWhenOverThreshold() {
        Alarm alarm = new Alarm();

        alarm.check();

        assertEquals(false, true);
    }
}