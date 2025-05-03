public class Takeaway extends FoodOrder {
    protected int pickupTime;
    protected String packagingType;

    public double calculateTotalPrice() {
        double sumPrice = 0.0;
        for (double p : totalPrice) {
            sumPrice = sumPrice + p;
        }
        return sumPrice;
    }
}
