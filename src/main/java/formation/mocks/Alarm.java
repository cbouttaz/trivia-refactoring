package formation.mocks;

public class Alarm
{
    private final double LowPressureThreshold = 10;
    private final double HighPressureThreshold = 20;

    boolean alarmOn = false;
    private final Sensor sensor;
    private final BlackBox blackBox;

    public Alarm() {
        sensor = new Sensor();
        blackBox = new BlackBox();
    }

    public Alarm(Sensor sensor, BlackBox blackBox) {
        this.sensor = sensor;
        this.blackBox = blackBox;
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
            blackBox.trace("value over threshold" + psiPressureValue);
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }

}