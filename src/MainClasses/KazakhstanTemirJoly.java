package MainClasses;

import Adapter.Printable;
import Adapter.TrainDataPrintableAdapter;
import Factory.*;

import java.util.HashMap;
import java.util.Scanner;

public class KazakhstanTemirJoly implements TrainSystemManager {
    private static KazakhstanTemirJoly instance;
    private String name;
    private float budget;
    private HashMap<String, Train> trains;
    private HighSpeedTrainFactory highSpeedTrainFactory;
    private SimpleSpeedTrainFactory simpleSpeedTrainFactory;

    private KazakhstanTemirJoly() {
        name = "Казахстан темир жолы";
        trains = new HashMap<>();
        budget = 5000;
        highSpeedTrainFactory = new HighSpeedTrainFactory();
        simpleSpeedTrainFactory = new SimpleSpeedTrainFactory();
    }

    public static KazakhstanTemirJoly getInstance() {
        if (instance == null) {
            instance = new KazakhstanTemirJoly();
        }
        return instance;
    }

    public void getInfoAboutStation() {
        String info = name + ", budget: " + budget + ", trains: ";
        for (PassengerTrain train : trains.values()) {
            info += train.getRoute() + ", ";
        }
        Printable printable = new TrainDataPrintableAdapter();
        printable.print(info);
    }

    @Override
    public void addTrain() {
        if (budget < 5000) {
            System.out.println("Your budget doesn't allow you to buy a new train");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("What train you want to add? 1 - high-speed 2 - simple-speed");
        Train newTrain;
        String route;
        String choose = sc.nextLine();
        if (choose.equalsIgnoreCase("1")) {
            route = sc.nextLine();
            newTrain = highSpeedTrainFactory.createTrain(route);
        } else if (choose.equalsIgnoreCase("2")) {
            route = sc.nextLine();
            newTrain = simpleSpeedTrainFactory.createTrain(route);
        } else {
            System.out.println("Invalid option");
            return;
        }
        System.out.println("Set the ticket price");
        float price = sc.nextFloat();
        newTrain.setTicketPrice(price);
        trains.put(route, newTrain);
        System.out.println("Train was added. -5000");
        this.budget -= 5000;
    }

    @Override
    public void addToBudget(float money) {
        this.budget += money;
    }

    @Override
    public void sendTrain(String route) {
        PassengerTrain train = trains.get(route);
        train.sendTrain();
    }

    @Override
    public void stopTrain(String route) {
        PassengerTrain train = trains.get(route);
        train.stopTrain();
    }

    public float getBudget() {
        return budget;
    }

    public HashMap<String, Train> getTrains() {
        return trains;
    }
}
