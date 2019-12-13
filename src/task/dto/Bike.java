package task.dto;

public abstract class Bike {

    private String brand;
    private int weight;
    private boolean isLightsAvailability;
    private String color;
    private int price;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getWeight() {
        return weight;
    }

    public boolean isLightsAvailability() {
        return isLightsAvailability;
    }

    public void setLightsAvailability(boolean lightsAvailability) {
        isLightsAvailability = lightsAvailability;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getPrice() {
        return price;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bike bike = (Bike) o;

        if (weight != bike.weight) return false;
        if (isLightsAvailability != bike.isLightsAvailability) return false;
        if (price != bike.price) return false;
        if (brand != null ? !brand.equals(bike.brand) : bike.brand != null) return false;
        return color != null ? color.equals(bike.color) : bike.color == null;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (int) (weight ^ (weight >>> 32));
        result = 31 * result + (isLightsAvailability ? 1 : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (int) (price ^ (price >>> 32));
        return result;
    }

}
