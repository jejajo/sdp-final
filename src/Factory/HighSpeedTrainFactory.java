package Factory;

import MainClasses.HighSpeedPassengerTrain;
import MainClasses.Train;

public class HighSpeedTrainFactory implements TrainFactory{
    @Override
    public Train createTrain(String route) {
        return new HighSpeedPassengerTrain(route);
    }
}
