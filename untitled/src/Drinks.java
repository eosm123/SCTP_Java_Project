import java.util.ArrayList;

public class Drinks implements iOrderable {
    protected String customerName;
    protected ArrayList<String> drinks;
    protected ArrayList<Double> baseTotalPrice;
    protected ArrayList<Boolean> isIced;

    public Drinks() {
        this.customerName = "NA";
        this.drinks = new ArrayList<>();
        this.baseTotalPrice = new ArrayList<>();
        this.isIced = new ArrayList<>();
    }

    public Drinks(String customerName, ArrayList<String> drinks, ArrayList<Double> baseTotalPrice, ArrayList<Boolean> isIced) {
        this.customerName = customerName;
        this.drinks = drinks;
        this.baseTotalPrice = baseTotalPrice;
        this.isIced = isIced;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<String> getdrinks() {
        return drinks;
    }

    public void setDrink(ArrayList<String> drinks) {
        this.drinks = drinks;
    }

    public ArrayList<Double> getTotalPrice() {
        return baseTotalPrice;
    }

    public void setTotalPrice(ArrayList<Double> baseTotalPrice) {
        this.baseTotalPrice = baseTotalPrice;
    }

    public ArrayList<Boolean> getIsIced() {
        return isIced;
    }

    public void setIsIced(ArrayList<Boolean> isIced) {
        this.isIced = isIced;
    }

    public double calculateBaseTotalPrice() {
        double sumPrice = 0.0;
        for (double p : baseTotalPrice) {
            sumPrice = sumPrice + p;
        }
        return sumPrice;
    }

    public String toString() {
        return "Customer Name: " + customerName
                + ", List of Drinks: " + drinks
                + ", Total Price: " + String.format("%.2f", calculateBaseTotalPrice())
                + ", Is it Iced? " + isIced;
    }

    public double calculateNetTotalPrice() {
        return calculateBaseTotalPrice();
    }
}


