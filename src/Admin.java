import MainClasses.*;

import java.util.Random;
import java.util.Scanner;

public class Admin {
    public static void printMenu() {
        System.out.println("\nMenu.");
        System.out.println("1. Get Info about station");
        System.out.println("2. Budget");
        System.out.println("3. Send the train");
        System.out.println("4. Stop the train");
        System.out.println("5. Add new train");
        System.out.println("6. Check into the passenger to the train");
        System.out.println("7. Get Info about train");
        System.out.println("8. Quit");
    }

    public static Passenger[] listOfPassengersSE2208() {
        String[] passengerNames = {
                "Nariman Aimagambetov", "Almas Amrenov", "Bexultan Arakhan",
                "Merey Azhibekova", "Zhangeldy Beisenov", "Asanali Elzhanov",
                "Zagipa Koishibayeva", "Sultangali Kozhanov", "Assel Kudaibergenova",
                "Saiat Kusain", "Ali Maksotov", "Alibek Matayev", "Diana Melnikova",
                "Emirzhan Smagulov", "Temirlan Smailov", "Ali Tulegenov", "Ansar Utenov",
                "Yelizaveta Yermolayeva", "Valentin Zakharov", "Batyrkhan Zhukabayev"
        };

        Passenger[] passengers = new Passenger[passengerNames.length];
        Random random = new Random();

        for (int i = 0; i < passengerNames.length; i++) {
            int randomAge = random.nextInt(3) + 18;
            passengers[i] = new Passenger(passengerNames[i], randomAge);
        }
        return passengers;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Passenger[] passengers = listOfPassengersSE2208();
        KazakhstanTemirJoly kazakhstanTemirJoly = KazakhstanTemirJoly.getInstance();
        System.out.println("Welcome Admin.\n\n");
        String option = "-";
        while (!option.equals("8")) {
            printMenu();
            option = sc.nextLine();
            switch (option) {
                case "1":
                    kazakhstanTemirJoly.getInfoAboutStation();
                    break;
                case "2":
                    System.out.println(kazakhstanTemirJoly.getBudget());
                    break;
                case "3":
                    String trainRouteSend = sc.nextLine();
                    kazakhstanTemirJoly.sendTrain(trainRouteSend);
                    break;
                case "4":
                    String trainRouteStop = sc.nextLine();
                    kazakhstanTemirJoly.stopTrain(trainRouteStop);
                    break;
                case "5":
                    kazakhstanTemirJoly.addTrain();
                    System.out.println("Set the ticket price");
                    break;
                case "6":
                    System.out.println("Choose one passenger");
                    for (int i = 0; i < passengers.length; i++) {
                        if(passengers[i] == null){
                            continue;
                        }
                        System.out.println((i + 1) + " " + passengers[i].getFullName() + " " + passengers[i].getAge() + "yo");
                    }
                    int choosePassenger = -1;
                    while(choosePassenger < 0 || choosePassenger > passengers.length){
                        choosePassenger = sc.nextInt();
                    }
                    Passenger passenger = passengers[choosePassenger - 1];
                    sc.nextLine();
                    kazakhstanTemirJoly.getInfoAboutStation();
                    System.out.println("Choose the train");
                    String chooseTrain = sc.nextLine();
                    kazakhstanTemirJoly.addToBudget(kazakhstanTemirJoly.getTrains().get(chooseTrain).addPassenger(passenger));
                    passengers[choosePassenger - 1] = null;
                    break;
                case "7":
                    System.out.println("Choose train");
                    kazakhstanTemirJoly.getInfoAboutStation();
                    String route = sc.nextLine();
                    kazakhstanTemirJoly.getTrains().get(route).getInfoAboutTrain();
                    break;
                case "8":
                    System.out.println("Shutdown");
                    break;
                default:
                    System.out.println("Incorrect option");
                    break;
            }

        }
    }
}
