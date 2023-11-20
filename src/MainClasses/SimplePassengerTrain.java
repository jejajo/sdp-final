package MainClasses;

import MainClasses.Train;
import Strategy.SimpleSpeedMovementStrategy;

public class SimplePassengerTrain extends Train {
    public SimplePassengerTrain(String trainRoute){
        super(trainRoute);
        super.setMovementStrategy(new SimpleSpeedMovementStrategy());
    }
}
