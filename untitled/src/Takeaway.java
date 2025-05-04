import java.util.ArrayList;
import java.util.Scanner;

public class Takeaway extends FoodOrder {
    protected String packagingType;
    protected String preferredPickupTime;

    public Takeaway() {
        super();
        this.packagingType = "NA";
        this.preferredPickupTime = "NA";
    }

    public Takeaway(String customerName,
                    ArrayList<String> dish,
                    ArrayList<Double> baseTotalPrice,
                    String packagingType,
                    String preferredPickupTime) {
        super(customerName, dish, baseTotalPrice);
        this.packagingType = packagingType;
        this.preferredPickupTime = preferredPickupTime;
    }

    public String getPackagingType() {
        return packagingType;
    }

    public void setPackagingType(String packagingType) {
        this.packagingType = packagingType;
    }

    public String getPreferredPickupTime() {
        return preferredPickupTime;
    }

    public void setPreferredPickupTime(String preferredPickupTime) {
        this.preferredPickupTime = preferredPickupTime;
    }

    public double calculateBaseTotalPrice() {
        return super.calculateBaseTotalPrice();
    }

    @Override
    public double calculateNetTotalPrice() {
        // assuming 50c for takeaway container
        return calculateBaseTotalPrice() + 0.5;
    }

    @Override
    public String toString() {
        return super.toString() + ", Takeaway [packing type = " + packagingType + ", preferred pickup time = " + preferredPickupTime + "]";
    }

    public void display() {
        super.display();
        System.out.println("Packing Type: " + getPackagingType());
        System.out.println("Preferred Pickup Time: " + getPreferredPickupTime());
        System.out.println("Net Total Price: $" + String.format("%.2f", calculateNetTotalPrice()));
    }

    public void updateInfo(Scanner sc) {
        super.updateInfo(sc);

        System.out.println("Current choice of packaging type: " + packagingType);
        System.out.println("Please give a different choice of packaging type or leave blank to leave it unchanged");
        String newPackagingType = sc.nextLine();
        if (! newPackagingType.equals("")) {
            setPackagingType(newPackagingType);
        }

        System.out.println("Current preferred pickup time: " + preferredPickupTime);
        System.out.println("Please enter a new time for pickup or leave blank to leave it unchanged");
        String newPickupTime = sc.nextLine();
        if (! newPickupTime.equals("")) {
            setPreferredPickupTime(newPickupTime);
        }
    }
}
