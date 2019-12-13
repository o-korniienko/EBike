package task.dto;

public class ElectricSpeedBike extends Bike{

    private int maxSpeed;
    private int batteryCapacity;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }


    @Override
    public String toString() {
        if (this.isLightsAvailability()) {
            return this.getBrand() + " with " + batteryCapacity + " mAh battery and  head/tail light.\n" +
                    "Price: " + this.getPrice() + " euros.";
        } else {
            return this.getBrand() + " with " + batteryCapacity + " mAh battery and no head/tail light.\n" +
                    "Price: " + this.getPrice() + " euros.";
        }
    }
}
