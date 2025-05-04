import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc;
    public static ArrayList<FoodOrder> orders;
    public static ArrayList<Drinks> drinkList;
    public static ArrayList<iOrderable> orderables;

    public static void main(String[] args) {
        orders = new ArrayList<FoodOrder>();
        drinkList = new ArrayList<Drinks>();
        orderables = new ArrayList<iOrderable>();

        // Test Product 1
        ArrayList<String> dish = new ArrayList<String>();
        dish.add("Big Mac");
        dish.add("MacChicken");

        ArrayList<Double> cost = new ArrayList<Double>();
        cost.add(6.6);
        cost.add(5.2);
        var macDonalds = new Delivery("John Smith", dish, cost, "Orchard Road", "Keep my food hot");
        orders.add(macDonalds);
        orderables.add(macDonalds);

        // Test Product 2
        ArrayList<String> dish1 = new ArrayList<String>();
        dish1.add("2-piece Chicken Meal");
        dish1.add("Cajun Chicken Burger");

        ArrayList<Double> cost1 = new ArrayList<Double>();
        cost1.add(8.4);
        cost1.add(5.6);
        var popeyes = new Takeaway("Katie Smith", dish1, cost1, "Paper bag", "Now");
        orders.add(popeyes);
        orderables.add(popeyes);

        // Test Product 3 (Drinks)
        ArrayList<String> beverage = new ArrayList<String>();
        beverage.add("Earl Grey Milk Tea");
        beverage.add("Caramel Milk Tea");

        ArrayList<Double> beverageCost = new ArrayList<Double>();
        beverageCost.add(4.4);
        beverageCost.add(5.2);

        ArrayList<Boolean> areIced = new ArrayList<Boolean>();
        areIced.add(false);
        areIced.add(true);
        var koi = new Drinks("Elsa", beverage, beverageCost, areIced);
        drinkList.add(koi);

        // Add in interface arraylist here


        while (true) {
            sc = new Scanner(System.in);
            System.out.println("Menu:");
            System.out.println("1. Show all food orders");
            System.out.println("2. Add a new food order");
            System.out.println("3. Update a food order");
            System.out.println("4. Delete a food order");
            System.out.println("5. Add new drinks");
            System.out.println("6. Quit");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1) {
                showFoodOrders();
            }
            if(choice == 2) {
                addFoodOrder();
            }
            if(choice == 3) {
                updateFoodOrder();
            }
            if(choice == 4) {
                deleteFoodOrder();
            }
            if(choice == 5) {
                addDrinks();
            }
            if(choice == 6) {
                System.out.println("Quitting");
                break;
            }
        }
    }

    public static void showFoodOrders() {
        System.out.println("Showing all food orders");
        for (FoodOrder o : orders) {
            o.display();
            System.out.println();
        }
    }

    public static void addFoodOrder() {
        System.out.println("Add a new food order");
        System.out.println("Enter customer name: ");
        String name = sc.nextLine();

        ArrayList<String> dishes = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();

        while (true) {
            System.out.println("Add a dish: ");
            String dish =  sc.nextLine();
            dishes.add(dish);

            System.out.println("Add a price for " + dish + ": ");
            double price =  sc.nextDouble();
            prices.add(price);
            sc.nextLine();

            System.out.println("Anymore dishes to add? (Y for yes, N for no) ");
            String dishChoice = sc.nextLine();
            if (dishChoice.equalsIgnoreCase("n")) {
                break;
            }
        }
        System.out.println("Delivery or takeaway? (D for delivery, T for Takeaway) ");
        String orderChoice = sc.next();
        sc.nextLine();

        if (orderChoice.equalsIgnoreCase("d")) {
            System.out.println("Where would you like to deliver to? ");
            String deliveryAddress = sc.nextLine();
            System.out.println("Do you have any special instructions for the driver? ");
            String instructionsForDriver =  sc.nextLine();
            Delivery deliver = new Delivery(name, dishes, prices, deliveryAddress, instructionsForDriver);
            orders.add(deliver);
            System.out.println("Delivery order added successfully.");
        } else {
            System.out.println("What type of packing would you like to use? ");
            String packagingType = sc.nextLine();
            System.out.println("What time would you like to pickup? ");
            String preferredPickupTime =  sc.nextLine();
            Takeaway dabao = new Takeaway(name, dishes, prices, packagingType, preferredPickupTime);
            orders.add(dabao);
            orderables.add(dabao);
            System.out.println("Takeaway order added successfully.");
        }

    }

    public static void updateFoodOrder() {
        System.out.println();
        System.out.println("Update a food order");
        for (int i = 0; i < orders.size(); i ++) {
            System.out.println("Index: " + i);
            FoodOrder o = orders.get(i);
            o.display();
            System.out.println();
        }

        System.out.println("Please enter the index of the order you wish to change: ");
        int indexChoice = sc.nextInt();
        sc.nextLine();

        FoodOrder orderToEdit = orders.get(indexChoice);
        orderToEdit.updateInfo(sc);
        System.out.println("Order successfully updated.");
    }

    public static void deleteFoodOrder() {
        System.out.println();
        System.out.println("Delete a food order");
        for (int i = 0; i < orders.size(); i ++) {
            System.out.println("Index: " + i);
            FoodOrder o = orders.get(i);
            o.display();
            System.out.println();
        }

        System.out.println("Please enter the index of the order you wish to remove: ");
        int indexChoice = sc.nextInt();
        sc.nextLine();
        orders.remove(indexChoice);
        System.out.println("Order successfully removed.");
    }

    public static void addDrinks() {
        System.out.println("Add beverage");
        System.out.println("Customer name: ");
        String customerName = sc.nextLine();

        ArrayList<String> drinks = new ArrayList<>();
        ArrayList<Double> drinkPrices = new ArrayList<>();
        ArrayList<Boolean> isDrinksIced = new ArrayList<>();

        while (true) {
            System.out.println("Add a drink: ");
            String drink =  sc.nextLine();
            drinks.add(drink);

            System.out.println("Add a price for " + drink + ": ");
            double drinkPrice =  sc.nextDouble();
            drinkPrices.add(drinkPrice);
            sc.nextLine();

            System.out.println("Do you want it iced? (Y for yes, N for no) ");
            String isIced = sc.nextLine();
            if (isIced.equalsIgnoreCase("Y")) {
                isDrinksIced.add(true);
            } else {
                isDrinksIced.add(false);
            }

            System.out.println("Anymore drinks to add? (Y for yes, N for no) ");
            String drinkChoice = sc.nextLine();
            if (drinkChoice.equalsIgnoreCase("n")) {
                break;
            }

        }


        Drinks d = new Drinks(customerName, drinks, drinkPrices, isDrinksIced);
        drinkList.add(d);
        orderables.add(d);
        System.out.println(drinkList);
        System.out.println(orderables);
    }
}