import java.util.ArrayList;
import java.util.Scanner;

public abstract class FoodOrder implements iOrderable {
    protected String customerName;
    protected ArrayList<String> dish;
    protected ArrayList<Double> baseTotalPrice;

    public FoodOrder() {
        this.customerName = "NA";
        this.dish = new ArrayList<>();
        this.baseTotalPrice = new ArrayList<>();
    }

    public FoodOrder(String customerName, ArrayList<String> dish, ArrayList<Double> baseTotalPrice) {
        this.customerName = customerName;
        this.dish = dish;
        this.baseTotalPrice = baseTotalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<String> getDish() {
        return dish;
    }

    public void setDish(ArrayList<String> dish) {
        this.dish = dish;
    }

    public ArrayList<Double> getBaseTotalPrice() {
        return baseTotalPrice;
    }

    public void setBaseTotalPrice(ArrayList<Double> baseTotalPrice) {
        this.baseTotalPrice = baseTotalPrice;
    }

    public double calculateBaseTotalPrice() {
        double sumPrice = 0.0;
        for (double p : baseTotalPrice) {
            sumPrice = sumPrice + p;
        }
        return sumPrice;
    }

    public abstract double calculateNetTotalPrice();

    public String toString() {
        return "Customer Name: " + customerName + ", List of Dishes: " + dish + ", Total Price: " + String.format("%.2f", calculateBaseTotalPrice());
    }

    public void display() {
        System.out.println("Customer Name: " + getCustomerName());
        System.out.println("List of Dishes: " + getDish());
        System.out.println("Total Base Price: $" + String.format("%.2f", calculateBaseTotalPrice()));
    }

    public void updateInfo(Scanner sc) {
        System.out.println("Current customer name: " + customerName);
        System.out.println("Please enter another name or leave blank to leave it unchanged");
        String newName = sc.nextLine();
        if (! newName.equals("")) {
            setCustomerName(newName);
        }
        for (int i=0; i<dish.size(); i++) {
            System.out.println("\nCurrent dish: " + dish.get(i) + ", $" + String.format("%.2f", baseTotalPrice.get(i)));

            System.out.println("Please enter another dish or leave blank to leave it unchanged");
            String newDish = sc.nextLine();
            if (! newDish.equals("")) {
                dish.set(i, newDish);
            }
            System.out.println("Please enter a different price or leave blank to leave it unchanged");
            String tempPrice = sc.nextLine();
            if (! tempPrice.equals("")) {
                double newPrice = Double.parseDouble(tempPrice);
                baseTotalPrice.set(i, newPrice);
            }
        }
    }
}
