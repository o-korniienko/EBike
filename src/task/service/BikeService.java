package task.service;

import task.dto.Bike;
import task.dto.FoldingBike;
import task.dto.ElectricSpeedBike;

import java.io.*;
import java.util.*;

public class BikeService {

    private Comparator<Bike> byBrand = Comparator.comparingInt(o -> o.getBrand().hashCode());
    private Comparator<Bike> byPrice = (o1, o2) -> (int) (o1.getPrice() - o2.getPrice());
    private Set<Bike> bikes = new TreeSet<>(byBrand.thenComparing(byPrice));

    public Set<Bike> getBikes() {
        return bikes;
    }

    public void loadFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(";");
                String[] words1 = words[0].split(" ");
                if (words1[0].equals("FOLDING")) {
                    FoldingBike bike = new FoldingBike();
                    String brand = words[0];
                    bike.setBrand(brand);
                    bike.setSizeOfWheels(Integer.parseInt(words[1].trim()));
                    bike.setNumberOfGears(Integer.parseInt(words[2].trim()));
                    bike.setWeight(Integer.parseInt(words[3].trim()));
                    if (words[4].trim().equals("true")) {
                        bike.setLightsAvailability(true);
                    } else {
                        bike.setLightsAvailability(false);
                    }
                    bike.setColor(words[5].trim());
                    bike.setPrice(Integer.parseInt(words[6].trim()));
                    bikes.add(bike);
                } else {
                    ElectricSpeedBike bike = new ElectricSpeedBike();
                    String brand = words[0];
                    bike.setBrand(brand);
                    bike.setMaxSpeed(Integer.parseInt(words[1].trim()));
                    bike.setWeight(Integer.parseInt(words[2].trim()));
                    if (words[3].trim().equals("true")) {
                        bike.setLightsAvailability(true);
                    } else {
                        bike.setLightsAvailability(false);
                    }
                    bike.setBatteryCapacity(Integer.parseInt(words[4].trim()));
                    bike.setColor(words[5]);
                    bike.setPrice(Integer.parseInt(words[6].trim()));
                    bikes.add(bike);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addNewFoldingBike() {
        FoldingBike bike = new FoldingBike();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("A brand");
        bike.setBrand("FOLDING BIKE " + scanner1.next());
        System.out.println("The size of the wheels (in inch)");
        while (!scanner1.hasNextInt()) {
            System.out.println("Please enter numbers.");
            scanner1 = new Scanner(System.in);
        }
        bike.setSizeOfWheels(scanner1.nextInt());
        System.out.println("The number of gears");
        while (!scanner1.hasNextInt()) {
            System.out.println("Please enter numbers.");
            scanner1 = new Scanner(System.in);
        }
        bike.setNumberOfGears(scanner1.nextInt());
        System.out.println("The weight of the bike (in grams)");
        while (!scanner1.hasNextInt()) {
            System.out.println("Please enter numbers.");
            scanner1 = new Scanner(System.in);
        }
        bike.setWeight(scanner1.nextInt());
        System.out.println("The availability of lights at front and back (TRUE/FALSE)");
        while (!scanner1.hasNextBoolean()) {
            System.out.println("Please enter 'true' or 'false'.");
            scanner1 = new Scanner(System.in);
        }
        bike.setLightsAvailability(scanner1.nextBoolean());
        System.out.println("The price");
        while (!scanner1.hasNextInt()) {
            System.out.println("Please enter numbers.");
            scanner1 = new Scanner(System.in);
        }
        bike.setPrice(scanner1.nextInt());
        System.out.println("A color");
        bike.setColor(scanner1.next());
        bikes.add(bike);
    }

    public void addNewSpeedOrElectricBike(int n) {
        ElectricSpeedBike bike = new ElectricSpeedBike();
        Scanner scanner1 = new Scanner(System.in);
        String typeOfBike = "";
        if (n == 3) {
            typeOfBike = "SPEEDELEC ";
        }
        if (n == 4) {
            typeOfBike = "E-BIKE ";
        }
        System.out.println("A brand");
        bike.setBrand(typeOfBike + scanner1.next());
        System.out.println("The maximum speed (in km/h)");
        while (!scanner1.hasNextInt()) {
            System.out.println("Please enter numbers.");
            scanner1 = new Scanner(System.in);
        }
        bike.setMaxSpeed(scanner1.nextInt());
        System.out.println("The battery capacity (in mAh)");
        while (!scanner1.hasNextInt()) {
            System.out.println("Please enter numbers.");
            scanner1 = new Scanner(System.in);
        }
        bike.setBatteryCapacity(scanner1.nextInt());
        System.out.println("The weight of the bike (in grams)");
        while (!scanner1.hasNextInt()) {
            System.out.println("Please enter numbers.");
            scanner1 = new Scanner(System.in);
        }
        bike.setWeight(scanner1.nextInt());
        System.out.println("The availability of lights at front and back (TRUE/FALSE)");
        while (!scanner1.hasNextBoolean()) {
            System.out.println("Please enter 'true' or 'false'.");
            scanner1 = new Scanner(System.in);
        }
        bike.setLightsAvailability(scanner1.nextBoolean());
        System.out.println("The price");
        while (!scanner1.hasNextInt()) {
            System.out.println("Please enter numbers.");
            scanner1 = new Scanner(System.in);
        }
        bike.setPrice(scanner1.nextInt());
        System.out.println("A color");
        bike.setColor(scanner1.next());
        bikes.add(bike);
    }

    public void findFirstItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a brand name.");
        String brand = scanner.nextLine();
        String b = null;
        for (Bike bike : bikes) {
            if (bike.getBrand().contains(brand)) {
                b = bike.toString();
                break;
            }
        }

        if (b != null) {
            System.out.println(b);
        } else {
            System.out.println("There is no bike  with this brand in the database.");
        }
    }

    public void saveBikes(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            String line;

            for (Bike bike : bikes) {
                if (bike.getBrand().contains("FOLDING BIKE")){
                    line = bike.getBrand() + "; " + ((FoldingBike) bike).getSizeOfWheels() + "; " + ((FoldingBike) bike).getNumberOfGears() + "; " +
                            bike.getWeight() + "; " + bike.isLightsAvailability() + "; " + bike.getColor() + "; "
                            + bike.getPrice();
                    bw.write(line + '\n');
                }else{
                    line = bike.getBrand() + "; " + ((ElectricSpeedBike)bike).getMaxSpeed() + "; " + bike.getWeight() + "; "
                            + bike.isLightsAvailability() + "; " + ((ElectricSpeedBike) bike).getBatteryCapacity() + "; " + bike.getColor() + "; "
                            + bike.getPrice();
                    bw.write(line + '\n');
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
