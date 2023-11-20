package MainClasses;

import MainClasses.Train;
import Strategy.HighSpeedMovementStrategy;

public class HighSpeedPassengerTrain extends Train {
    public HighSpeedPassengerTrain(String trainRoute) {
        super(trainRoute);
        super.setMovementStrategy(new HighSpeedMovementStrategy());
    }
}
