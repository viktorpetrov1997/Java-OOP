package TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import softuni.Exercises.TirePressureMonitoringSystem.Sensor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SensorTests
{
    // Helper method for getting a specific value when using the randomPressureSampleSimulator variable

    private void setRandomReturnValue(Sensor sensor, double value) throws NoSuchFieldException, IllegalAccessException
    {
        // Access the private randomPressureSampleSimulator field using reflection
        Field field = Sensor.class.getDeclaredField("randomPressureSampleSimulator");
        field.setAccessible(true);

        // Create a mock Random object to control the return value of nextDouble()
        Random mockRandom = new Random()
        {
            @Override
            public double nextDouble()
            {
                return value;  // Return the specified value instead of generating a random one
            }
        };

        // Inject the mock Random into the Sensor instance
        field.set(sensor, mockRandom);
    }

    private Sensor sensor;

    @Before
    public void setUp()
    {
        sensor = new Sensor();
    }

    // ------------------------------------------------------------------------------------------
    // popNextPressurePsiValue Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void popNextPressurePsiValueMethodReturnsValueWithinExpectedRange()
    {
        Sensor sensor = new Sensor();

        double pressureValue = sensor.popNextPressurePsiValue();

        assertTrue("Pressure Psi value should be within the range [16.0 - 22.0]. Actual: " + pressureValue,
                pressureValue >= 16.0 && pressureValue < 22.0);
    }

    @Test
    public void popNextPressurePsiValueMethodReturnsCorrectValue() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException
    {
        // Edge case: Mock the Random object to return 0.5
        // Using reflection to set random value as 0.5
        Sensor sensor = new Sensor();

        // Setting the return value of nextDouble to 0.5
        setRandomReturnValue(sensor, 0.5);

        double pressureValue = sensor.popNextPressurePsiValue();

        // The calculation will be 6 * 0.5 * 0.5 = 1.5, so final pressure = 16 + 1.5 = 17.5
        assertEquals(17.5, pressureValue, 0.001);
    }

    // ------------------------------------------------------------------------------------------
    // readPressureSample Method Tests
    // ------------------------------------------------------------------------------------------

    @Test
    public void readPressureSampleMethodReturnsValueWithinExpectedRange() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {
        Sensor sensor = new Sensor();

        Method readPressureSampleMethod = Sensor.class.getDeclaredMethod("readPressureSample");
        readPressureSampleMethod.setAccessible(true);

        double sampleValue = (double) readPressureSampleMethod.invoke(sensor);

        assertTrue("Pressure sample value should be within the range [0 - 6]. Actual: " + sampleValue,
                sampleValue >= 0 && sampleValue <= 6);
    }

    @Test
    public void readPressureSampleMethodReturnsCorrectValue() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException
    {
        Sensor sensor = new Sensor();

        Method readPressureSampleMethod = Sensor.class.getDeclaredMethod("readPressureSample");
        readPressureSampleMethod.setAccessible(true);

        setRandomReturnValue(sensor, 0.5);

        double sampleValue = (double) readPressureSampleMethod.invoke(sensor);

        // The calculation will be 6 * 0.5 * 0.5 = 1.5
        assertEquals(1.5, sampleValue, 0.001);
    }
}
