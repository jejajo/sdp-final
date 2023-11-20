package Decorator;

import MainClasses.Passenger;
import MainClasses.TrainTraveler;

public abstract class PassengerDecorator implements TrainTraveler {
    protected Passenger passenger;
    protected PassengerDecorator(Passenger passenger){
        this.passenger = passenger;
    }
}
