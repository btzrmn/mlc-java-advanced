package Exercise.TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTests {

    private Sensor mockSensor;
    private Alarm alarm;

    @Before
    public void init() {
        mockSensor = Mockito.mock(Sensor.class);
        alarm = new Alarm(mockSensor);
    }

    @Test
    public void pressureIsNormalThenNoAlarm() {
        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(18.0);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void pressureIsLowThenAlarm() {
        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(16.1);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void pressureIsHighThenAlarm() {
        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(23.2);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

}
