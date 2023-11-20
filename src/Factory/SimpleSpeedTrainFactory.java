package Factory;

import MainClasses.SimplePassengerTrain;
import MainClasses.Train;

public class SimpleSpeedTrainFactory implements TrainFactory{

    @Override
    public Train createTrain(String route) {
        return new SimplePassengerTrain(route);
    }
}
