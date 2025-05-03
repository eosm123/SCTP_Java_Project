import java.util.ArrayList;

public class FoodOrder {
    protected int id;
    protected String customerName;
    protected ArrayList<String> dish;
    protected ArrayList<Double> totalPrice;

    public FoodOrder() {
        this.id = 0;
        this.customerName = "NA";
        this.dish = new ArrayList<>();
        this.totalPrice = new ArrayList<>();
    }

    public FoodOrder(int id, ArrayList<String> dish, String customerName, ArrayList<Double> totalPrice) {
        this.id = id;
        this.customerName = customerName;
        this.dish = dish;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<Double> getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(ArrayList<Double> totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double calculateTotalPrice() {
        double sumPrice = 0.0;
        for (double p : totalPrice) {
            sumPrice = sumPrice + p;
        }
        return sumPrice;
    }

    public String convertToString() {
        return "Order ID: " + id + ", List of Dishes: " + dish + ", Customer Name: " + customerName + ", Total Price: " + calculateTotalPrice();
    }
}
