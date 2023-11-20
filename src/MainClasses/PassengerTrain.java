package MainClasses;

import java.util.List;

public interface PassengerTrain {
    String getRoute();
    void getInfoAboutTrain();
    float addPassenger(Passenger passenger);
    void getInfoAboutPassengers();
    void sendTrain();
    void stopTrain();
}
