import java.io.Serializable;
import java.util.Random;

//Pressure Sensor
public class Sensor implements Serializable {
    private Pressure mPressure;

    //Measure the pressure on init
    public Sensor() {
        Random random = new Random();
        int index = random.nextInt(Pressure.values().length);
        mPressure = Pressure.values()[index];
    }

    public Pressure getPressure() {
        return mPressure;
    }
}

