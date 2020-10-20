import java.io.Serializable;
import java.util.Random;

//Consume battery based on user-usage
public class Battery implements Serializable {
    private int mPercentage = 100;

    public int getPercentage() {
        return mPercentage;
    }

    public void consume() {
        Random random = new Random();//Setted up random function
        int result = random.nextInt(25 - 10) + 10;//Getting a random integer value between 25 and 10
        mPercentage = mPercentage - result;//Subtracting a random integer from batteryPercentage to get remaining
    }
}
