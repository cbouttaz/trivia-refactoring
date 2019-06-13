package formation.mocks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Stub: Sensor: shouldActivateAlarmWhenPressureIsTooLow
 * Mock: BlackBox: shouldNotifyBlackBoxWhenAlarmIsOn
 */
public class AlarmTest {
    private boolean isCalled = false;
    private Sensor koSensor;

    @Test
    public void shouldRaiseAlarmWhenOverThreshold() {
        koSensor = new Sensor() {
            @Override
            public double popNextPressurePsiValue() {
                return 30;
            }
        };
        Alarm alarm = new Alarm(koSensor, new BlackBox());

        alarm.check();

        assertEquals(alarm.isAlarmOn(), true);
    }

    @Test
    public void shouldCallBlackBoxWhenOverThreshold() {
        koSensor = new Sensor() {
            @Override
            public double popNextPressurePsiValue() {
                return 15;
            }
        };
        Alarm alarm = new Alarm(koSensor, new BlackBox(){
            @Override
            public void trace(String pressureProblem) {
                isCalled = true;
                super.trace(pressureProblem);
            }
        });

        alarm.check();

        assertEquals(isCalled, false);
    }

}