package task.dto;

public class FoldingBike extends Bike {

    private int sizeOfWheels;
    private int numberOfGears;

    public int getSizeOfWheels() {
        return sizeOfWheels;
    }

    public void setSizeOfWheels(int sizeOfWheels) {
        this.sizeOfWheels = sizeOfWheels;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    @Override
    public String toString() {
        if (this.isLightsAvailability()) {
            return this.getBrand() + " with " + numberOfGears + " gear(s) and  head/tail light.\n" +
                    "Price: " + this.getPrice() + " euros.";
        } else {
            return this.getBrand() + " with " + numberOfGears + " gear(s) and no head/tail light.\n" +
                    "Price: " + this.getPrice() + " euros.";
        }
    }
}
