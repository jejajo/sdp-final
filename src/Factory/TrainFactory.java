package Factory;

import MainClasses.Train;

public interface TrainFactory {
    Train createTrain(String route);
}
