package Decorator;

import MainClasses.Passenger;
import MainClasses.Train;

public class DisabilityDecorator extends PassengerDecorator{
    public DisabilityDecorator(Passenger passenger){
        super(passenger);
    }

    @Override
    public float checkInTrain(Train train) {
        return passenger.checkInTrain(train) - 1000;
    }

    @Override
    public void checkOutTrain(Train train) {
        passenger.checkOutTrain(train);
    }
}
