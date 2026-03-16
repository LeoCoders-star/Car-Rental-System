package Project10;

import java.util.Scanner;

public class CarRentalSystem {

    public static Car[] cars = new Car[100];
    public static Customer[] customers = new Customer[100];
    public static int carCount = 0;
    public static int customerCount = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        OwnerSystem O = new OwnerSystem();
        CustomerSystem C = new CustomerSystem();
        int startMenu;

        while (true) {
            System.out.print("\n=================================================");
            System.out.print("\n        CAR RENTAL SYSTEM");
            System.out.print("\n=================================================");
            System.out.print("\n1. Owner Login");
            System.out.print("\n2. Customer Login");
            System.out.print("\n3. Register Customer");
            System.out.print("\n4. Exit");
            System.out.print("\n=================================================");
            System.out.print("\nEnter your choice : ");
            startMenu = input.nextInt();

            switch (startMenu) {
                case 1:
                    O.ownerLogin();
                    break;

                case 2:
                    C.customerLogin();
                    break;
                
                case 3:
                    C.customerRegister();
                    break;
            
                default:
                    break;
            }
        }
    }
}
