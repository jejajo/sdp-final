package MainClasses;

import Observer.TrainObserver;

public class Passenger implements TrainTraveler, TrainObserver {
    private String fullName;
    private int age;
    private Train train;
    public Passenger(String nameSurname, int age){
        fullName = nameSurname;
        this.age = age;
        this.train = null;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getAge() {
        return age;
    }

    public String getFullName() {
        return fullName;
    }

    public Train getTrain() {
        return train;
    }

    @Override
    public float checkInTrain(Train train) {
        this.train = train;
        System.out.println(fullName + " was checked into the " + train.getRoute() + " train.");
        return train.ticketPrice;
    }

    @Override
    public void checkOutTrain(Train train) {
        this.train = null;
        System.out.println(fullName + " was checked out from the " + train.getRoute() + " train.");
    }
    @Override
    public void updateOnTrainStop() {
        if (train != null) {
            checkOutTrain(train);
        }
    }

}
