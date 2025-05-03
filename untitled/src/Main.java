import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc;
    public static ArrayList<FoodOrder> orders;
    public static void main(String[] args) {
        orders = new ArrayList<FoodOrder>();
        while (true) {
            sc = new Scanner(System.in);
            System.out.println("Menu:");
            System.out.println("1. Show all orders");
            System.out.println("2. Add a new order");
            System.out.println("3. Update an order");
            System.out.println("4. Delete an order");
            System.out.println("5. Quit");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1) {
                System.out.println("Showing all orders");
            }
            if(choice == 2) {
                System.out.println("Adding orders");
            }
            if(choice == 3) {
                System.out.println("Updating orders");
            }
            if(choice == 4) {
                System.out.println("Deleting orders");
            }
            if(choice == 5) {
                System.out.println("Quitting");
                break;
            }
        }
    }

    public static void getOrderById() {

    }

    public static void showOrders() {
        System.out.println("Showing all orders");
        for (FoodOrder o : orders) {

        }
    }

    public static void addOrder() {}

    public static void updateOrder() {}

    public static void deleteOrder() {}
}