import java.util.ArrayList;

public class Drinks {
    protected int id;
    protected ArrayList<String> drinks;
    protected String customerName;
    protected double totalPrice;
    protected boolean isIced;

    public Drinks() {
        this.id = 0;
        this.drinks = new ArrayList<>();
        this.customerName = "NA";
        this.totalPrice = 0.0;
        this.isIced = false;
    }

    public Drinks(int id, ArrayList<String> drinks, String customerName, double totalPrice, boolean isIced) {
        this.id = id;
        this.drinks = drinks;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.isIced = isIced;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getdrinks() {
        return drinks;
    }

    public void setDrink(ArrayList<String> drinks) {
        this.drinks = drinks;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        if (totalPrice > 0) {
            this.totalPrice = totalPrice;
        } else {
            throw new IllegalArgumentException("Invalid price");
        }
    }

    public boolean getIsIced() {
        return isIced;
    }

    public void setIsIced(boolean isIced) {
        this.isIced = isIced;
    }
}
