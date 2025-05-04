import java.util.ArrayList;
import java.util.Scanner;

public class Delivery extends FoodOrder {
    protected String deliveryAddress;
    protected String instructionsForDriver;

    public Delivery() {
        super();
        this.deliveryAddress = "NA";
        this.instructionsForDriver = "NA";
    }

    public Delivery(String customerName,
                    ArrayList<String> dish,
                    ArrayList<Double> baseTotalPrice,
                    String deliveryAddress,
                    String instructionsForDriver) {
        super(customerName, dish, baseTotalPrice);
        this.deliveryAddress = deliveryAddress;
        this.instructionsForDriver = instructionsForDriver;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getInstructionsForDriver() {
        return instructionsForDriver;
    }

    public void setInstructionsForDriver(String instructionsForDriver) {
        this.instructionsForDriver = instructionsForDriver;
    }

    public double calculateBaseTotalPrice() {
        return super.calculateBaseTotalPrice();
    }

    @Override
    public double calculateNetTotalPrice() {
        // assuming delivery fee is always $4.0
        return calculateBaseTotalPrice() + 4.0;
    }

    @Override
    public String toString() {
        return super.toString() + ", Delivery [address = " + deliveryAddress + ", instructions = " + instructionsForDriver + "]";
    }

    public void display() {
        super.display();
        System.out.println("Delivery Address: " + getDeliveryAddress());
        System.out.println("Driver Instructions: " + getInstructionsForDriver());
        System.out.println("Net Total Price: $" + String.format("%.2f", calculateNetTotalPrice()));
    }

    @Override
    public void updateInfo(Scanner sc) {
        super.updateInfo(sc);

        System.out.println("Current delivery address: " + deliveryAddress);
        System.out.println("Please enter another address or leave blank to leave it unchanged");
        String newAddress = sc.nextLine();
        if (! newAddress.equals("")) {
            setDeliveryAddress(newAddress);
        }

        System.out.println("Current instructions for driver: " + instructionsForDriver);
        System.out.println("Please enter different instructions or leave blank to leave it unchanged");
        String newInstructions = sc.nextLine();
        if (! newInstructions.equals("")) {
            setInstructionsForDriver(newInstructions);
        }

    }


}
