package task;

import task.service.BikeService;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Application {
    private static BikeService service = new BikeService();

    public static void main(String[] args) {
        service.loadFromFile("ecobike.txt");
        runApplication();


    }

    private static void runApplication( ) {
        int n = 0;

        while (n != 7) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please make your choice:\n" +
                        "1 - Show the entire EcoBike catalog\n" +
                        "2 – Add a new folding bike\n" +
                        "3 – Add a new speedelec\n" +
                        "4 – Add a new e-bike\n" +
                        "5 – Find the first item of a particular brand\n" +
                        "6 – Write to file\n" +
                        "7 – Stop the program");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a number from list below.");
                } else {
                    n = scanner.nextInt();

                    switch (n) {
                        case 1:
                            service.getBikes().forEach(bike -> System.out.println(bike));
                            break;
                        case 2:
                            service.addNewFoldingBike();
                            break;
                        case 3:
                            service.addNewSpeedOrElectricBike(3);
                            break;
                        case 4:
                            service.addNewSpeedOrElectricBike(4);
                            break;
                        case 5:
                            service.findFirstItem();
                            break;
                        case 6: service.saveBikes("ecobike.txt");
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Oops something went wrong. Please try again.");
            }
        }
        System.out.println("The program is stopped");
    }

}
