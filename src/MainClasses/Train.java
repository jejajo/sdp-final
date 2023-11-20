package MainClasses;

import Decorator.DisabilityDecorator;
import Observer.TrainObserver;
import Observer.TrainSubject;
import Strategy.MovementStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Train implements PassengerTrain, TrainSubject {
    protected String trainRoute;
    protected List<Passenger> passengers;
    protected boolean onRoad;
    protected MovementStrategy movementStrategy;
    protected float avgSpeed;
    protected float ticketPrice;

    protected Train(String trainRoute) {
        this.trainRoute = trainRoute;
        passengers = new ArrayList<>();
        onRoad = false;
    }

    protected void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
        this.avgSpeed = movementStrategy.setAverageSpeed();
    }

    public void setTicketPrice(float price) {
        ticketPrice = price;
    }

    @Override
    public String getRoute() {
        return this.trainRoute;
    }

    private List<TrainObserver> observers = new ArrayList<>();

    @Override
    public void sendTrain() {
        if (onRoad) {
            System.out.println("Train is already on the route");
            return;
        }
        onRoad = true;
        System.out.println(trainRoute + " train went along the route");
    }

    @Override
    public void stopTrain() {
        if (!onRoad) {
            System.out.println("Train is already on the station");
            return;
        }
        onRoad = false;

        notifyObservers();

        passengers.clear();
        System.out.println(this.trainRoute + " was stopped. All passengers was checked out.");
    }

    @Override
    public void getInfoAboutPassengers() {
        for (Passenger passenger : passengers) {
            System.out.println(passenger.getFullName() + ", " + passenger.getAge() + " yo");
        }
    }

    @Override
    public float addPassenger(Passenger passenger) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Check the archive about " + passenger.getFullName());
        System.out.println("WARNING. Is he/she has a disability? 1 - yes. Otherwise write any symbols");
        String isDisability = sc.nextLine();
        float money;
        if (isDisability.equalsIgnoreCase("1")) {
            money = new DisabilityDecorator(passenger).checkInTrain(this);
        } else {
            money = passenger.checkInTrain(this);
        }
        passengers.add(passenger);
        return money;
    }

    @Override
    public void getInfoAboutTrain() {
        System.out.println("Train: " + trainRoute);
        System.out.println((this instanceof HighSpeedPassengerTrain ? "High-speed" : "Simple-speed") + ", " + this.avgSpeed + " km/h");
        System.out.println("Passengers:");
        getInfoAboutPassengers();
    }

    @Override
    public void registerObserver(TrainObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(TrainObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (TrainObserver observer : observers) {
            observer.updateOnTrainStop();
        }
    }


}
