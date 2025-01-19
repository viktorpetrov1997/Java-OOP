package TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import softuni.Exercises.TirePressureMonitoringSystem.Alarm;
import softuni.Exercises.TirePressureMonitoringSystem.Sensor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class AlarmTests
{
    private Sensor mockSensor;
    private Alarm alarm;

    @Before
    public void setUp()
    {
        mockSensor = Mockito.mock(Sensor.class);
        alarm = new Alarm(mockSensor);
    }

    // ------------------------------------------------------------------------------------------
    // Check method tests when alarm is on
    // ------------------------------------------------------------------------------------------

    @Test
    public void alarmShouldBeOnWhenPressureIsBelowLowThreshold()
    {
        when(mockSensor.popNextPressurePsiValue()).thenReturn(16.0);

        alarm.check();

        assertTrue("Alarm should be on when pressure is below the low threshold.", alarm.getAlarmOn());
    }

    @Test
    public void alarmShouldBeOnWhenPressureIsAboveHighThreshold()
    {
        when(mockSensor.popNextPressurePsiValue()).thenReturn(22.0);

        alarm.check();

        assertTrue("Alarm should be on when pressure is above the high threshold.", alarm.getAlarmOn());
    }

    // ------------------------------------------------------------------------------------------
    // Check method tests when alarm is off
    // ------------------------------------------------------------------------------------------

    @Test
    public void alarmShouldBeOffWhenPressureIsAboveLowThreshold()
    {
        when(mockSensor.popNextPressurePsiValue()).thenReturn(18.0);

        alarm.check();

        assertFalse("Alarm should be off when pressure is above the low threshold.", alarm.getAlarmOn());
    }

    @Test
    public void alarmShouldBeOffWhenPressureIsBelowHighThreshold()
    {
        when(mockSensor.popNextPressurePsiValue()).thenReturn(20.0);

        alarm.check();

        assertFalse("Alarm should be off when pressure is below the high threshold.", alarm.getAlarmOn());
    }

    @Test
    public void alarmShouldBeOffWhenPressureEqualsTheLowThreshold()
    {
        when(mockSensor.popNextPressurePsiValue()).thenReturn(17.0);

        alarm.check();

        assertFalse("Alarm should be off when pressure equals the low threshold.", alarm.getAlarmOn());
    }

    @Test
    public void alarmShouldBeOffWhenPressureEqualsTheHighThreshold()
    {
        when(mockSensor.popNextPressurePsiValue()).thenReturn(21.0);

        alarm.check();

        assertFalse("Alarm should be off when pressure equals the high threshold.", alarm.getAlarmOn());
    }
}
